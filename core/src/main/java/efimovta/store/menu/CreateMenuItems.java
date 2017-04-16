package efimovta.store.menu;

import efimovta.store.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.*;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class CreateMenuItems extends MenuItems {
    static private final MenuItems instance = new CreateMenuItems();
    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CLIENT_ADDING) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        Creator.startClientCreationDialog();
                        Utility.println(THE_CLIENT_WAS_SUCCESSFULLY_ADDED);
                    }
                },
                new MenuItem(DEVICE_ADDING) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        Creator.startDeviceCreationDialog();
                        Utility.println(THE_DEVICE_WAS_SUCCESSFULLY_ADDED);
                    }
                },
                new MenuItem(SALE_ADDING) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        Creator.startSaleCreationDialog();
                        Utility.println(THE_SALE_WAS_SUCCESSFULLY_ADDED);
                    }
                },
                new MenuItem(BACK_TO_MAIN_MENU) {
                    @Override
                    public void execute() throws IOException {
                        setNext(MainMenuItems.getInstance());
                    }
                }
        ));
    }

    public static MenuItems getInstance() {
        return instance;
    }

    private CreateMenuItems() {
        super(CREATE_MENU_NAME);
    }

    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }
}
