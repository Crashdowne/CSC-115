public class KeyValuePair{
	private int key;
	private Object value;

	public KeyValuePair(int itemKey, Object itemValue){
		key = itemKey;
		value = itemValue;
	}

	public int getKey(){
		return key;
	}

	public Object getValue(){
		return value;
	}

	public String toString(){
		return "Key: " + key + ", Value: " + value.toString();
	}

	public static void main(String[] args){
		KeyValuePair newPair = new KeyValuePair(3243, "Test");
		System.out.println(newPair);
	}
}