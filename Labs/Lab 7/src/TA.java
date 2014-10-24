public class TA extends Person
{

		private int taEmployeeNumber;
		private int taSalary;
		private int taStudentNumber;
		
		public TA (String taName, String taEmail, int taEmpNumber, int taSalary1, int taStudentNumber1)
		{
			setName (taName);
			setEmail (taEmail);
			this.taEmployeeNumber = (taEmpNumber);
			this.taSalary = (taSalary1);
			this.taStudentNumber = (taStudentNumber1);
		}
		
		public void setTaEmployeeNumber(int newTaEmpNumber)
		{
			taEmployeeNumber = newTaEmpNumber;
		}
		
		public void setTaSalary(int newTaSalary)
		{
			taSalary = newTaSalary;
		}
		
		public void setTaStudentNumber(int newTaStudentNumber)
		{
			taStudentNumber = newTaStudentNumber;
		}
		
		public int getTaSalary()
		{
			return taSalary;
		}
		
		public int getTaEmployeeNumber()
		{
			return taEmployeeNumber;
		}
		
		public int getTaStudentNumber()
		{
			return taStudentNumber;
		}
		
		public String toString()
		{
			return(super.toString() + " " + taEmployeeNumber +" " + taSalary + " " + taStudentNumber);
		}
		
		
		public static void main(String[] args)
		{
			
		
		Person p1 = new TA("Luke", "luke@skywalker.ca", 999956, 50, 86);
		System.out.println(p1);
		p1.setName("Luke Lee");
		System.out.println(p1);
		
		Person p2 = new TA("David Walker", "dwalker@cs.uvic.ca", 999944, 60, 75);
		System.out.println(p2);
		p2.setEmail("wdavid@uvic.ca");
		System.out.println(p2);
	}
}