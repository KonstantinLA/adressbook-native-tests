package com.example.fw;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 1000)
			.click("Add").winWaitAndActivate("Add Contact", "", 1000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.firstname)
			.send("TDBEdit11", contact.lastname);
	}
	
	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 1000);
	}
	
	private void selectFirstContact(){
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 1000)
		.focus("TListView1")
		.send("{DOWN}{SPACE}");
	}
	
	private void selectAllContacts(){
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 1000)
		.click("Select All");
	}

	public Contact getFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper()
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 1000);
		Contact contact = new Contact()
			.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 1000);
		return contact;
	}
	
	public ContactHelper deleteContact(){
		selectFirstContact();
		manager.getAutoItHelper().click("Delete");
		return this;
	}
	
	public ContactHelper deleteAllContacts(){
		selectAllContacts();
		manager.getAutoItHelper().click("Delete");
		return this;
	}
	
	public void confirmDeleteContact(){
		manager.getAutoItHelper()
		.winWaitAndActivate("Confirm", "", 1000)
		.click("&Yes")
		.winWaitAndActivate("AddressBook Portable", "", 1000);
	}
}
