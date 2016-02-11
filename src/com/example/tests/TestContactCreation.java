package com.example.tests;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test
	public void shouldCreateContactWithValidData(){
		Contact contact = new Contact().setFirstname("tester").setLastname("tester");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		assertThat(contact, equalTo(createdContact));
		
	}

}
