package com.example.tests;

import org.testng.annotations.Test;


public class TestContactRemoval extends TestBase {

	@Test
	public void deleteSomeContact(){
		app.getContactHelper().deleteContact().confirmDeleteContact();
	}
	
	@Test
	public void deleteAllContacts(){
		app.getContactHelper().deleteAllContacts().confirmDeleteContact();
	}
}
