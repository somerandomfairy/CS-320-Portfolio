package contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains a collection of Contact objects and provides methods to add, retrieve, update, and delete contacts
 * @author atsushiogata
 *
 */
public class ContactService {
	private final List<Contact> contacts;
	private int idCounter = 0;

	/**
	 * Constructs a new ContactService with empty list of contacts
	 */
	public ContactService() {
		contacts = new ArrayList<>();
	}

	/**
	 * generates a unique contact ID as string
	 * 
	 * @return a unique contact ID
	 */
	private String generateID() {
		String temp = Integer.toString(idCounter);
		idCounter++;
		return temp;
	}

	/**
	 * Retrieves a contact by ID
	 * 
	 * @param contactID the ID of the contact to retrieveS
	 * @return the contact with the specified ID
	 */
	public Contact getContact(String contactID) {
		for (Contact c : contacts) { 
			if (c.getID().equals(contactID)) {
				return c;
			}
		}
		throw new IllegalArgumentException("Contact not found"); //throw exception if contact not found

	}

	/**
	 * Adds a new contact 
	 * 
	 * @param firstName the first name of contact
	 * @param lastName  the last name of contact
	 * @param phoneNum  the phone number of contact
	 * @param address   the address of contact
	 */
	public void addContact(String firstName, String lastName, String phoneNum, String address) {
		Contact contact = new Contact(generateID(), firstName, lastName, phoneNum, address);
		contacts.add(contact);
	}

	/**
	 * Deletes a contact
	 * 
	 * @param contactID the ID of the contact to delete
	 */
	public void deleteContact(String contactID) {
		for (Contact c : contacts) {
			if (c.getID().equals(contactID)) {
				contacts.remove(c);
				return;
			}
		}
		throw new IllegalArgumentException("Contact not found"); // throw exception if contact not found
	}

	/**
	 * Updates the first name of the contact 
	 * @param contactID   ID of contact to update
	 * @param firstName   new first name
	 */
	public void updateFirstName(String contactID, String firstName) {
		for (Contact c : contacts) {
			if (c.getID().equals(contactID)) {
				c.setFirstName(firstName);
				return;
			}
		}
		throw new IllegalArgumentException("Contact not found"); // throw exception if contact not found
	}
	
	
	/**
	 * Updates the last name of the contact 
	 * @param contactID  ID of contact to update
	 * @param lastName   new last name
	 */
	public void updateLastName(String contactID, String lastName) {
		for (Contact c : contacts) {
			if (c.getID().equals(contactID)) {
				c.setLastName(lastName);
				return;
			}
		}
		throw new IllegalArgumentException("Contact not found"); // throw exception if contact not found
	}
	
	/**
	 * Updates the Phone number of the contact
	 * @param contactID  ID of contact to update
	 * @param phoneNum   new phone number
	 */
	public void updatePhoneNum(String contactID, String phoneNum) {
		for (Contact c : contacts) {
			if (c.getID().equals(contactID)) {
				c.setPhoneNum(phoneNum);
				return;
			}
		} 
		throw new IllegalArgumentException("Contact not found"); // throw exception if contact not found
	}
	
	/**
	 * Updates the address of the contact 
	 * @param contactID  Id of contact to update
	 * @param address    new address
	 */
	public void updateAddress(String contactID, String address) {
		for (Contact c : contacts) {
			if (c.getID().equals(contactID)) {
				c.setAddress(address);
				return;
			}
		}
		throw new IllegalArgumentException("Contact not found"); // throw exception if contact not found
	}
	
	
	
}
