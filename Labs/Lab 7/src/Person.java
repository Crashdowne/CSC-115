public abstract class Person{
	private String name;
	private String email;

	public String getName(){
		return name;
	}

	public void setName(String newName){
		name = newName;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String newEmail){
		email = newEmail;
	}

	public String toString(){
		return name + ", " + email;
	}
}