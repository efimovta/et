package efimovta.store.view.creator.requester;

import efimovta.store.dao.entity.Client;
import efimovta.store.view.exception.OperationCanceledByUserException;

import java.io.IOException;

/**
 * Created by jcd on 26.03.2017.
 */
public class SaleParamsRequester extends Requester {
    private static SaleParamsRequester ourInstance = new SaleParamsRequester();

    public static SaleParamsRequester getInstance() {
        return ourInstance;
    }

    private SaleParamsRequester() {
    }


    public Client requestClient() throws IOException, OperationCanceledByUserException {
        Client client = null;
        System.out.println("Введите id клиента(Например, 777):");
        int id = requestIntNumber(0,Integer.MAX_VALUE);
        client =


        return client;
    }


}
