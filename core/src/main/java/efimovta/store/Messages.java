package efimovta.store;

/**
 * Class contains used Messages
 */
public class Messages {
    public static final String COMPANY_NAME =
            "\n### Компания \"Horns and hooves and your super device\" ###";

    /* For logger */
    public static final String APP_START = "Application started";
    public static final String APP_SUCCESSFULLY_CLOSED =
            "Приложение успешно завершено";
    public static final String STORAGE_FILLED_WITH_AUTO_GENERATED_DATA = "storage filled with auto-generated data";

    /* MenuManager names */
    public static final String DEFAULT_MENU_NAME = "### MenuManager ###";
    public static final String MAIN_MENU = COMPANY_NAME;
    public static final String CREATE_MENU_NAME = "\n### Добавление ###";
    public static final String SEARCH_MENU_NAME = "\n### Поиск ###";
    public static final String SORTEDVIEW_MENU_NAME = "\n### Просмотр ###";

    /* Common menu items */
    public static final String SELECT_ACTION = "Выбирете действие:";
    public static final String INVALID_INPUT = "Неверный ввод.";
    public static final String EXIT = "Выход";
    public static final String BACK_TO_MAIN_MENU =
            "Возвращение к главному меню";
    public static final String THE_OPERATION_WAS_SUCCESSFULLY_CANCELED =
            "Операция успешно отменена.";

    /* Main menu */
    public static final String CREATING = "Добавление";
    public static final String SEARCHING = "Поиск";
    public static final String VIEWING_SORTED =
            "Просмотр в отсортированном виде";

    /* Create menu */
    public static final String CLIENT_ADDING = "Добавление клиента";
    public static final String DEVICE_ADDING = "Добавление устройства";
    public static final String SALE_ADDING = "Добавление продажи";

    /* Result from create menu*/
    public static final String THE_CLIENT_WAS_SUCCESSFULLY_ADDED =
            "Клиент успешно добавлен.";
    public static final String THE_DEVICE_WAS_SUCCESSFULLY_ADDED =
            "Устройство успешно добавлено.";
    public static final String THE_SALE_WAS_SUCCESSFULLY_ADDED =
            "Продажа успешно добавлена.";

    /* Search menu */
    public static final String ALL_CLIENTS = "Все клиенты";
    public static final String ALL_DEVICES = "Все устройства";
    public static final String ALL_SALES = "Все продажи";
    public static final String SEARCHING_CLIENTS_BY_FIO =
            "Поиск клиента(ов) по ФИО";
    public static final String SEARCHING_CLIENTS_BY_ANY_NAME =
            "Поиск клиента(ов) по имени(любому)";
    public static final String SEARCHING_DEVICES_BY_BRAND =
            "Поиск устройств по марке";
    public static final String SEARCHING_DEVICES_BY_TYPE =
            "Поиск устройств по типу";
    public static final String SEARCHING_DEVICES_BY_RELEASE_DATE =
            "Поиск устройств по году выпуска";

    /* Sorted view menu for clients */
    public static final String VIEWING_CLIENTS_SORTED_BY_NAME =
            "Просмотр клиентов, отстортированных по ФИО";
    public static final String VIEWING_CLIENTS_SORTED_BY_BIRTHDAY =
            "Просмотр клиентов, отстортированных по дням рождения";

    /* Sorted view menu for devices */
    public static final String VIEWING_DEVICES_SORTED_BY_RELEASE_DATE =
            "Просмотр устройств, отстортированных по датте выпуска";
    public static final String VIEWING_DEVICES_SORTED_BY_BRAND =
            "Просмотр устройств, отстортированных по бренду";
    public static final String VIEWING_DEVICES_SORTED_BY_TYPE =
            "Просмотр устройств, отстортированных по типу";
    public static final String VIEWING_DEVICES_SORTED_BY_MODEL =
            "Просмотр устройств, отстортированных по модели";

    /* Sorted view menu for sales */
    public static final String VIEWING_SALES_SORTED_BY_SALE_DATE =
            "Просмотр продаж, отстортированных по времени продажи";
    public static final String VIEWING_DEVICES_SORTED_BY_CLIENT_ID =
            "Просмотр продаж, отстортированных по id клиента";
    public static final String MENU_ITEM_EXECUTE_THOW_EXCEPTION =
            "Ошибка выполнения пункта меню.";

    /* For client params requester */
    public static final String ENTER_CLIENT_BIRTHDAY =
            "Введите дату рождения клиента(Например: 13.11.1995)";
    public static final String ENTER_CLIENT_FIO =
            "Введите ФИО(Например: Васильев Вася Васильевич)";
    public static final String ENTER_ANY_CLIENT_NAME =
            "Введите любое имя(Например: Васильев)";

    /* For device params requester */
    public static final String ENTER_DEVICE_PRICE =
            "Введите цену устройства в шавермах (Например: 13.57)";
    public static final String ENTER_DEVICE_RELEASE =
            "Введите датту релиза устройства(Например: 17.01.2017)";
    public static final String ENTER_DEVICE_COLOR =
            "Выбирите цвет устройства(Например: 1)";
    public static final String ENTER_DEVICE_BRAND =
            "Выбирите бренд устройства(Например: 1)";
    public static final String ENTER_DEVICE_TYPE =
            "Выбирите тип устройства(Например: 1)";
    public static final String ENTER_DEVICE_MODEL =
            "Введите наименование модели устройства(Например: GTX-1057)";
    public static final String ENTER_SALE_CLIENT_ID =
            "Введите id клиента(Например, 777):";
    public static final String ENTER_SALE_DEVICE_ID_AND_COUNT =
            "Введите id устройства и колличество(Например, 13 2):";
    public static final String CLIENT_NOT_FOUND = "Клиент не найден";
    public static final String DEVICE_NOT_FOUND = "Устройство не найдено";
    public static final String PRESS_TO_END = "Для завершения ввода введи: ";
    public static final String DEVICE_ADDED_TO_LIST = "Устройство добавлено в список.";

    private Messages() {
    }
}
