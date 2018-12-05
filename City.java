
package sohaibwork;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class City
{

	// Initialize the city properties
	public City(String code, String name)
	{
		this.code = code;
		this.name = name;
	}


	// Access to the code property
	public final String getCode()
	{
		return this.code;
	}

	// Access to the name property
	public final String getName()
	{
		return this.name;
	}

	//bool operator <(City & other);

	private String code;
	private String name;


	// Easy way to display for print a code and the name of the city 
	private DataOutputStream leftShift (DataOutputStream out, City city)
	{
            try {
                out.write(new String("Code : " + city.getCode() + "\n"
                        +"Name : " + city.getName()).getBytes());
            } catch (IOException ex) {
                Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
            }

		return out;
	}
}
//bool City::operator<(City& other) {
//	return this->name < other.name;
//}