package efimovta.store.dao.impl.sim;

import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.ClientRecordNotFoundException;
import efimovta.store.dao.exeption.DeviceRecordNotFoundException;
import efimovta.store.dao.exeption.RecordAlreadyExistsException;
import efimovta.store.dao.exeption.RecordNotFoundException;
import efimovta.store.dao.impl.sim.helper.FindHelper;
import efimovta.store.storage.StorageInMemory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {

    /**
     * You can not add a purchase to a client or device that does not exist in the database
     * @param sale sale to add
     * @return the added sale
     * @throws RecordAlreadyExistsException
     * @throws RecordNotFoundException
     */
    @Override
    public Sale add(Sale sale) throws RecordAlreadyExistsException, RecordNotFoundException {
        if(!StorageInMemory.clients.contains(sale.getClient())){
            throw new ClientRecordNotFoundException();
        }
        for (Device device : sale.getDevices().keySet()) {
            if(!StorageInMemory.devices.contains(device)){
                throw new DeviceRecordNotFoundException();
            }
        }
        return super.add(sale);
    }

    public SIMSaleDAO(ArrayList<Sale> records) {
        super(records);
    }

    @Override
    public List<Sale> findBySaleId(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.BY_ID);
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
