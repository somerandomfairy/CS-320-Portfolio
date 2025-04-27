package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contacts.ContactService;

import contacts.Contact;

/**
 * Contains JUnit tests for ContactService
 * @author atsushiogata
 *
 */
class ContactServiceTest {	


	/**
	 * Tests adding new contacts to the ContactService
	 * Verifies that contact details are correct
	 */
	@Test
	void testAddNewContacts() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.addContact("Sherlock", "Holmes", "0987654321", "221B Baker Street, London");
		
		Contact john = contactService.getContact("0"); // Retrieve first contact added
		assertEquals("0",john.getID());
		assertEquals("John", john.getFirstName());
		assertEquals("Appleseed", john.getLastName());
		assertEquals("1234567890", john.getPhoneNum());
		assertEquals("123 Main St, NYC", john.getAddress());
		
		Contact sherlock = contactService.getContact("1"); // Retrieve second contact added
		assertEquals("1", sherlock.getID());
		assertEquals("Sherlock", sherlock.getFirstName());
		assertEquals("Holmes", sherlock.getLastName());
		assertEquals("0987654321", sherlock.getPhoneNum());
		assertEquals("221B Baker Street, London", sherlock.getAddress());		
		
	}
	
	/**
	 * Tests deleting an existing contact
	 * Verifies that the contact is removed an no longer retrievable 
	 */
	@Test 
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.addContact("Sherlock", "Holmes", "0987654321", "221B Baker Street, London");
		
		Contact sherlock = contactService.getContact("1"); 
		String sherlockID = sherlock.getID(); // get Sherlock's contactID
		
		contactService.deleteContact("1"); // Delete Sherlock's contact
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact(sherlockID);
		}); // Expect an exception because the contact is deleted
		
	}
	
	/**
	 * Tests deleting a contact that does not exist
	 * verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testDeleteContactNotExist() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("99");
		}); //Expect an exception because the contact does not exist
		
	}
	
	/**
	 * Tests updating the first name of an existing contact with a valid input
	 * Verifies that the first name is successfully updated
	 */
	@Test
	void testUpdateFirstNameValid() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.updateFirstName("0", "James");
		assertEquals("James", contactService.getContact("0").getFirstName());
	}
	
	/**
	 * Tests  updating the first name of a contact with an input that is too long
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateFirstNameTooLong(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("0", "JonathanJamesJohnson");
		}); 	
	}
	
	/**
	 * Tests updating the first name of a contact with null
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateFirstNameIsNull(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("0", null);
		}); 	
	}
	
	/**
	 * Tests updating the first name of a contact that does not exist
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateFirstNameNotExist() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("99", "Jane");
		}); 
	}
	
	/**
	 * Tests updating the last name of a contact with a valid input
	 * Verifies that the last name is successfully updated
	 */
	@Test
	void testUpdateLastNameValid() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.updateLastName("0", "Orange");
		assertEquals("Orange", contactService.getContact("0").getLastName());
	}
	
	/**
	 * Tests updating the last name of a contact with a input that is too long
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateLastNameTooLong(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("0", "AppleseedOrange");
		}); 	
	}
	
	/**
	 * Tests updating the last name of a contact with null
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateLastNameIsNull(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("0", null);
		}); 	
	}
	
	/**
	 * Tests updating the last name of a contact that does not exist
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateLastNameNotExist() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("99", "Orangepip");
		}); 
	}
	
	/**
	 * Tests updating the phone number of a contact with a valid input
	 * Verify that the phone number is successfully updated
	 */
	@Test
	void testUpdatePhoneNumValid() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.updatePhoneNum("0", "0987654321");
		assertEquals("0987654321", contactService.getContact("0").getPhoneNum());
	}
	
	/**
	 * Tests updating the phone number of a contact with an input that is too long
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdatePhoneNumTooLong(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhoneNum("0", "12345678901");
		}); 	
	}
	
	/**
	 * Tests updating the phone number of a contact with an input that is too short
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdatePhoneNumTooShort(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhoneNum("0", "123456789,");
		}); 	
	}
	
	/**
	 * Tests updating the phone number of a contact with null
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdatePhoneNumIsNull(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhoneNum("0", null);
		}); 	
	}
	
	/**
	 * Tests updating the phone number of a contact with input that contains non digits
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdatePhoneNumHasNonDigits(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhoneNum("0", "12345678#A");
		}); 	
	}
	
	/**
	 * Tests updating the phone number of a contact that does not exist
	 * Verifies that an IllegalArgumentException is thrown	
	 */
	@Test
	void testUpdatePhoneNumNotExist() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhoneNum("99", "0987654321");
		}); 
	}
	
	/**
	 * Tests updating the address of a contact with valid input
	 * Verifies that the address is successfully updated
	 */
	@Test
	void testUpdateAddressValid() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		contactService.updateAddress("0", "123 Kasumigaseki, Tokyo");
		assertEquals("123 Kasumigaseki, Tokyo", contactService.getContact("0").getAddress());
	}
	
	/**
	 * Tests updating the address of a contact with an input that is too long
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateAddressTooLong(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("0", "123 Kasumigaseki, Chiyoda City, Tokyo, Japan");
		}); 	
	}
	
	/**
	 * Tests updating the address of a contact with null
	 * Verifies that an IllegalArgumentException is thrown
	 */
	@Test
	void testUpdateAddressIsNull(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("0", null);
		}); 	
	}
	
	/**
	 * Tests updating the address of a contact that does not exist
	 * Verifies that an IllegalArgumentException is thrown
	 */
	void testUpdateAddressNotExist(){
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Appleseed", "1234567890", "123 Main St, NYC");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("99", "456 Elm St, NYC");
		}); 	
	}
	

}
