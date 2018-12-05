
package sohaibwork;
import java.util.Vector;

public class DisplayHelper
{
	// Initialize the Display Helper
	public DisplayHelper()
	{
	}
	// Display the booked flight of a passenger

	// Display the booked flight of a passenger
	public final void displayBoardingPassForPassenger(Vector<FlightSchedule> schedules)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* PASSENGER PASS INFORMATION         *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");

		String firstName = sharedFunctions.getString("Passenger first name: ");
		String lastName = sharedFunctions.getString("Passenger last name: ");

		System.out.print("\n");

		// Find the flight that has the passenger name
		boolean hasFlight = false;

		System.out.print( "Flight Number");
		System.out.print( "From");
		System.out.print( "To");
		System.out.print( "Dept Time");
		System.out.print( "Arr Time");
		System.out.print( "Points");
		System.out.print( "Plane");
		System.out.print( "\n");

		System.out.print( "-------------");
		System.out.print( "----");
		System.out.print( "--");
		System.out.print( "---------");
		System.out.print( "--------");
		System.out.print( "------");
		System.out.print( "-----");
		System.out.print( "\n");

		for (int i = 0; i < schedules.size(); i++)
		{
			FlightSchedule schedule = schedules.get(i);

			if (schedule.getAircraft().findPassenger(firstName, lastName) != null)
			{
				System.out.print( schedule.getFlightNumber());
				System.out.print( schedule.getFromCity().getCode());
				System.out.print( schedule.getToCity().getCode());
				System.out.print( schedule.getDepartTime());
				System.out.print( schedule.getArrivalTime());
				System.out.print( schedule.getFlyerPoints());
				System.out.print( schedule.getAircraft().getName());
				System.out.print( "\n");

				hasFlight = true;
			}
		}

		System.out.print( "\n");

		if (!hasFlight)
		{
			System.out.print( "Oh Snap: The passenger is not booked to any of the flights");
			System.out.print( "\n");
		}
	}
	// Display the schedule of a flight

	// Display the schedule of a flight
	public final void displayFlightSchedule(Vector<FlightSchedule> schedules)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* FLIGHT SCHEDULE INFORMATION        *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");

		int flightNumber = sharedFunctions.getInt("Flight number: ");

		System.out.print("\n");

		FlightSchedule schedule = searchHelper.searchFlight(schedules, flightNumber);

		if (schedule != null)
		{
			System.out.print(schedule);
			System.out.print("\n");
		}
		else
		{
			System.out.print("Error: The flight does not exist");
			System.out.print("\n");
		}
	}
	// Display all the list of cities
	// Display all the list of cities
	public final void displayAvailableCities(Vector<City> cities)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* CITIES INFORMATION                 *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("\n");

		System.out.print( "Code");
		System.out.print( "Name");
		System.out.print( "\n");

		System.out.print( "----");
		System.out.print( "----");
		System.out.print( "\n");


	//	sort(cities.begin(), cities.end(), compareFunction2);//sort the vector

		for (int i = 0; i < cities.size(); i++)
		{
			System.out.printf("%-5d", cities.get(i).getCode());
			System.out.printf("%-15d", cities.get(i).getName());
			System.out.printf("%-15d", "\n");
		}

		System.out.printf("%-15d", "\n");
	}

	// Display all passenger details of a flight

	//struct myclass {
	//	bool operator() (City i, City j) { return (i.getCode()<j.getCode()); }
	//} compareFunction;

	//bool DisplayHelper::compareFunction2(City a, City b) {
	//	return a.getCode() < b.getCode();
	//}


	// Display all passenger details of a flight
	public final void displayListOfPassengersOfAFlight(Vector<FlightSchedule> schedules)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* FLIGHT PASSENGERS                  *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("\n");

		int flightNumber = sharedFunctions.getInt("Flight number: ");

		FlightSchedule schedule = searchHelper.searchFlight(schedules, flightNumber);

		if (schedule != null)
		{
			System.out.print(schedule.getAircraft().getPassengers());
			System.out.print("\n");
		}
		else
		{
			System.out.print("Error: The flight does not exist");
			System.out.print("\n");
		}
	}
	private SharedFunctions sharedFunctions = new SharedFunctions();
	private SearchHelper searchHelper = new SearchHelper();
	//For Sorting Cities Vector
	//bool compareFunction(City a, City b);
}