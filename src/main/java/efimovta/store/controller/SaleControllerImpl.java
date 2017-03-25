package efimovta.store.controller;

import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;

/**
 * Created by jcd on 25.03.2017.
 */
public class SaleControllerImpl extends SaleController {
    SaleDAO saleDAO = DAOFactory.get().getSaleDAO();
    @Override
    public void addNewSale(Sale sale) throws DAOException {
        //todo validator?
        saleDAO.add(sale);
    }
}
