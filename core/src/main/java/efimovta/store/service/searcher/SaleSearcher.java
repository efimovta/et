package efimovta.store.service.searcher;

import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.Sale;

import java.util.List;

/**
 * Searching sales in interactive mode. Singleton.
 */
public class SaleSearcher implements Searcher<Sale> {
    private static SaleSearcher ourInstance = new SaleSearcher();
    private static SaleDAO saleDAO = DAOFactory.get().getSaleDAO();

    protected SaleSearcher() {

    }

    /**
     * @return Singleton {@link SaleSearcher}
     */
    public static SaleSearcher getInstance() {
        return ourInstance;
    }

    /**
     * @return all sales
     */
    public List<Sale> findAll() {
        return saleDAO.getAll();
    }
}
