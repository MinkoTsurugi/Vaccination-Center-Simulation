import java.io.FileNotFoundException;
import java.util.*;

public class ModelVaccinationSite
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of Vaccination Site: ");
		String siteName = in.nextLine();
		System.out.println("Please enter a seed value as an int: ");
		int seed = in.nextInt();
		System.out.println("Please enter the number of nurse as an int: ");
		int numOfNurse = in.nextInt();
		System.out.println("Please enter the total number of vaccine doses as int: ");
		int numOfVaccine = in.nextInt();
		
		VaccinationSite site = new VaccinationSite(siteName, seed, numOfNurse, numOfVaccine);
		site.openVaccinationSiteLine();
		
		System.out.println("Please enter the number of minutes to keep entrance open after the site open: ");
		int duration = in.nextInt();
		site.operateVaccinationSite(duration);
		
		System.out.println("Please enter the name of the output file for Vaccination Site result: ");
		String out = in.next();
		site.generateVaccinationSiteResults(out);
		
		in.close();
	}
}
