package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.dao.*;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.storage.StorageInMemory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {


    public SIMSaleDAO(ArrayList<Sale> records) {
        super(records);
    }

    /**
     * You can not add a sale to a non-existent client or devices
     *
     * @param sale sale to add
     * @throws RecordAlreadyExistsException
     * @throws RecordNotFoundException
     */
    @Override
    public void add(Sale sale) throws RecordAlreadyExistsException, RecordNotFoundException {
        Sale.Builder sb = Sale.getBuilder();
        sb.setSaleDate(sale.getSaleDate());

        int clientIndex = StorageInMemory.clients.indexOf(sale.getClient());
        if (clientIndex == -1) {
            throw new ClientRecordNotFoundException();
        }
        sb.setClient(StorageInMemory.clients.get(clientIndex));
        ArrayList<Integer> deviceIndexes = new ArrayList<>();
        for (Device device : sale.getDevices().keySet()) {
            int deviceIndex = StorageInMemory.devices.indexOf(device);
            if (deviceIndex==-1) {
                throw new DeviceRecordNotFoundException();
            }
        }

        super.add(sale);
    }

    @Override
    public Sale findById(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.SALE_BY_ID).get(0);
    }

    @Override
    public List<Sale> findByClientId(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.SALE_BY_CLIENT_ID);
    }

    @Override
    public List<Sale> findByDeviceId(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.SALE_BY_DEVICE_ID);
    }

    @Override
    public List<Sale> findBySaleDate(Date saleDate) throws RecordNotFoundException {
        return FindHelper.find(records, saleDate, FindHelper.SALE_BY_SALE_DATE);
    }
}
