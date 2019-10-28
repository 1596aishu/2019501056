/**
 * This is JUnit that tests the areaOfCircle and perimeterOfCircle methods
 *  that is available in AreaOfCircle class. This contains 14 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase14).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		Contact contact = new Contact("Bob", "bob@gmail.com", "9999912345");
		assertEquals("1. ", "Bob", contact.getName());
		assertEquals("2. ", "9999912345", contact.getPhoneNumber());
		assertEquals("3. ", "bob@gmail.com", contact.getEmail());

		assertEquals("4. ", "{ Name = Bob, Email = bob@gmail.com, Phone Number = 9999912345 }", contact.toString());

		contact.setName("Bob Sedgewick");
		assertEquals("5. ", "Bob Sedgewick", contact.getName());

		contact.setPhoneNumber("+91 9999912345");
		assertEquals("6. ", "+91 9999912345", contact.getPhoneNumber());

		assertEquals("7. ", "{ Name = Bob Sedgewick, Email = bob@gmail.com, Phone Number = +91 9999912345 }", contact.toString());
	}

	@Test
	public void testCase2() {
		Contact contact = new Contact("", "", "");
		assertEquals("1. ", "{ Name = , Email = , Phone Number =  }", contact.toString());

		contact.setName("Robert Sedgewick");
		assertEquals("2. ", "{ Name = Robert Sedgewick, Email = , Phone Number =  }", contact.toString());

		contact.setEmail("sedgewick@gmail.com");
		assertEquals("3. ", "{ Name = Robert Sedgewick, Email = sedgewick@gmail.com, Phone Number =  }", contact.toString());

		contact.setName("");
		assertEquals("4. ", "{ Name = , Email = sedgewick@gmail.com, Phone Number =  }", contact.toString());
	}

	@Test
	public void testCase3() {
		ContactsManager contactManager = new ContactsManager();
		contactManager.addContact(new Contact("Bob Sedgewick", "bob@gmail.com", "9999912345"));
		contactManager.addContact(new Contact("Alice", "alice@gmail.com", "9999912344"));
		contactManager.addContact(new Contact("Peter Norvig", "norvig@gmail.com", "9999912343"));
		contactManager.addContact(new Contact("Kevin Wayne", "kevin@gmail.com", "9999912342"));
		contactManager.addContact(new Contact("Greg Kedsen", "greg@gmail.com", "9999912341"));

		assertEquals("1. ", "9999912341", contactManager.searchContact("Greg Kedsen").getPhoneNumber());
		assertEquals("2. ", "9999912345", contactManager.searchContact("Bob Sedgewick").getPhoneNumber());
		assertEquals("3. ", null, contactManager.searchContact("Eric Grimpson"));
		assertEquals("4. ", "kevin@gmail.com", contactManager.searchContact("Kevin Wayne").getEmail());
		assertEquals("5. ", null, contactManager.searchContact("Eric Grimson"));

		contactManager.addContact(new Contact("Randy Bryant", "randy@gmail.com", "9999912340"));
		assertEquals("5. ", "randy@gmail.com", contactManager.searchContact("Randy Bryant").getEmail());
	}

	@Test
	public void testCase4() {
		ContactsManager contactManager = new ContactsManager();
		contactManager.addContact(new Contact("Bob Sedgewick", "bob@gmail.com", "9999912345"));
		contactManager.addContact(new Contact("Alice", "alice@gmail.com", "9999912344"));
		contactManager.addContact(new Contact("Peter Norvig", "norvig@gmail.com", "9999912343"));
		contactManager.addContact(new Contact("Kevin Wayne", "kevin@gmail.com", "9999912342"));
		contactManager.addContact(new Contact("Greg Kedsen", "greg@gmail.com", "9999912341"));

		assertEquals("1. ", "9999912341", contactManager.searchContactByEmail("greg@gmail.com").getPhoneNumber());
		assertEquals("2. ", "9999912345", contactManager.searchContactByEmail("bob@gmail.com").getPhoneNumber());
		assertEquals("3. ", null, contactManager.searchContactByEmail("eric@gmail.com"));
		assertEquals("4. ", "Kevin Wayne", contactManager.searchContactByEmail("kevin@gmail.com").getName());
		assertEquals("5. ", null, contactManager.searchContactByEmail("eric@gmail.com"));

		assertEquals("6. ", false, contactManager.deleteContact("Eric Grimpson"));
		assertEquals("7. ", true, contactManager.deleteContact("Greg Kedsen"));
		assertEquals("8. ", true, contactManager.deleteContact("Peter Norvig"));
		assertEquals("9. ", "Kevin Wayne", contactManager.searchContactByEmail("kevin@gmail.com").getName());
		assertEquals("10. ", "{ Name = Kevin Wayne, Email = kevin@gmail.com, Phone Number = 9999912342 }", contactManager.searchContactByEmail("kevin@gmail.com").toString());

		assertEquals("11. ", true, contactManager.deleteContact("Kevin Wayne"));
		assertEquals("12. ", true, contactManager.deleteContact("Alice"));
		assertEquals("13. ", true, contactManager.deleteContact("Bob Sedgewick"));

		assertEquals("14. ", null, contactManager.searchContact("eric@gmail.com"));
		assertEquals("15. ", null, contactManager.searchContact("Bob Sedgewick"));
		assertEquals("16. ", null, contactManager.searchContact("Kevin Wayne"));
		assertEquals("17. ", null, contactManager.searchContact("Eric Grimpson"));
		assertEquals("18. ", null, contactManager.searchContact("Alice"));
	}
}