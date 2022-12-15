public class Pfizer extends Vaccine
{
	private static int pfizerDoseCounter = 0;
	private String doseID;
	private final double doseCost = 15.50;
	
	public Pfizer() 
	{
		super("Pfizer");
		this.setDoseID();
	}
	public void setDoseID()
	{
		pfizerDoseCounter++;
		this.doseID = "Pfizer " + pfizerDoseCounter;
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
