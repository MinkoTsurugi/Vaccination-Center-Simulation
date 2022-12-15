import java.util.*;

public class Senior extends Patient
{
	private static Random randySenior = new Random(8);
	private int age;
	private String patType;
	
	public Senior(int newArrivalTime)
	{
		super(newArrivalTime);
		setAge();
		setPatType();
	}
	public void setAge() 
	{
		this.age = randySenior.nextInt(100) + 61;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setPatType()
	{
		this.patType = "Senior";
	}
	public String getPatType() 
	{
		return this.patType;
	}
	public int compareTo(Patient o1) 
	{
		if (this.age < o1.getAge())
		{
			return 1;
		}
		else if(this.age > o1.getAge())
		{
			return -1;
		}

		return 0;
	}
	public String toString()
	{
		return String.format("%s\t\t %s\t\t  %s\t  %s\t\t   %s\t\t\t %s\t\t\t %s\t   $%.2f",
				this.getPatientID(), this.getPatType(), this.getAge(), this.getVacDose(), this.getArrivalTime(),
				this.getWaitTime(), getTotalTime(), this.getVacDose().getDoseCost());
	}
}
