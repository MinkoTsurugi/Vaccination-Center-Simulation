public class Moderna extends Vaccine
{
	private static int modernaDoseCounter = 0;
	private String doseID;
	private final double doseCost = 12.50;
	
	public Moderna()
	{
		super("Moderna");
		this.setDoseID();
	}
	public void setDoseID()
	{
		modernaDoseCounter++;
		this.doseID = "Moderna " + modernaDoseCounter;
	}
	public String getDoseID()
	{
		return this.doseID;
	}
	public double getDoseCost() 
	{
		return this.doseCost;
	}
}
