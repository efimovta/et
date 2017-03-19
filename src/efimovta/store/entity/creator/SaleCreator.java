package efimovta.store.entity.creator;

import java.io.BufferedReader;

/**
 * Created by jcd on 13.03.2017.
 */
public class SaleCreator extends Creator {
    public SaleCreator(BufferedReader br) {
        super(br);
    }

    public SaleCreator(BufferedReader br, int numberOfAttempts) {
        super(br, numberOfAttempts);
    }


}
