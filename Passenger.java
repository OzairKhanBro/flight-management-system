
package sohaibwork;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Passenger
{

	// Initialize the passenger properties
	public Passenger(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}


	// Access to the first name property
	public final String getFirstName()
	{
		return this.firstName;
	}

	// Access to the last name property
	public final String getLastName()
	{
		return this.lastName;
	}

	private String firstName;
	private String lastName;


// Easy way to print out the details of a passenger

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName(); //To change body of generated methods, choose Tools | Templates.
    }

        
        
}