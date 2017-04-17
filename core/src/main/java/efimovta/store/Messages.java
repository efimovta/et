package efimovta.store;

/**
 * Class contains used Messages
 */
public class Messages {
    public final static String COMPANY_NAME =
            "\n### Компания \"Horns and hooves and your super device\" ###";

    /* For logger */
    public static final String APP_START = "Приложение запущено";
    public static final String APP_SUCCESSFULLY_CLOSED =
            "Приложение успешно завершено";
    public static final String STORAGE_FILLED = "Хранилище заполнено";

    /* MenuManager names */
    public final static String DEFAULT_MENU_NAME = "### MenuManager ###";
    public final static String MAIN_MENU = COMPANY_NAME;
    public final static String CREATE_MENU_NAME = "\n### Добавление ###";
    public final static String SEARCH_MENU_NAME = "\n### Поиск ###";
    public final static String SORTEDVIEW_MENU_NAME = "\n### Просмотр ###";

    /* Common menu items */
    public final static String SELECT_ACTION = "Выбирете действие:";
    public final static String INVALID_INPUT = "Неверный ввод.";
    public final static String EXIT = "Выход";
    public final static String BACK_TO_MAIN_MENU =
            "Возвращение к главному меню";
    public final static String THE_OPERATION_WAS_SUCCESSFULLY_CANCELED =
            "Операция успешно отменена.";

    /* Main menu */
    public final static String CREATING = "Добавление";
    public final static String SEARCHING = "Поиск";
    public final static String VIEWING_SORTED =
            "Просмотр в отсортированном виде";

    /* Create menu */
    public final static String CLIENT_ADDING = "Добавление клиента";
    public final static String DEVICE_ADDING = "Добавление устройства";
    public final static String SALE_ADDING = "Добавление продажи";

    /* Result from create menu*/
    public final static String THE_CLIENT_WAS_SUCCESSFULLY_ADDED =
            "Клиент успешно добавлен.";
    public final static String THE_DEVICE_WAS_SUCCESSFULLY_ADDED =
            "Устройство успешно добавлено.";
    public final static String THE_SALE_WAS_SUCCESSFULLY_ADDED =
            "Продажа успешно добавлена.";

    /* Search menu */
    public final static String ALL_CLIENTS = "Все клиенты";
    public final static String ALL_DEVICES = "Все устройства";
    public final static String ALL_SALES = "Все продажи";
    public final static String SEARCHING_CLIENTS_BY_FIO =
            "Поиск клиента(ов) по ФИО";
    public final static String SEARCHING_CLIENTS_BY_ANY_NAME =
            "Поиск клиента(ов) по имени(любому)";
    public final static String SEARCHING_DEVICES_BY_BRAND =
            "Поиск устройств по марке";
    public final static String SEARCHING_DEVICES_BY_TYPE =
            "Поиск устройств по типу";
    public final static String SEARCHING_DEVICES_BY_RELEASE_DATE =
            "Поиск устройств по году выпуска";

    /* Sorted view menu for clients */
    public final static String VIEWING_CLIENTS_SORTED_BY_NAME =
            "Просмотр клиентов, отстортированных по ФИО";
    public final static String VIEWING_CLIENTS_SORTED_BY_BIRTHDAY =
            "Просмотр клиентов, отстортированных по дням рождения";

    /* Sorted view menu for devices */
    public final static String VIEWING_DEVICES_SORTED_BY_RELEASE_DATE =
            "Просмотр устройств, отстортированных по датте выпуска";
    public final static String VIEWING_DEVICES_SORTED_BY_BRAND =
            "Просмотр устройств, отстортированных по бренду";
    public final static String VIEWING_DEVICES_SORTED_BY_TYPE =
            "Просмотр устройств, отстортированных по типу";
    public final static String VIEWING_DEVICES_SORTED_BY_MODEL =
            "Просмотр устройств, отстортированных по модели";

    /* Sorted view menu for sales */
    public final static String VIEWING_SALES_SORTED_BY_SALE_DATE =
            "Просмотр продаж, отстортированных по времени продажи";
    public final static String VIEWING_DEVICES_SORTED_BY_CLIENT_ID =
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
    public static final String CLIENT_NOT_FOUND = "Клиент не найден";
}
