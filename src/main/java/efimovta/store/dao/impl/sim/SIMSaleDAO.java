package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.dao.*;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.io.Serializable;
import java.util.*;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {


    public SIMSaleDAO(ArrayList<Sale> records) {
        super(records);
    }

    /**
     * Stores a copy in the database, replaces the references to the client
     * and devices to the corresponding ones from the database.
     * <br/>
     * You can not add a sale to a non-existent client or with non-exists
     * devices
     *
     * @param sale sale to add
     * @throws RecordAlreadyExistsException
     * @throws RecordNotFoundException      If the client or at least one
     *                                      of the devices is not contained
     *                                      in the database
     */
    @Override
    public void add(Sale sale) throws RecordAlreadyExistsException,
            RecordNotFoundException {
        Sale newSale = new Sale();
        newSale.setSaleDate(sale.getSaleDate());

        int clientIndex = StorageInMemory.clients.indexOf(sale.getClient());
        if (clientIndex == -1) {
            throw new ClientRecordNotFoundException();
        }
        newSale.setClient(StorageInMemory.clients.get(clientIndex));

        Map<Device, Integer> map = new HashMap<>();
        for (Map.Entry<Device, Integer> entry : sale.getDevices().entrySet()) {
            int deviceIndex = StorageInMemory.devices.indexOf(entry.getKey());
            if (deviceIndex == -1) {
                throw new DeviceRecordNotFoundException(
                        "Attempt to add the sale of a non-existent device: "
                                + entry.getKey());
            }
            Device d = StorageInMemory.devices.get(deviceIndex);
            int count = entry.getValue();
            map.put(d, count);
        }
        newSale.setDevices(map);

        records.add(newSale);
    }

    @Override
    public Sale findById(long id) throws DAOException {
        Sale s = FindHelper.find(records, id, FindHelper.SALE_BY_ID).get(0);
        return serialize(s);
    }

    @Override
    public List<Sale> findByClientId(long id) throws DAOException {
        List<Sale> list = FindHelper.find(records, id,
                FindHelper.SALE_BY_CLIENT_ID);
        return (List<Sale>) serialize((Serializable) list);
    }

    @Override
    public List<Sale> findByDeviceId(long id) throws DAOException {
        List<Sale> list = FindHelper.find(records, id,
                FindHelper.SALE_BY_DEVICE_ID);
        return (List<Sale>) serialize((Serializable) list);
    }

    @Override
    public List<Sale> findBySaleDate(Date saleDate) throws DAOException {
        List<Sale> list = FindHelper.find(records, saleDate,
                FindHelper.SALE_BY_SALE_DATE);
        return (List<Sale>) serialize((Serializable) list);
    }
}
