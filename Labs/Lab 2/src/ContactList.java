import java.io.*;
import java.util.*;

public class ContactList {

	private contactList[] contact;
	private static int count;
	
	public static void add(String name, String phone, String email)
	{
		Contact nextContact = new Contact(name, phone, email);
		contactList[count] = nextContact;	
		
	}
	

}
