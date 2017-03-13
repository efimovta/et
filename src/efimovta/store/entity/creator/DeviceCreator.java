package efimovta.store.entity.creator;

import efimovta.store.entity.Device;
import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;
import efimovta.store.enums.NamedColor;
import efimovta.store.exception.ExceededAttemptsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 13.03.2017.
 */
public class DeviceCreator extends Requester {

    public DeviceCreator(BufferedReader br) {
        super(br);
    }

    public DeviceCreator(BufferedReader br, int numberOfAttempts) {
        super(br, numberOfAttempts);
    }


    public Device createDevice() throws IOException, ExceededAttemptsException {
        DeviceType type = requestType();
        String model = requestModel();
        Brand brand = requestBrand();
        NamedColor color = requestColor();
        Date releaseDate = requestReleaseDate();
        BigDecimal price = requestPrice();

        return new Device(model, type, brand, color, releaseDate, price);
    }

    public BigDecimal requestPrice() throws IOException, ExceededAttemptsException {
        System.out.println("Введите цену устройства в шавермах (Например: 13.57)");
        BigDecimal price = null;
        for (int i = 1; i <= NUMBER_OF_ATTEMPTS; i++) {
            String strDate = br.readLine();
            price = new BigDecimal(strDate);

            if (price.doubleValue() > 0) break;
            else if (i < NUMBER_OF_ATTEMPTS)
                System.err.println(ERR_IN_MSG + (NUMBER_OF_ATTEMPTS - i));
            else throw new ExceededAttemptsException();
        }
        return price;
    }

    public Date requestReleaseDate() throws IOException, ExceededAttemptsException {
        System.out.println("Введите датту релиза устройства(Например: 17.01.2017)");
        return requestDate();
    }

    public NamedColor requestColor() throws IOException, ExceededAttemptsException {
        int i = 1;

        System.out.println("Выбирите цвет устройства(Например: 1)");
        List<NamedColor> ncs = Arrays.asList(NamedColor.values());
        for (NamedColor ncsi : ncs) {
            System.out.println(i++ + ". " + ncsi);
        }

        int otv = requestIntNumber(1, ncs.size());

        return ncs.get(otv - 1);
    }

    public Brand requestBrand() throws IOException, ExceededAttemptsException {
        int i = 1;

        System.out.println("Выбирите бренд устройства(Например: 1)");
        List<Brand> brands = Arrays.asList(Brand.values());
        for (Brand brandi : brands) {
            System.out.println(i++ + ". " + brandi);
        }

        int otv = requestIntNumber(1, brands.size());

        return brands.get(otv - 1);
    }

    public DeviceType requestType() throws IOException, ExceededAttemptsException {
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

    public String requestModel() throws IOException, ExceededAttemptsException {
        System.out.println("Введите наименование модели устройства(Например: GTX-1057)");
        String model = null;
        for (int i = 1; i <= NUMBER_OF_ATTEMPTS; i++) {
            model = br.readLine().trim();
            if (!model.isEmpty()) break;
            else if (i < NUMBER_OF_ATTEMPTS)
                System.err.println(ERR_IN_MSG + (NUMBER_OF_ATTEMPTS - i));
            else throw new ExceededAttemptsException();
        }
        return model;
    }
}
