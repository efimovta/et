package efimovta.store.dao.sim;

import efimovta.store.storage.StorageInMemory;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.exeption.RecordAlreadyExistsException;
import efimovta.store.dao.exeption.RecordNotFoundException;
import efimovta.store.dao.sim.helper.FindHelper;
import efimovta.store.entity.Sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {

    @Override
    public Sale record(Sale object) throws RecordAlreadyExistsException {
        StorageInMemory.clients.add(object.getClient());
        StorageInMemory.devices.addAll(object.getDevices().keySet());
        return super.record(object);
    }

    public SIMSaleDAO(ArrayList<Sale> records) {
        super(records);
    }

    @Override
    public List<Sale> findBySaleId(int id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.BY_ID);
    }

    @Override
    public List<Sale> findByClientId(int id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.SALE_BY_CLIENT_ID);
    }

    @Override
    public List<Sale> findByDeviceId(int id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.SALE_BY_DEVICE_ID);
    }

    @Override
    public List<Sale> findBySaleDate(Date saleDate) throws RecordNotFoundException {
        return FindHelper.find(records, saleDate, FindHelper.SALE_BY_SALE_DATE);
    }
}