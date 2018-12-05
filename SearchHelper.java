
package sohaibwork;
import java.util.Vector;

public class SearchHelper
{
	// Initialize the 
	public SearchHelper()
	{
	}
	// Find a city from the list of cities return the refrence 

	// Find a city from the list of cities
	public final City findCity(Vector<City> cities, String code)
	{
		for (int i = 0; i < cities.size(); i++)
		{
			if (cities.get(i).getCode().equals(code))
			{
				return cities.get(i);
			}
		}

		return null;
	}
	// Search the schedules for the flight pass by refrence here i didnt  creat a copy
	// and i go to return the refrence flighy schual

	// Search the schedules for the flight
	public final FlightSchedule searchFlight(Vector<FlightSchedule> schedules, int flightNumber)
	{
		for (int i = 0; i < schedules.size(); i++)
		{
			if (schedules.get(i).getFlightNumber() == flightNumber)
			{
				return schedules.get(i);
			}
		}

		return null;
	}
}