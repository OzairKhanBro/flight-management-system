
package sohaibwork;
import java.util.Vector;

public class ReservationManager
{
	// Initialize the Reservation Manager
	public ReservationManager()
	{
	}
	// A function to book a new reservation for a customer

	// A function to book a new reservation for a customer
	public final void bookReservation(Vector<City > cities, Vector<FlightSchedule > schedules)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* BOOK RESERVATION                   *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");

		String firstName = sharedFunctions.getString("Passenger first name: ");
		String lastName = sharedFunctions.getString("Passenger last name: ");

		System.out.print("\n");

		System.out.print("Flight Schedules: ");
		System.out.print("\n");

		System.out.print( "Flight Number");
		System.out.print( "From");
		System.out.print( "To");
		System.out.print( "Plane");
		System.out.print( "\n");

		System.out.print( "-------------");
		System.out.print( "----");
		System.out.print( "----");
		System.out.print( "-----");
		System.out.print( "\n");

		for (int i = 0; i < schedules.size(); i++)
		{
			System.out.print( schedules.get(i).getFlightNumber());
			System.out.print( schedules.get(i).getFromCity().getCode());
			System.out.print( schedules.get(i).getToCity().getCode());
			System.out.print( schedules.get(i).getAircraft().getName());
			System.out.print( "\n");
		}

		System.out.print( "\n");

		int flightNumber = sharedFunctions.getInt("Flight number: ");

		System.out.print( "\n");

		// Check the existence of the flight
		FlightSchedule flightSchedule = searchHelper.searchFlight(schedules, flightNumber);

		if (flightSchedule == null)
		{
			System.out.print( "Oh Snap: The flight schedule ");
			System.out.print( flightNumber);
			System.out.print( " does not exist");
			System.out.print( "\n");
			return;
		}

		// Check that the customer is not double booking on the same flight
		if (flightSchedule.getAircraft().findPassenger(firstName, lastName) != null)
		{
			System.out.print( "Oh Snap: The passenger is previously booked to this flight");
			System.out.print( "\n");
			return;
		}

		// Let the customer select a seating number
		System.out.print( flightSchedule.getAircraft());

		System.out.print( "\n");
		String seatName = sharedFunctions.getString("Select seat (enter seat name) for the passenger: ");

		// Attempt to seat the passenger on the aircraft
		if (flightSchedule.getAircraft().seatPassenger(seatName, firstName, lastName))
		{
			System.out.print( "Heads Up: The passenger has successfully booked for the flight");
			System.out.print( "\n");
		}
		else
		{
			System.out.print( "Oh Snap:: Either the seat name is invalid or the seat is occupied");
			System.out.print( "\n");
		}
	}
	// A function to cancel a reservation of a customer

	// A function to cancel a reservation of a customer
	public final void cancelReservation(Vector<FlightSchedule> schedules)
	{
		System.out.print("**************************************");
		System.out.print("\n");
		System.out.print("* CANCEL RESERVATION                 *");
		System.out.print("\n");
		System.out.print("**************************************");
		System.out.print("\n");

		String firstName = sharedFunctions.getString("Passenger first name: ");
		String lastName = sharedFunctions.getString("Passenger last name: ");
		int flightNumber = sharedFunctions.getInt("Flight number to cancel: ");

		System.out.print("\n");

		// Find the passenger who has the ID from the flights
		boolean passengerUnseated = false;

		FlightSchedule schedule = searchHelper.searchFlight(schedules, flightNumber);

		if (schedule != null)
		{
			passengerUnseated = schedule.getAircraft().removePassenger(firstName, lastName);
		}

		if (passengerUnseated)
		{
			System.out.print("Heads Up: The passenger has been unseated.");
			System.out.print("\n");
		}
		else
		{
			System.out.print("Oh Snap: The passenger does not exist in any of the flights.");
			System.out.print("\n");
		}
	}
	private SharedFunctions sharedFunctions = new SharedFunctions();
	private SearchHelper searchHelper = new SearchHelper();
}