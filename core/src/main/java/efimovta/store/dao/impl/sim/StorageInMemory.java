package efimovta.store.dao.impl.sim;

import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * It contains lists representing the storage in memory
 */
public class StorageInMemory {
    static final List<Client> clientRecords = new ArrayList<>();
    static final List<Device> deviceRecords = new ArrayList<>();
    static final List<Sale> saleRecords = new ArrayList<>();
}