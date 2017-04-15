package efimovta.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class contains used Constants
 */
public class Constants {
   public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public final static String DEFAULT_DESCRIPTION = "### Menu ###";
   public final static String COMPANY_NAME = "\n### Компания \"Horns and hooves and your super device\" ###";
   public final static String CREATE_MENU_NAME = "\n### Добавление ###";
   public final static String SEARCH_MENU_NAME = "\n### Поиск ###";
   public final static String SORTEDVIEW_MENU_NAME = "\n### Просмотр ###";

   public final static String CREATING = "Добавление";
   public final static String SEARCHING = "Поиск";
   public final static String VIEWING_SORTED  = "Просмотр в отсортированном виде";

   public final static String SELECT_ACTION  = "Выбирете действие:";
   public final static String INVALID_INPUT  = "Неверный ввод.";
   public final static String EXIT  = "Выход";
   public final static String BACK_TO_MAIN_MENU  = "Возвращение к главному меню";

   public final static String CLIENT_ADDING  = "Добавление клиента";
   public final static String DEVICE_ADDING  = "Добавление устройства";
   public final static String SALE_ADDING  = "Добавление продажи";
   public final static String THE_CLIENT_WAS_SUCCESSFULLY_ADDED  = "Клиент успешно добавлен.";
   public final static String THE_DEVICE_WAS_SUCCESSFULLY_ADDED  = "Устройство успешно добавлено.";
   public final static String THE_SALE_WAS_SUCCESSFULLY_ADDED  = "Продажа успешно добавлена.";

   public final static String ALL_CLIENTS  = "Все клиенты";
   public final static String ALL_DEVICES  = "Все устройства";
   public final static String ALL_SALES  = "Все продажи";
   public final static String SEARCHING_CLIENTS_BY_FIO  = "Поиск клиента(ов) по ФИО";
   public final static String SEARCHING_DEVICES_BY_BRAND  = "Поиск устройств по марке";
   public final static String SEARCHING_DEVICES_BY_TYPE  = "Поиск устройств по типу";
   public final static String SEARCHING_DEVICES_BY_RELEASE_DATE  = "Поиск устройств по году выпуска";

   public final static String VIEWING_CLIENTS_SORTED_BY_NAME  = "Просмотр клиентов, отстортированных по ФИО";
}
