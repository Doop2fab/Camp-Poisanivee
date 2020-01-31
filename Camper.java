import java.util.*;
import java.io.*;
/**
 * @author Andrew Spores
 */

public class Camper implements Comparable
{
    String command; String name; int age; String sex;

    public Camper(String n, int a, String s)
    {
        name = n; age = a; sex = s;
    }
    
    /**@return name of camper */
    public String getName(){return name;}
    /**@return age of camper */
    public int getAge(){return age;}
    /**@return gender of camper */
    public String getSex(){return sex;}
    /**@return full object */
    public String toString()
    {return name+" "+age+" "+sex;} 
    /**compares campers by alphabetical order*/
    public int compareTo(Object y)
    {
        if(y instanceof Camper)
		{
			Camper c=(Camper)y;
			if(name.compareTo(c.getName()) < 0) return -1;
			if(name.compareTo(c.getName()) == 0) return 0;
			return 1;
		}
		else
		{
			System.out.println("Error - not a Camper!");
			System.exit(0); // stops the program
			return 0;
		}
    }
}
