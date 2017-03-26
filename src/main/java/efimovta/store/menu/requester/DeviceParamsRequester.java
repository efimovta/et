package efimovta.store.menu.requester;

import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;
import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 26.03.2017.
 */
public class DeviceParamsRequester extends Requester {
    private static DeviceParamsRequester ourInstance = new DeviceParamsRequester();

    public static DeviceParamsRequester getInstance() {
        return ourInstance;
    }

    private DeviceParamsRequester() {
    }

    public BigDecimal requestPrice() throws IOException, OperationCanceledByUserException {
        System.out.println("Введите цену устройства в шавермах (Например: 13.57)");
        BigDecimal price = null;
        while (true) {
            String str = getReader().readLine();
            if (str.equals(EXIT_SYMBOL)) throw new OperationCanceledByUserException();

            try {
                price = new BigDecimal(str);
            } catch (NumberFormatException e) {
                System.err.println(INPUT_ERROR_MSG);
                continue;
            }

            if (price.doubleValue() > 0) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return price;
    }

    public Date requestReleaseDate() throws IOException, OperationCanceledByUserException {
        System.out.println("Введите датту релиза устройства(Например: 17.01.2017)");
        return requestDate();
    }

    public NamedColor requestColor() throws IOException, OperationCanceledByUserException {
        int i = 1;

        System.out.println("Выбирите цвет устройства(Например: 1)");
        List<NamedColor> ncs = Arrays.asList(NamedColor.values());
        for (NamedColor ncsi : ncs) {
            System.out.println(i++ + ". " + ncsi);
        }

        int otv = requestIntNumber(1, ncs.size());

        return ncs.get(otv - 1);
    }

    public Brand requestBrand() throws IOException, OperationCanceledByUserException {
        int i = 1;

        System.out.println("Выбирите бренд устройства(Например: 1)");
        List<Brand> brands = Arrays.asList(Brand.values());
        for (Brand brandi : brands) {
            System.out.println(i++ + ". " + brandi);
        }

        int otv = requestIntNumber(1, brands.size());

        return brands.get(otv - 1);
    }

    public DeviceType requestType() throws IOException, OperationCanceledByUserException {
        DeviceType dt = null;
        int i = 1;

        System.out.println("Выбирите тип устройства(Например: 1)");
        List<DeviceType> dts = Arrays.asList(DeviceType.values());
        for (DeviceType dti : dts) {
            System.out.println(i++ + ". " + dti);
        }

        int otv = requestIntNumber(1, dts.size());

        return dts.get(otv - 1);
    }

    public String requestModel() throws IOException, OperationCanceledByUserException {
        System.out.println("Введите наименование модели устройства(Например: GTX-1057)");
        String model = null;
        while (true) {
            String str = getReader().readLine();
            if (str.equals(EXIT_SYMBOL)) throw new OperationCanceledByUserException();

            model = str.trim();
            if (!model.isEmpty()) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return model;
    }
}
