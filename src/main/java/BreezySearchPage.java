public class BreezySearchPage {
    public static final String URL = "https://breezy.by/";
    public static final String SEARCH_BAR = "header_search_input";
    public static String textForSearchWithResults = "зарядное устройство";
    public static String textForSearchWithoutResults = "магнитофон";
    public static final String BUTTON_SEARCH = "header_search_seaction_btn";
    public static final String BUTTON_CLEAR_SEARCH = "header_search_seaction_close";
    public static final String CHECKBOX_WIRELESS_CHARGER = "//input[@value='35']";
    public static final String CHECKBOX_POWERBANK = "//input[@value='45']";
    public static final String LABEL_PRODUCT_NAME = "product_name";
    public static final String BUTTON_PAGINATION_NEXT = "//div[contains(@class, 'pagination_arrow_next')]";
    public static final String LABEL_NO_RESULTS = "search_page_no_result";
    public static String noResults = "По вашему запросу ничего не найдено ("
            + BreezySearchPage.textForSearchWithoutResults +
            ")\nПопробуйте сократить запрос или задать его по-другому. Убедитесь, что название бренда и модели написано правильно.";
}
