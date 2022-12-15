import java.util.*;

public class OlderTeen extends Patient
{
	private static Random randyOlderTeen = new Random(10);
	private int age;
	private String patType;
	
	public OlderTeen(int newArrivalTime)
	{
		super(newArrivalTime);
		setAge();
		setPatType();
	}
	public void setAge() 
	{
		this.age = randyOlderTeen.nextInt(60) + 21;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setPatType()
	{
		this.patType = "OlderTeen";
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
		return String.format("%s\t %s\t\t  %s\t  %s\t\t   %s\t\t\t %s\t\t\t %s\t   $%.2f",
				this.getPatientID(), this.getPatType(), this.getAge(), this.getVacDose(), this.getArrivalTime(),
				this.getWaitTime(), getTotalTime(), this.getVacDose().getDoseCost());
	}
}
