import java.util.*;

public class VacPriority implements Comparator<Patient>
{
	public int compare(Patient o1, Patient o2)
	{
		if (o1.getClass().equals(o2.getClass()))
		{
			if (o1.getArrivalTime() < o2.getArrivalTime())
			{
				return -1;
			}
			else if (o1.getArrivalTime() == o2.getArrivalTime())
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		else if (o1.getPatientID().equals("Senior"))
		{
			return -1;
		}
		else if (o2.getPatientID().equals("Senior"))
		{
			return 1;
		}
		else if (o1.getPatientID().equals("Adult"))
		{
			return -1;
		}
		
		return 1;
	}
	
}
