

package sohaibwork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataFile
{
	// Initialize the Data File
	public DataFile()
	{
	}
	// Load the booked passengers from file

	// Load the booked passengers from file
	public final void loadData(Vector<FlightSchedule > schedules) throws FileNotFoundException
	{
	    File inFile = new File("data.txt");
            Scanner sc = new Scanner(inFile);
            
		String line;

		// The first line contains the number of flights that has booked passengers
		int flightsCount = 0;
		line=sc.nextLine();
                flightsCount=Integer.parseInt(line);
		for (int i = 0; i < flightsCount; i++)
		{
			// For each flight, the first line is the flight number
			int flightNumber = 0;
			flightNumber =sc.nextInt();
                        
			FlightSchedule schedule = searchHelper.searchFlight(schedules, flightNumber);

			// Next line is the number of booked passengers
			int bookedPassengersCount = 0;
			bookedPassengersCount=sc.nextInt();

			for (int j = 0; j < bookedPassengersCount; j++)
			{
				// For each passenger, the first line is the seat name, then the first and last name
				String seatName;
				seatName=sc.nextLine();
				String firstName;
				firstName=sc.nextLine();
				String lastName;
				lastName=sc.nextLine();

				schedule.getAircraft().seatPassenger(seatName, firstName, lastName);
			}
		}

		sc.close();
	}
	// Save the booked passengers on each of the schedules

	// Save the booked passengers on each of the schedules
	public final void saveData(Vector<FlightSchedule> schedules)
	{
                PrintWriter outFile = null;
            try {
                //ofstream outFile = new ofstream("data.txt");
                outFile = new PrintWriter("data.txt", "UTF-8");
                // Print out the total number of flight schedules that has booked passengers
                int schedulesWithPassengers = 0;
                for (int i = 0; i < schedules.size(); i++)
                {
                    if (schedules.get(i).getAircraft().getPassengersCount() > 0)
                    {
                        schedulesWithPassengers++;
                    }
                }
                // Write to file the number of schedules with passengers
                outFile.write(schedulesWithPassengers + "\n");
                // Write out the schedules with passengers the booking information
                for (int i = 0; i < schedules.size(); i++)
                {
                    FlightSchedule schedule = schedules.get(i);
                    
                    // Do not write the aircraft schedule if in case there are no passengers
                    if (schedule.getAircraft().getPassengersCount() == 0)
                    {
                        continue;
                    }
                    
                    // For each schedule print out the important details only
                    outFile.write(schedule.getFlightNumber() + "\n");
                    
                    // For each flight print out the passengers booked, along with their seats
                    outFile .write( schedule.getAircraft().getPassengersCount() + "\n");
                    outFile .write( schedule.getAircraft().getPassengerAndSeats());
                }
                outFile.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();//Logger.getLogger(DataFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                //Logger.getLogger(DataFile.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                outFile.close();
            }
	}
	private SearchHelper searchHelper = new SearchHelper();
}