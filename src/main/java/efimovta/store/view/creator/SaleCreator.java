package efimovta.store.view.creator;

import efimovta.store.controller.SaleController;
import efimovta.store.controller.SaleControllerFactory;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.view.creator.requester.SaleParamsRequester;
import efimovta.store.view.exception.OperationCanceledByUserException;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by jcd on 13.03.2017.
 */
public class SaleCreator extends Creator {//todo mb singleton



    @Override
    public void startCreationDialog() throws IOException, OperationCanceledByUserException {
        SaleController clientController = (new SaleControllerFactory()).get();
        SaleParamsRequester spr = SaleParamsRequester.getInstance();

        Client client = spr.requestClient();
        Date saleDate = new Date();
        Map<Device, Integer> devices=null;


        Sale sale = Sale.getBuilder()
                .setClient(client)
                .setDevices(devices)
                .setSaleDate(saleDate)
                .build();


        try {
            clientController.addNewSale(sale);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

    }



}
