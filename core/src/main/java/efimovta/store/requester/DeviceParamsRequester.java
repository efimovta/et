package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.entity.Brand;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static efimovta.store.Messages.ENTER_DEVICE_BRAND;
import static efimovta.store.Messages.ENTER_DEVICE_COLOR;
import static efimovta.store.Messages.ENTER_DEVICE_MODEL;
import static efimovta.store.Messages.ENTER_DEVICE_PRICE;
import static efimovta.store.Messages.ENTER_DEVICE_RELEASE;
import static efimovta.store.Messages.ENTER_DEVICE_TYPE;

/**
 * Device params requester. Used for request device params.
 */
public class DeviceParamsRequester extends Requester {
    private static DeviceParamsRequester ourInstance =
            new DeviceParamsRequester();

    private DeviceParamsRequester() {
    }

    /**
     * @return Singleton {@link ClientParamsRequester}
     */
    public static DeviceParamsRequester getInstance() {
        return ourInstance;
    }

    /**
     * Request price
     *
     * @return requested price
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public BigDecimal requestPrice() throws OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_PRICE);
        BigDecimal price = null;
        while (price == null || price.doubleValue() <= 0) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            try {
                price = new BigDecimal(str);
            } catch (NumberFormatException e) {
                Util.println(INPUT_ERROR_MSG);
                continue;
            }

            if (price.doubleValue() <= 0) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return price;
    }

    /**
     * Request release date
     *
     * @return requested date
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public Date requestReleaseDate() throws OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_RELEASE);
        return requestDate();
    }

    /**
     * Request color
     *
     * @return requested color
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public NamedColor requestColor() throws OperationCanceledByUserException {
        int i = 1;

        Util.println(ENTER_DEVICE_COLOR);
        List<NamedColor> ncs = Arrays.asList(NamedColor.values());
        for (NamedColor ncsi : ncs) {
            Util.println(i++ + ". " + ncsi);
        }

        int otv = requestIntNumber(1, ncs.size());

        return ncs.get(otv - 1);
    }

    /**
     * Request brand
     *
     * @return requested brand
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public Brand requestBrand() throws OperationCanceledByUserException {
        int i = 1;

        Util.println(ENTER_DEVICE_BRAND);
        List<Brand> brands = Arrays.asList(Brand.values());
        for (Brand brandi : brands) {
            Util.println(i++ + ". " + brandi);
        }

        int otv = requestIntNumber(1, brands.size());

        return brands.get(otv - 1);
    }

    /**
     * Request type
     *
     * @return requested type
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public DeviceType requestType() throws OperationCanceledByUserException {
        int i = 1;

        Util.println(ENTER_DEVICE_TYPE);
        List<DeviceType> dts = Arrays.asList(DeviceType.values());
        for (DeviceType dti : dts) {
            Util.println(i++ + ". " + dti);
        }

        int otv = requestIntNumber(1, dts.size());

        return dts.get(otv - 1);
    }

    /**
     * Request model
     *
     * @return requested model
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public String requestModel() throws OperationCanceledByUserException {
        Util.println(ENTER_DEVICE_MODEL);
        String model = null;
        while (model == null || model.isEmpty()) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            model = str.trim();
            if (model.isEmpty()) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return model;
    }
}
