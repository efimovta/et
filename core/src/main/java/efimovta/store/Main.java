package efimovta.store;

import efimovta.store.dao.impl.sim.StorageInMemory;
import efimovta.store.menu.MenuManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import static efimovta.store.Config.BACKUP_LOCATION;
import static efimovta.store.Messages.*;

/**
 * Created by jcd on 19.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Util.log.info(APP_START);

        File file = new File(BACKUP_LOCATION);
        if (file.exists()) {
            try {
                StorageInMemory.loadBackup(file);
            } catch (FileNotFoundException e) {
                Util.printErr(e.getMessage());
                Util.log.log(Level.SEVERE,
                        "problem with loading backup ("
                                + BACKUP_LOCATION + ");", e);
                Util.println("standard filler was activated");
                StorageFiller.fillStorage();
            } catch (BackupException e) {
                //todo chose

            }
        } else {
            StorageFiller.fillStorage();
        }
        Util.log.info(STORAGE_FILLED);


        try {
            MenuManager.startDialog();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ExitException e) {
            //ok
        }

        try {
            StorageInMemory.saveBackup(file);
        } catch (FileNotFoundException e) {
            Util.printErr(e.getMessage());
            Util.log.log(Level.SEVERE,
                    "problem with saving backup ("
                            + BACKUP_LOCATION + ");", e);
        } catch (BackupException e) {
            //todo chose
        }
        Util.log.info(APP_SUCCESSFULLY_CLOSED);

    }


}
