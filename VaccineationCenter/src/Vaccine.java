public abstract class Vaccine 
{
	private String maker;
	
	public Vaccine(String newMaker)
	{
		setMaker(newMaker);
	}
	
	public String getMaker()
	{
		return this.maker;
	}
	public void setMaker(String newMaker)
	{
		this.maker = newMaker;
	}
	public String toString()
	{
		return this.getMaker();
	}
	public abstract void setDoseID();
	public abstract String getDoseID();
	public abstract double getDoseCost();
}
