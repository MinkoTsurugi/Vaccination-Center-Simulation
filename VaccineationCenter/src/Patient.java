public abstract class Patient implements Comparable<Patient>
{
	public static int idCounter = 0;
	private int arrivalTime;
	private int shotTime;
	private int waitTime;
	private int totalTime;
	private String patientID;
	private Vaccine vacDose;
		
	public Patient(int newArrivalTime)
	{
		setArrivalTime(newArrivalTime);
		setPatientID();
	}
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	public int getShotTime()
	{
		return this.shotTime;
	}
	public int getWaitTime()
	{
		return this.waitTime;
	}
	public int getTotalTime()
	{
		return this.totalTime;
	}
	public String getPatientID()
	{
		return this.patientID;
	}
	public Vaccine getVacDose()
	{
		return this.vacDose;
	}
	public void setArrivalTime(int newArrivalTime)
	{
		this.arrivalTime = newArrivalTime;
	}
	public void setShotTime(int newShotTime)
	{
		this.shotTime = newShotTime;
		this.waitTime = newShotTime - this.arrivalTime;
	}
	public void setTotalTime(int newEndTime)
	{
		this.totalTime = newEndTime - this.arrivalTime;
	}
	public void setPatientID()
	{
		idCounter++;
		this.patientID = "Patient" + idCounter;
	}
	public void setVaccine(Vaccine newVaccine)
	{
		this.vacDose = newVaccine;
	}
	public abstract void setAge();
	public abstract int getAge();
	public abstract void setPatType();
	public abstract String getPatType();
	public abstract int compareTo(Patient o1);
}
