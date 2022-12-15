import java.io.*;
import java.text.*;
import java.util.*;

public class VaccinationSite 
{
	private Random randy;
	private PriorityQueue<Patient> waitingQ;
	private LinkedList<Vaccine> vacSupply = new LinkedList<Vaccine>();
	private ArrayList<Patient> vaccinated = new ArrayList<Patient>();
	private Nurse[] nurses;
	private String siteName;
	private int currentTime = 0;
	
	public VaccinationSite(String name, int seed, int numNurses, int numVaccines)
	{
		this.siteName = name;
		waitingQ = new PriorityQueue<>(new VacPriority());
		randy = new Random(seed);
		createNurse(numNurses);
		orderVaccines(numVaccines);
	}
	public void createNurse(int numNurses)
	{
		nurses = new Nurse[numNurses];
		
		for (int i = 0; i < numNurses; i++)
		{
			nurses[i] = new Nurse(i + 1);
		}
	}
	public void orderVaccines(int numVaccines)
	{
		for (int i = 0; i < numVaccines - 1; i++)
		{
			if (i % 3 == 0)
			{
				vacSupply.add(new Moderna());
			}
			else
			{
				vacSupply.add(new Pfizer());
			}
		}
	}
	public void openVaccinationSiteLine()
	{
		for (currentTime = 0; currentTime < 10; currentTime++)
		{
			for (int i = 0; i < 6; i++)
			{
				int chance = randy.nextInt(10) + 1;
				
				if (chance >= 1 && chance <= 5)
				{
					waitingQ.add(new Senior(currentTime));
				}
				else if (chance >= 6 && chance <= 9)
				{
					waitingQ.add(new Adult(currentTime));
				}
				else if (chance == 10)
				{
					waitingQ.add(new OlderTeen(currentTime));
				}
			}
		}
	}
	public void operateVaccinationSite(int durationForArriving)
	{
		int endArrivalTime = currentTime + durationForArriving;
		
		while (vaccinated.size() != Patient.idCounter || currentTime < endArrivalTime)
		{
			if (currentTime < endArrivalTime)
			{
				for (int i = 0; i < 8; i++)
				{
					int chance = randy.nextInt(10) + 1;
					
					if (chance >= 1 && chance <= 5)
					{
						waitingQ.add(new Senior(currentTime));
					}
					else if (chance >= 6 && chance <= 9)
					{
						waitingQ.add(new Adult(currentTime));
					}
					else if (chance == 10)
					{
						waitingQ.add(new OlderTeen(currentTime));
					}
				}
			}
			
			for (Nurse nurse : nurses)
			{
				if (!nurse.getIsFree())
				{
					nurse.decrementTimeRemainingForShot();
					
					if (nurse.getTimeRemainingForShot() == 0)
					{
						Patient tempPat = nurse.getAssingedPatient();
						vaccinated.add(tempPat);
						tempPat.setTotalTime(currentTime);
						nurse.removeAssignedPatient();
					}
				}
				if (nurse.getIsFree() && waitingQ.size() != 0)
				{
					if (vacSupply.size() == 0)
					{
						System.out.println("Ran out of vaccine!! " + " patients still waiting.");
						System.out.println("Site Shutting Down!");
						return;
					}
					
					Patient newPatient = waitingQ.remove();
					newPatient.setShotTime(currentTime);
					Vaccine newVaccine = vacSupply.remove();
					newPatient.setVaccine(newVaccine);
					nurse.setAssignedPatient(newPatient);
					int remaining = randy.nextInt(3) + 1;
					nurse.setTimeRemainingForShot(remaining);
				}
			}
			
			currentTime++;
		}
	}
	public void generateVaccinationSiteResults(String output) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(output);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		pw.println("Data For Vaccination Site " + this.siteName);
		pw.println("\nSummary Data");
		
		for (Nurse nurse : nurses)
		{
			pw.println(nurse);
		}
		
		pw.println();
		
		int countSenior = 0;
		int countAdult = 0;
		int countTeen = 0;
		int countPat = 0;
		double timeSenior = 0;
		double timeAdult = 0;
		double timeTeen = 0;
		double timePat = 0;
		
		for (Patient patient : vaccinated)
		{
			if (patient instanceof Senior)
			{
				countSenior++;
				timeSenior += patient.getWaitTime();
			}
			if (patient instanceof Adult)
			{
				countAdult++;
				timeAdult += patient.getWaitTime();
			}
			if (patient instanceof OlderTeen)
			{
				countTeen++;
				timeTeen += patient.getWaitTime();
			}
			if (patient instanceof Patient)
			{
				countPat++;
				timePat += patient.getWaitTime();
			}
		}
		
		timeSenior = timeSenior / countSenior;
		timeAdult = timeAdult / countAdult;
		timeTeen = timeTeen / countTeen;
		timePat = timePat / countPat;
		
		pw.printf("The average total time per person to vacinate %s Seniors is %.2f minutes\n", countSenior, timeSenior);
		pw.printf("The average total time per person to vacinate %s Adults is %.2f minutes\n", countAdult, timeAdult);
		pw.printf("The average total time per person to vacinate %s OlderTeens is %.2f minutes\n", countTeen, timeTeen);
		pw.printf("The average total time per person to vacinate %s Patients is %.2f minutes\n", countPat, timePat);
		
		
		pw.println();
		pw.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\n", "Patient Id",
					"Patient Type", "Age", "Vaccine", "Arrival Time",
					"Wait Time", "Total Time", "Cost");
		
		Iterator<Patient> iter = vaccinated.iterator();
		while (iter.hasNext())
		{
			pw.println(iter.next());
		}

		pw.close();
	}
}
