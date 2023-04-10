package by.itacademy.moiseenkolydia.breezy.ui.steps;

import by.itacademy.moiseenkolydia.breezy.ui.pages.SearchPage;

public class SearchSteps extends SearchPage {

    public boolean searchProductWithFilters() {
        searchProduct(PRODUCT_FOR_SEARCH_WITH_RESULTS).
                selectFilterOption(CHECKBOX_POWERBANK).
                selectFilterOption(CHECKBOX_WIRELESS_CHARGER);
        getProductNamesOnPage();
       return isSearchResultListContainsProductName(PRODUCT_FOR_SEARCH_WITH_RESULTS);
    }

    public String checkNoResultsText() {
        return searchProduct(PRODUCT_FOR_SEARCH_WITHOUT_RESULTS).getNoResultsText();
    }

    public boolean checkEmptySearchBar() {
        enterProductToSearchBar(PRODUCT_FOR_SEARCH_WITH_RESULTS).clearSearchBar();
        return getTextFromSearchBar().isEmpty();
    }
}
