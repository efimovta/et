package efimovta.store.entity.creator;

import efimovta.store.BD;
import efimovta.store.exception.OperationException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by EFIMOVAT on 13.03.2017.
 */
public class Creator {
    final public ClientCreator clientCreator;
    final public DeviceCreator deviceCreator;
    final public SaleCreator saleCreator;

    BufferedReader br;

    public Creator(BufferedReader br) {
        this.br = br;
        this.clientCreator = new ClientCreator(br);
        this.deviceCreator = new DeviceCreator(br);
        this.saleCreator = new SaleCreator(br);
    }

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
                    case 1:
                        BD.clients.add(clientCreator.createClient());
                        System.out.println("Клиент успешно добавлен.");
                        break;
                    case 2:
                        BD.devices.add(deviceCreator.createDevice());
                        System.out.println("Устройство успешно добавлено.");
                        break;
                    case 3:
                        System.err.println("Магазин закрыт.");
                        break;
                    case 4:
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
