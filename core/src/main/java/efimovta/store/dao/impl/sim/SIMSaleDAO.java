package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.Util;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.dao.RecordAlreadyExistsException;
import efimovta.store.dao.RecordNotFoundException;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class provide DAO for {@link Sale}
 * Attempt! Id of added sale was overridden.
 * Id correspond List index.
 */
class SIMSaleDAO extends SIMGenericDAO<Sale> implements SaleDAO {

    /**
     * Stores a copy in the database, replaces the references
     * to the client and devices to the corresponding ones from
     * the database. Attempt! Id war overridden.
     * <br/>
     * You can not add a sale to a non-existent client or with
     * non-exists devices.
     *
     * @param sale sale to add
     * @throws NotAllFieldsAreFilledException if not all filled
     * @throws RecordNotFoundException        If the client or at least
     *                                        one of the devices is not
     *                                        contained in the database
     */
    @Override
    public void add(Sale sale) throws RecordNotFoundException,
            NotAllFieldsAreFilledException {
        checkNullFields(sale);
        Sale newSale = sale.getClone();
        long id = StorageInMemory.getSales().size();
        newSale.setId(id);

        Client client = sale.getClient();
        int clientIndex = StorageInMemory.getClients().indexOf(client);
        if (clientIndex == -1) {
            throw new RecordNotFoundException(
                    "Can't add sale with non exists client: "
                            + client.toString());
        }
        newSale.setClient(StorageInMemory.getClients().get(clientIndex));

        Map<Device, Integer> map = new HashMap<>();
        for (Map.Entry<Device, Integer> entry : sale.getDevices().entrySet()) {
            int deviceIndex =
                    StorageInMemory.getDevices().indexOf(entry.getKey());
            if (deviceIndex == -1) {
                throw new RecordNotFoundException(
                        "Can't add sale with non exists device: "
                                + entry.getKey());
            }
            Device d = StorageInMemory.getDevices().get(deviceIndex);
            int count = entry.getValue();
            map.put(d, count);
        }
        newSale.setDevices(map);

        StorageInMemory.getSales().add(newSale);
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
        List<Sale> list = FindHelper.find(StorageInMemory.getSales(), id,
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
        List<Sale> sales = FindHelper.find(StorageInMemory.getSales(), id,
                FindHelper.SALE_BY_CLIENT_ID);
        if (!sales.isEmpty()) {
            sales = Util.deepCopy(sales);
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
        List<Sale> sales = FindHelper.find(StorageInMemory.getSales(), id,
                FindHelper.SALE_BY_DEVICE_ID);
        if (!sales.isEmpty()) {
            sales = Util.deepCopy(sales);
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
        List<Sale> sales = FindHelper.find(StorageInMemory.getSales(),
                saleDate, FindHelper.SALE_BY_SALE_DATE);
        if (!sales.isEmpty()) {
            sales = Util.deepCopy(sales);
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
        if (StorageInMemory.getSales().isEmpty()) {
            sales = new ArrayList<>(0);
        } else {
            sales = Util.deepCopy(StorageInMemory.getSales());
        }
        return sales;
    }

    /**
     * Check the Sale fields
     *
     * @param s for check
     * @throws NotAllFieldsAreFilledException if any field is null
     */
    @Override
    protected void checkNullFields(Sale s) throws
            NotAllFieldsAreFilledException {
        if (s.getSaleDate() == null) {
            throw new NotAllFieldsAreFilledException(
                    "sale.getSaleDate() return null");
        }
        if (s.getClient() == null) {
            throw new NotAllFieldsAreFilledException(
                    "sale.getClient() return null");
        }
        if (s.getDevices() == null) {
            throw new NotAllFieldsAreFilledException(
                    "sale.getDevices() return null");
        }
    }

    /**
     * Checks. Does the Sale record exist
     *
     * @param s for check
     * @throws RecordAlreadyExistsException if record
     *                                      already exists
     */
    @Override
    protected void checkAlreadyExists(Sale s)
            throws RecordAlreadyExistsException {
        int i = StorageInMemory.getSales().indexOf(s);
        if (i != -1) {
            long id = StorageInMemory.getSales().get(i).getId();
            throw new RecordAlreadyExistsException(
                    "This sale exists with id: " + id);
        }
    }
}
