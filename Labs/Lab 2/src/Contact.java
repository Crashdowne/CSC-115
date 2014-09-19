
public class Contact {

	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	public Contact()
	{
		name = "empty";
		phoneNumber = "empty";
		emailAddress = "empty";
	}
	
	public Contact(String n, String phNum, String emAdd)
	{
		name = n;
		phoneNumber = phNum;
		emailAddress = emAdd;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public String toString()
	{
		return name+"\t"+phoneNumber+"\t"+emailAddress;
	}
	
	public static void main(String[] args)
	{
		Contact contact1 = new Contact();
		contact1.name = "Bob";
		contact1.phoneNumber = "17786654532";
		contact1.emailAddress = "bob@bobdoesthingsandstuff.com";
		
		Contact contact2 = new Contact("Bill", "12508887654", "bill@billy.com");
		
		System.out.println(contact1+"\n"+contact2);
	}
}
