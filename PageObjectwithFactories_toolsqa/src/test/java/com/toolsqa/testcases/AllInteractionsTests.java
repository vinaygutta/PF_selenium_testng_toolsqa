package com.toolsqa.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.errorcollectors.ErrorCollector;
import com.toolsqa.pages.actions.HomePage;
import com.toolsqa.pages.actions.RegFormMDPage;
import com.toolsqa.pages.actions.SortablePage;
import com.toolsqa.pages.actions.UploadPage;
import com.toolsqa.pages.actions.WebTablePage;
import com.toolsqa.utilities.Utilities;

public class AllInteractionsTests {
	
	public HomePage homepage;

	@BeforeTest
	public void setUp() {

		BasePageInit.initConfiguration(System.getProperty("usebrowserpom"));
		//BasePageInit.initConfiguration("chrome");
		homepage = new HomePage();
		
		

	}
	
	@Test(priority=1, description = "To verify if drag and sort working in list.")
	public void dragSortinListTest() {
		
		homepage.clickInteractions();

		
		SortablePage spage = BasePageInit.lnavPage.clickLeftNavInteractions_sortable(true);
		spage.dragsortElementinList(0, 4, "One");

	}
	
	@Test(priority=2, description = "To verify if drag and sort working in grid.")
	public void dragSortinGridTest() {
		
		SortablePage spage = BasePageInit.lnavPage.clickLeftNavInteractions_sortable(true);
		spage.dragsortElementinGrid(0, 4, "One");

	}

	@AfterTest
	public void tearDown() {
		
		if (BasePageInit.driver != null) {
			BasePageInit.quitBrowser();
		}
	}
}
