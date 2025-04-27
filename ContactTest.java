package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contacts.Contact;

/**
 * Contains JUnit tests for Contacts
 * @author atsushiogata
 *
 */
class ContactTest {

	/**
	 * tests that a contact object is successfully initiated with valid inputs
	 */
	@Test
	void testContactClass() {
	 	Contact contact = new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
	 	assertEquals("1234567890", contact.getID());
	 	assertEquals("John", contact.getFirstName());
	 	assertEquals("Appleseed", contact.getLastName());
	 	assertEquals("1234567890", contact.getPhoneNum());
	 	assertEquals("123 Main St, NYC", contact.getAddress());
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if the contactID is too long
	 */
	@Test
	void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if the contactID is null
	 */
	@Test
	void testContactIDIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Appleseed", "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if firstName is too long
	 */
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "JohnathanJamesJohnson", "Appleseed", "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if firstName is null
	 */
	@Test
	void testFirstNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Appleseed", "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if lastName is too long
	 */
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "AppleseedOrage", "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if lastName is null
	 */
	@Test
	void testLastNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", null, "1234567890", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if phoneNum is too long
	 */
	@Test
	void testPhoneNumTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Appleseed", "12345678901", "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if phoneNum is null
	 */
	@Test
	void testPhoneNumIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Appleseed", null, "123 Main St, NYC");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if address is too long
	 */
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main Street, New York City, New York");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if address is null
	 */
	@Test
	void testAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Appleseed", "1234567890", null);
		}); 
	}
	
	/**
	 * Tests that first name is successfully updated with valid input
	 */
	@Test
	void testSetFirstNameValidInput() {
		Contact contact = new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		contact.setFirstName("James");
		assertEquals("James", contact.getFirstName());		
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown if first name is too long
	 */
	@Test
	void testSetFirstNameTooLong() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("JonathanJamesJohnson");
		}); 
	}
	
	
	/**
	 * Tests that an IllegalArgumentException is thrown if first name is null
	 */
	@Test
	void testSetFirstNameIsNull() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		}); 
	}
	
	/**
	 * Tests that last name is successfully updated with valid input
	 */
	@Test
	void testSetLastNameValidInput() {
		Contact contact = new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		contact.setLastName("Orange");
		assertEquals("Orange", contact.getLastName());		
	}
	
	/** 
	 * Tests that an IllegalArgumentException is thrown when last name is too long
	 */
	@Test
	void testSetLastNameTooLong() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("AppleseedOrange");
		}); 
	}
	
	/**
	 * Tests that IllegalArgumentException is thrown when last name is null
	 */
	@Test
	void testSetLastNameIsNull() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		}); 
	}
	
	/**
	 * Tests that phone number is successfully updated with valid input
	 */
	@Test
	void testSetPhoneNumValidInput() {
		Contact contact = new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		contact.setPhoneNum("0987654321");
		assertEquals("0987654321", contact.getPhoneNum());		
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown when phone number is too long
	 */
	@Test
	void testSetPhoneNumTooLong() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("12345678901");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown when phone number is too short
	 */
	@Test
	void testSetPhoneNumTooShort() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("123456789");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown when phone number is null
	 */
	@Test
	void testSetPhoneNumIsNull() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum(null);
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown when phone number is not all digits
	 */
	@Test
	void testSetPhoneNumHasNonDigit() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("12345678#A");
		}); 
	}
	
	/**
	 * Tests that address is successfully updated with valid input
	 */
	@Test
	void testSetAddressValidInput() {
		Contact contact = new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		contact.setAddress("123 Kasumigaseki, Tokyo");
		assertEquals("123 Kasumigaseki, Tokyo", contact.getAddress());		
	}
	
	/** 
	 * Tests that an IllegalArgumentException is thrown when address is null
	 */
	@Test
	void testSetAddressTooLong() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123 Kasumigaseki, Chiyoda City, Tokyo, Japan");
		}); 
	}
	
	/**
	 * Tests that an IllegalArgumentException is thrown when address is null
	 */
	@Test
	void testSetAddressIsNull() {
		Contact contact =new Contact("1234567890", "John", "Appleseed", "1234567890", "123 Main St, NYC");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		}); 
	}
		

}
