package efimovta.store.controller;

/**
 * Created by jcd on 25.03.2017.
 */
public class SaleControllerFactory  {

    private static SaleController saleController;
    public synchronized SaleController get(){
        if (saleController == null) {
            saleController = new SaleControllerImpl();
        }
        return saleController;
    }
}
