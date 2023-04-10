package by.itacademy.moiseenkolydia.breezy.ui;

import by.itacademy.moiseenkolydia.breezy.ui.pages.SearchPage;
import by.itacademy.moiseenkolydia.breezy.ui.steps.SearchSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    SearchSteps steps = new SearchSteps();

    @Test
    @DisplayName("Check if the found products with filters contain the search query")
    public void testSearchProductsWithFilters() {
        Assertions.assertTrue(steps.searchProductWithFilters(), "No products found");
    }

    @Test
    @DisplayName("Search without results")
    public void testSearchWithoutResults() {
        Assertions.assertEquals(SearchPage.NO_RESULTS, steps.checkNoResultsText());
    }

    @Test
    @DisplayName("Clean search bar")
    public void testIsSearchBarCleaned() {
        Assertions.assertTrue(steps.checkEmptySearchBar());
    }
}
