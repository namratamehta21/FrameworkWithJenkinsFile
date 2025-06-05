package KingsleyGate.StepDef;

import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Companies_StepDefinition
{
    SharedContext Context;

    public Companies_StepDefinition(SharedContext Context)
    {
        this.Context = Context;
    }

    @Then("User Navigates to Companies Page")
    public void user_navigates_to_companies_page()
    {
        Context.CompaniesPage.Navigating_to_Companies_module();
    }

    @Then("^Verifies the Page Title (.+)$")
    public void Verifies_the_Page_Title(String Companies_PageTitle)
    {
        Assert.assertEquals(Context.CompaniesPage.verifies_Companies_pageTitle(),Companies_PageTitle);
    }

    @Then("User select any one company")
    public void User_select_any_one_company()
    {
        Context.CompaniesPage.Select_any_one_company();
    }

    @Then("^User search for a Company (.+)$")
    public void User_search_for_Company(String Company_name)
    {
        Assert.assertEquals(Context.CompaniesPage.Search_for_a_Company(Company_name),Company_name);
    }

    @Then("User click on column tab and verify the list of columns")
    public void User_click_on_column_tab()
    {
        Context.CompaniesPage.ColumnTabOnCompanies();
    }

    @Then("User unselect all and add column to the grid")
    public void User_unselect_all_add_column_to_grid()
    {
        Context.CompaniesPage.AddColumnToGrid();
    }

    @Then("User verifies the column selected are shown in the grid")
    public void User_verifies_the_column_selected_shown_in_grid()
    {
        Context.CompaniesPage.verifySelectedColumnsInGrid();
    }

}
