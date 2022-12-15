public class Nurse 
{
	public static int nurseCounter = 0;
	private boolean isFree;
	private int nurseIDNumber;
	private int totalPatientsProcessedByNurse;
	private int timeRemainingForShot;
	private Patient assignedPatient;
	
	public Nurse(int newNurseIDNumber)
	{
		setNurseIDNumber(newNurseIDNumber);
		setIsFree(true);
	}
	public boolean getIsFree()
	{
		return this.isFree;
	}
	public int getNurseIDNumber()
	{
		return this.nurseIDNumber;
	}
	public int getTotalPatientsProcessedByNurse()
	{
		return this.totalPatientsProcessedByNurse;
	}
	public int getTimeRemainingForShot()
	{
		return this.timeRemainingForShot;
	}
	public Patient getAssingedPatient()
	{
		return this.assignedPatient;
	}
	public void setNurseIDNumber(int nurseNumberID)
	{
		nurseCounter++;
		this.nurseIDNumber = nurseNumberID;
	}
	public void setIsFree(boolean newIsFree)
	{
		this.isFree = newIsFree;
	}
	public void setAssignedPatient(Patient newPatient)
	{
		this.assignedPatient = newPatient;
		setIsFree(false);
	}
	public Patient removeAssignedPatient()
	{
		Patient tempPatient = this.assignedPatient;
		this.assignedPatient = null;
		setIsFree(true);
		totalPatientsProcessedByNurse++;
		
		return tempPatient;
	}
	public void setTimeRemainingForShot(int newTimeRemaining)
	{
		this.timeRemainingForShot = newTimeRemaining;
	}
	public void decrementTimeRemainingForShot()
	{
		timeRemainingForShot--;
	}
	public String toString()
	{
		return "Nurse " + this.getNurseIDNumber() + " gives shots to "
				+ this.getTotalPatientsProcessedByNurse() + " persons";
	}
}
