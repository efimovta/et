package efimovta.store.entity.creator;

import efimovta.store.storage.StorageInMemory;
import efimovta.store.exception.OperationException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The class contains only one method that represents "create a menu"
 */
public class CreateMenu {
    private static final int ADDING_A_CLIENT = 1;
    private static final int ADDING_A_DEVICE = 2;
    private static final int ADDING_A_SALE = 3;
    private static final int RETURN_TO_MAIN_MENU = 4;

    final public ClientCreator clientCreator;
    final public DeviceCreator deviceCreator;
    final public SaleCreator saleCreator;

    BufferedReader br;

    public CreateMenu(BufferedReader br) {
        this.br = br;
        this.clientCreator = new ClientCreator(br);
        this.deviceCreator = new DeviceCreator(br);
        this.saleCreator = new SaleCreator(br);
    }

    /**
     * represents "create a menu"
     * @throws IOException
     */
    public void startDialog() throws IOException {
        while (true) {
            System.out.println("\n### Добавление ###");
            System.out.println("1. Добавление клиента");
            System.out.println("2. Добавление устройства");
            System.out.println("3. Добавление продажи");
            System.out.println("4. Возврат к главному меню");
            System.out.println("Выбирете действие:");

            int otv = Integer.parseInt(br.readLine());

            try {
                switch (otv) {
                    case ADDING_A_CLIENT:
                        StorageInMemory.clients.add(clientCreator.createClient());
                        System.out.println("Клиент успешно добавлен.");
                        break;
                    case ADDING_A_DEVICE:
                        StorageInMemory.devices.add(deviceCreator.createDevice());
                        System.out.println("Устройство успешно добавлено.");
                        break;
                    case ADDING_A_SALE:
                        System.err.println("Магазин закрыт.");
                        break;
                    case RETURN_TO_MAIN_MENU:
                        return;
                    default:
                        System.err.println("Неверный ввод.");
                }
            } catch (OperationException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
