package contacts;

/**
 * Represents a contact with a unique identifier, name, phone number, and address
 * @author atsushiogata
 *
 */
public class Contact {
	
	
	// Declare private members of Contact
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;

	/**
	 * Constructs a new Contact instance with the specified details
	 * 
	 * @param contactID  unique identifier for contact 
	 * @param firstName  first name of contact 
	 * @param lastName   last name of contact 
	 * @param phoneNum   phone number of contact 
	 * @param address    address of contact
	 */
	public Contact(String contactID, String firstName, String lastName, String phoneNum, String address) {
		
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        } // throw exception if contactID is null or longer than 10 characters
        this.contactID = contactID;
        
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		} // throw exception if firstName is null or longer than 10 characters
		this.firstName = firstName;
		
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		} // throw exception if lastName is null or longer than 10 characters
		this.lastName = lastName;
		
		if (phoneNum == null || phoneNum.length()!=10 || !phoneNum.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		} // throw exception if phoneNum is null, not exactly 10 characters, or contains non digits
		this.phoneNum = phoneNum;
		
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		} // throw exception if address is null or longer than 30 characters
		this.address = address;	
		
	}
	
	/**
	 * getter function for contactID
	 * @return contactID
	 */
	public String getID() {
		return contactID;		
	}
	
	/**
	 * getter function for firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	/** 
	 * getter function for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * getter function for phoneNum
	 * @return phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * getter function for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * sets firstName of contact
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		} // throw exception if firstName is null or longer than 10 characters
		this.firstName = firstName;		
	}
	
	/**
	 *  sets lastName of contact
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		} // throw exception if lastName is null or longer than 10 characters
		this.lastName = lastName;
	}
	
	/**
	 * sets phoneNum of contact
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.length()!=10 || !phoneNum.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		} // throw exception if phoneNum is null, not exactly 10 characters, or contains non digits
		this.phoneNum = phoneNum;
	}
	
	/**
	 * sets address of contact
	 * @param address
	 */
	public void setAddress(String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		} // throw exception if firstName is null or longer than 10 characters
		this.address = address;	
	}

}
