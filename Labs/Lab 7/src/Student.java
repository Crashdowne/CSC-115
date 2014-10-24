public class Student extends Person{
	private int studentNumber;
	private int grade;

	public Student(String studentName, String studentEmail, int number, int studentGrade){
		setName(studentName);
		setEmail(studentEmail);
		studentNumber = number;
		grade = studentGrade;
	}

	public int getStudentNumber(){
		return studentNumber;
	}

	public int getGrade(){
		return grade;
	}

	public void setStudentNumber(int newStudentNumber){
		studentNumber = newStudentNumber;
	}

	public void setGrade(int newGrade){
		grade = newGrade;
	}

	public String toString(){
		return "Student: " + super.toString() + ", Student#: " + studentNumber + ", Grade: " + grade;
	}

	public static void main(String[] args){
		Student test = new Student("Luke", "luke@skywalker.ca", 999956, 86);
		System.out.println(test);
	}
}