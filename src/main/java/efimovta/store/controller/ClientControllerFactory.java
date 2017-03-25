package efimovta.store.controller;

/**
 * Created by jcd on 25.03.2017.
 */
public class ClientControllerFactory {
    private static ClientController clientController;
    public synchronized ClientController get(){
        if (clientController == null) {
            clientController = new ClientControllerImpl();
        }
        return clientController;
    }
}
