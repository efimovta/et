package efimovta.store.menu.creator;

import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.requester.SaleParamsRequester;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by jcd on 13.03.2017.
 */
public class SaleCreator extends Creator {//todo mb singleton



    @Override
    public void startCreationDialog() throws IOException, OperationCanceledByUserException {
        SaleDAO saleDAO = DAOFactory.get().getSaleDAO();
        SaleParamsRequester spr = SaleParamsRequester.getInstance();

        Client client = spr.requestClient();
        Date saleDate = new Date();
        Map<Device, Integer> devices=null;//TODO CREATE REQUESTER FOR DEVICES


        Sale sale = Sale.getBuilder()
                .setClient(client)
                .setDevices(devices)
                .setSaleDate(saleDate)
                .build();

        //todo validator?

        try {
            saleDAO.add(sale);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

    }



}
