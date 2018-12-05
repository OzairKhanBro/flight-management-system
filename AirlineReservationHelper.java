
package sohaibwork;

import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirlineReservationHelper
{
	// Initialize the AirlineReservationHelper

	// Initialize the AirlineReservationHelper
	public AirlineReservationHelper()
	{
            try {
                InitializeCities();
                InitializeFlightSchedules();
                dataFileHelper.loadData(schedules); // there is diffrent help
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AirlineReservationHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	// Start the AirlineReservationHelper

	// Start the banking system
	public final void run()
	{
		// Display a menu for the user to choose a function to perform
		while (true)
		{
			System.out.print("**************************************");
			System.out.print("\n");
			System.out.print("* MAIN MENU                          *");
			System.out.print("\n");
			System.out.print("**************************************");
			System.out.print("\n");
			System.out.print("1 - Book a new reservation.");
			System.out.print("\n");
			System.out.print("2 - Cancel a reservation.");
			System.out.print("\n");
			System.out.print("3 - Display boarding pass for a passenger.");
			System.out.print("\n");
			System.out.print("4 - Display flight schedule.");
			System.out.print("\n");
			System.out.print("5 - Display available cities.");
			System.out.print("\n");
			System.out.print("6 - List passengers on a given flight and seat assignments. ");
			System.out.print("\n");
			System.out.print("0 - Exit");
			System.out.print("\n");
			System.out.print("**************************************");
			System.out.print("\n");

			int choice = sharedFunctions.getInt("Choice: ");

			System.out.print("\n");

			if (choice == 0)
			{
				break;
			}

			switch (choice)
			{
			case 1:
				reservationManager.bookReservation(cities, schedules);
				break;
			case 2:
				reservationManager.cancelReservation(schedules);
				break;
			case 3:
				displayHelper.displayBoardingPassForPassenger(schedules);
				break;
			case 4:
				displayHelper.displayFlightSchedule(schedules);
				break;
			case 5:
				displayHelper.displayAvailableCities(new Vector<City >(cities));
				break;
			case 6:
				displayHelper.displayListOfPassengersOfAFlight(schedules);
				break;
			}

			System.out.print("\n");
		}
		System.out.print("Do you want to save changes?");
		System.out.print("\n");
		System.out.print("1 - Yes. Save Changes");
		System.out.print("\n");
		System.out.print("Any Other Number to Ignore Changes");
		System.out.print("\n");
		int choice = sharedFunctions.getInt("Choice: ");

		if (choice == 1)
		{
			dataFileHelper.saveData(schedules);
		}
		// Delete all the memory allocated cities
//		for (int i = 0; i < cities.size(); i++)
//		{
                cities.removeAllElements();
		//}
		// Delete all memory allocated flight schedules
//		for (int i = 0; i < schedules.size(); i++)
//		{
			schedules.removeAllElements();
		//}
	}

	private SearchHelper searchHelper = new SearchHelper();
	private SharedFunctions sharedFunctions = new SharedFunctions();
	private ReservationManager reservationManager = new ReservationManager();
	private DisplayHelper displayHelper = new DisplayHelper();
	private DataFile dataFileHelper = new DataFile();
	// Initialize the cities
	private void InitializeCities()
	{
		cities.add(new City("ATL", "Atlanta"));
		cities.add(new City("CHI", "Chicago"));
		cities.add(new City("DFW", "Dallas/Fort Worth"));
		cities.add(new City("HAW", "Hawaii"));
		cities.add(new City("LAX", "Los Angeles"));
		cities.add(new City("NYC", "New York City"));
		cities.add(new City("ORL", "Orlando"));
	}
	// Initialize the flight schedules

	// Initialize the flight schedules
	private void InitializeFlightSchedules()
	{
		String[] fromCodes = {"HAW", "NYC", "NYC", "NYC", "NYC", "NYC", "NYC", "NYC", "DFW", "DFW", "DFW", "DFW", "DFW", "DFW", "CHI", "CHI", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ORL", "ATL", "ATL", "ATL", "ATL", "ATL"};
		String[] toCodes = {"LAX", "DFW", "DFW", "DFW", "CHI", "CHI", "ORL", "ORL", "NYC", "NYC", "NYC", "ORL", "ORL", "ORL", "NYC", "NYC", "HAW", "NYC", "NYC", "NYC", "DFW", "DFW", "DFW", "ATL", "ATL", "ATL", "ATL", "ATL", "ORL", "ORL", "ORL", "ORL", "ORL"};
		String[] deptTime = {"04:15", "9:00", "12:00", "16:00", "10:12", "18:24", "11:30", "17:30", "9:00", "12:00", "16:00", "12:30", "14:30", "19:30", "9:00", "19:00", "14:30", "8:30", "14:30", "19:30", "9:30", "13:30", "17:30", "09:00", "11:00", "13:00", "15:00", "17:00", "08:00", "10:00", "12:00", "14:00", "16:00"};
		String[] arrivTime = {"15:15", "11:30", "14:30", "18:30", "12:12", "20:24", "1:00", "19:00", "11:30", "14:30", "18:30", "15:30", "17:30", "22:30", "11:00", "21:00", "1:30", "10:30", "16:00", "21:20", "12:00", "16:00", "20:00", "9:31", "11:31", "13:31", "15:31", "17:31", "8:31", "10:31", "12:31", "14:32", "16:30"};
		int[] flightNumbers = {602, 1201, 1202, 1203, 902, 903, 202, 204, 1204, 1205, 1206, 302, 304, 306, 904, 905, 601, 201, 203, 205, 301, 303, 305, 101, 103, 105, 107, 109, 100, 102, 104, 106, 108};
		char[] aircraftTypes = {'A', 'B', 'B', 'B', 'A', 'A', 'B', 'A', 'B', 'B', 'B', 'B', 'A', 'B', 'B', 'A', 'B', 'B', 'A', 'A', 'B', 'B', 'B', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
		int[] flyerPoints = {1000, 500, 500, 500, 500, 500, 700, 700, 500, 500, 500, 700, 700, 700, 500, 500, 2000, 700, 700, 700, 700, 700, 700, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
		//
		for (int i = 0; i < 33; i++)
		{
			Aircraft aircraft = null;

			if (aircraftTypes[i] == 'A')
			{
				aircraft = new Aircraft("A", 5, 5, 2);
			}
			else
			{
				// 5 row 4 coloum 1 is a number of the ailds
				aircraft = new Aircraft("B", 5, 4, 1);
			}
			// i push all flight schedual to vector
			schedules.add(new FlightSchedule(searchHelper.findCity(new Vector<City >(cities), 
                                fromCodes[i]), searchHelper.findCity(new Vector<City >(cities), 
                                        toCodes[i]), deptTime[i], arrivTime[i], flightNumbers[i], aircraft, flyerPoints[i]));
		}
	}
	private Vector<City > cities = new Vector<City >();
	private Vector<FlightSchedule > schedules = new Vector<FlightSchedule >();
}