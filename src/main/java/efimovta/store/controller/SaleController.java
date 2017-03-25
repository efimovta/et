package efimovta.store.controller;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.DAOException;

import java.util.List;

/**
 * Created by jcd on 25.03.2017.
 */
public abstract class SaleController {
    public abstract void addNewSale(Sale sale) throws DAOException;
    public abstract List<Sale> geT
}
