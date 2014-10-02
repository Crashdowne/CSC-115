import java.io.*;
import java.util.*;

public class ContactList {

	private ContactList[] contact;
	private static int count;
	
	public static void add(String name, String phone, String email)
	{
		Contact nextContact = new Contact(name, phone, email);
		contact[count] = nextContact;	
		
	}
	

}
