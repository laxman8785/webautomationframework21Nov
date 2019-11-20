package com.booksmart.PageObjects;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;

import com.booksmart.Utilities.JSONReader;
import com.booksmart.Utilities.SeleniumLib;

public class BookPage {
	
	By btnNewBook= By.xpath("//a[contains(text(),'New Book')]");
	By pageTitle= By.id("page_title");
	By txtBookName= By.id("book_name");
	By txtBookDesc= By.id("book_description");
	By txtBookSource= By.id("book_source");
	By txtAgentNumber= By.id("nw_agent_number");
	By txtPriorCarrier= By.id("prior_carrier");
	By txtProjectQuoteId= By.id("nw_project_quote_id");
	By txtAgreementId= By.id("nw_agreement_id");
	By txtRegionCode= By.id("nw_region_code");
	By txtAMS_System_Source= By.id("nw_ams_system_source");
	By btnContinue= By.xpath("//input[@name='create']");
	String datafile=null;
	String dataset=null;
	LinkedHashMap<String, String> keys=null;
	
	
	public BookPage(String filename,String dataset) throws Exception {
		SeleniumLib.click(btnNewBook);
		this.datafile=filename;
		this.dataset=dataset;
		JSONReader marsh = new JSONReader(this.datafile);
		keys=marsh.getKeys(marsh.getDataSet(this.dataset));
	}
	
	public void AddBook() throws Exception {
		SeleniumLib.textBoxInput(txtBookName, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtBookDesc, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtBookSource, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtAgentNumber, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtPriorCarrier, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtProjectQuoteId, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtAgreementId, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtRegionCode, keys.get("textboxBook_Name"));
		SeleniumLib.textBoxInput(txtAMS_System_Source, keys.get("textboxBook_Name"));
		SeleniumLib.click(btnContinue);		
	}

}
