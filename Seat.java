
package sohaibwork;import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seat implements Closeable
{

	// Initialize the name of the seat
	public Seat(String name)
	{
		this.name = name;
		this.passenger = null;
	}

	// Delete a passenger
	public final void close()
	{
		if (this.passenger != null)
		{
                    this.passenger=null;
			
		}
	}


	// Access to the name property
	public final String getName()
	{
		return this.name;
	}

	// Set a new passenger
	public final void setPassenger(Passenger passenger)
	{
		this.passenger = passenger;
	}

	// Remove the passenger
	public final void removePassenger()
	{
		this.passenger = null;
	}

	// Get the passenger
	public final Passenger getPassenger()
	{
		return this.passenger;
	}
	//it

	// Check if the seat is available
	public final boolean isAvailable()
	{
		return this.passenger == null;
	}

	private String name;
	private Passenger passenger;


// Easy way to print out a seat

    @Override
    public String toString() {
        String line="[Seat: " + this.getName() + "]";
                
                if (!this.isAvailable())
                {
                    line=line+this.getPassenger();
                }
        
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}