package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.entity.Brand;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static efimovta.store.Messages.*;

/**
 * Created by jcd on 26.03.2017.
 */
public class DeviceParamsRequester extends Requester {
    private static DeviceParamsRequester ourInstance =
            new DeviceParamsRequester();

    public static DeviceParamsRequester getInstance() {
        return ourInstance;
    }

    private DeviceParamsRequester() {
    }

    public BigDecimal requestPrice() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_PRICE);
        BigDecimal price = null;
        while (true) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            try {
                price = new BigDecimal(str);
            } catch (NumberFormatException e) {
                Util.printErr(INPUT_ERROR_MSG);
                continue;
            }

            if (price.doubleValue() > 0) break;
            else Util.printErr(INPUT_ERROR_MSG);
        }
        return price;
    }

    public Date requestReleaseDate() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_RELEASE);
        return requestDate();
    }

    public NamedColor requestColor() throws IOException,
            OperationCanceledByUserException {
        int i = 1;

        Util.println(ENTER_DEVICE_COLOR);
        List<NamedColor> ncs = Arrays.asList(NamedColor.values());
        for (NamedColor ncsi : ncs) {
            Util.println(i++ + ". " + ncsi);
        }

        int otv = requestIntNumber(1, ncs.size());

        return ncs.get(otv - 1);
    }

    public Brand requestBrand() throws IOException,
            OperationCanceledByUserException {
        int i = 1;

        Util.println(ENTER_DEVICE_BRAND);
        List<Brand> brands = Arrays.asList(Brand.values());
        for (Brand brandi : brands) {
            Util.println(i++ + ". " + brandi);
        }

        int otv = requestIntNumber(1, brands.size());

        return brands.get(otv - 1);
    }

    public DeviceType requestType() throws IOException,
            OperationCanceledByUserException {
        DeviceType dt = null;
        int i = 1;

        Util.println(ENTER_DEVICE_TYPE);
        List<DeviceType> dts = Arrays.asList(DeviceType.values());
        for (DeviceType dti : dts) {
            Util.println(i++ + ". " + dti);
        }

        int otv = requestIntNumber(1, dts.size());

        return dts.get(otv - 1);
    }

    public String requestModel() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_MODEL);
        String model = null;
        while (true) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            model = str.trim();
            if (!model.isEmpty()) break;
            else Util.printErr(INPUT_ERROR_MSG);
        }
        return model;
    }
}
