package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.Utility;
import efimovta.store.dao.*;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.util.*;

/**
 * Class provide DAO for {@link Sale}
 */
public class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {
    protected List<Client> clientRecords = StorageInMemory.clientRecords;
    protected List<Device> deviceRecords = StorageInMemory.deviceRecords;
    protected List<Sale> saleRecords = StorageInMemory.saleRecords;

    /**
     * Stores a copy in the database, replaces the references
     * to the client and devices to the corresponding ones from
     * the database.
     * <br/>
     * You can not add a sale to a non-existent client or with
     * non-exists devices
     *
     * @param sale sale to add
     * @throws RecordAlreadyExistsException if exists
     * @throws RecordNotFoundException      If the client or at least
     *                                      one of the devices is not
     *                                      contained in the database
     */
    @Override
    public void add(Sale sale) throws RecordAlreadyExistsException,
            RecordNotFoundException {
        Sale newSale = new Sale(sale);

        int clientIndex = clientRecords.indexOf(sale.getClient());
        if (clientIndex == -1) {
            throw new ClientRecordNotFoundException();
        }
        newSale.setClient(clientRecords.get(clientIndex));

        Map<Device, Integer> map = new HashMap<>();
        for (Map.Entry<Device, Integer> entry : sale.getDevices().entrySet()) {
            int deviceIndex = deviceRecords.indexOf(entry.getKey());
            if (deviceIndex == -1) {
                throw new DeviceRecordNotFoundException(
                        "Attempt to add the sale of a non-existent device: "
                                + entry.getKey());
            }
            Device d = deviceRecords.get(deviceIndex);
            int count = entry.getValue();
            map.put(d, count);
        }
        newSale.setDevices(map);

        saleRecords.add(newSale);
    }

    /**
     * Sale search by id
     *
     * @param id id of sale
     * @return founded sale or null otherwise
     */
    @Override
    public Sale findById(long id) {
        Sale sale = null;
        List<Sale> list = FindHelper.find(saleRecords, id,
                FindHelper.SALE_BY_ID);
        if (!list.isEmpty()) {
            sale = list.get(0).getClone();
        }
        return sale;
    }

    /**
     * Sale search by client id
     *
     * @param id id of client
     * @return founded sale or null otherwise
     */
    @Override
    public List<Sale> findByClientId(long id) {
        List<Sale> sales = FindHelper.find(saleRecords, id,
                FindHelper.SALE_BY_CLIENT_ID);
        if (!sales.isEmpty()) {
            sales = Utility.deepCopy(sales);
        }
        return sales;
    }

    /**
     * Sale search by device id
     *
     * @param id id of device
     * @return founded sale or null otherwise
     */
    @Override
    public List<Sale> findByDeviceId(long id) {
        List<Sale> sales = FindHelper.find(saleRecords, id,
                FindHelper.SALE_BY_DEVICE_ID);
        if (!sales.isEmpty()) {
            sales = Utility.deepCopy(sales);
        }
        return sales;
    }

    /**
     * Sale search by sale date
     *
     * @param saleDate sale date
     * @return founded sales or empty list otherwise
     */
    @Override
    public List<Sale> findBySaleDate(Date saleDate) {
        List<Sale> sales = FindHelper.find(saleRecords, saleDate,
                FindHelper.SALE_BY_SALE_DATE);
        if (!sales.isEmpty()) {
            sales = Utility.deepCopy(sales);
        }
        return sales;
    }

    /**
     * Get all sales
     *
     * @return all sales or empty list if not exists
     */
    @Override
    public List<Sale> getAll() {
        List<Sale> sales;
        if (saleRecords.size() == 0) {
            sales = new ArrayList<>(0);
        } else {
            sales = Utility.deepCopy(saleRecords);
        }
        return sales;
    }

    @Override
    protected void checkNullFields(Sale sale) throws
            NotAllFieldsAreFilledException {
        if (sale.getSaleDate() == null
                || sale.getClient() == null
                || sale.getDevices() == null) {
            throw new NotAllFieldsAreFilledException();
        }
    }

    @Override
    protected void checkAlreadyExists(Sale s)
            throws RecordAlreadyExistsException {
        if (saleRecords.contains(s)) {
            throw new RecordAlreadyExistsException();
        }
    }
}
