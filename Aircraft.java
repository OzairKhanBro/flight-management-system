
package sohaibwork;
import java.io.*;
import java.util.Vector;

public class Aircraft implements Closeable
{

	// Initialize the aircraft properties
	public Aircraft(String name, int rows, int columns, int aisleIndex)
	{
		this.name = name;
		this.aisleIndex = aisleIndex;

		String columnNames = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int nextColumnName = 0;

		// Create the seats only where there is no aisle
		for (int i = 0; i < rows; i++)
		{
			Vector<Seat > rowSeats = new Vector<Seat >();

			for (int j = 0; j < columns; j++)
			{
				if (j != aisleIndex)
				{
					StringBuffer ss = new StringBuffer();
					ss.append((i + 1)+columnNames.charAt(nextColumnName++));
					rowSeats.add(new Seat(ss.toString()));
				}
				else
				{
					rowSeats.add(null);
				}
			}

			this.seats.add(rowSeats);
			nextColumnName = 0;
		}
	}

	// Deallocate all the created seats
	public final void close()
	{
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null)
				{
					this.seats.get(i).get(j).close();
				}
			}
		}
	}


	// Find the passenger in the aircraft if they are reserved
	public final Passenger findPassenger(String firstName, String lastName)
	{
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) == null)
				{
					continue;
				}

				Passenger passenger = this.seats.get(i).get(j).getPassenger();

				if (passenger != null && passenger.getFirstName().compareTo(firstName) == 0 && passenger.getLastName().compareTo(lastName) == 0)
				{
					return passenger;
				}
			}
		}

		return null;
	}

	// Attempt to remove the passenger from aircraft
	public final boolean removePassenger(String firstName, String lastName)
	{
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) == null)
				{
					continue;
				}

				Passenger passenger = this.seats.get(i).get(j).getPassenger();

				if (passenger != null && passenger.getFirstName().compareTo(firstName) == 0 && passenger.getLastName().compareTo(lastName) == 0)
				{
					this.seats.get(i).get(j).setPassenger(null);
					passenger = null;
					return true;
				}
			}
		}

		return false;
	}

	// Find the seat and let the passenger seat on it
	public final boolean seatPassenger(String seatName, String firstName, String lastName)
	{
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null && this.seats.get(i).get(j).getName().equals(seatName) && this.seats.get(i).get(j).isAvailable())
				{
					this.seats.get(i).get(j).setPassenger(new Passenger(firstName, lastName));
					return true;
				}
			}
		}

		return false;
	}

	// Find the seating name of the passenger
	public final String findPassengerSeat(String firstName, String lastName)
	{
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null &&
                                        this.seats.get(i).get(j).getPassenger().getFirstName().equals(firstName) 
                                        && this.seats.get(i).get(j).getPassenger().getLastName().equals(lastName))
				{
					return this.seats.get(i).get(j).getName();
				}
			}
		}

		return "";
	}

	// Get the list of passengers of an aircraft
	public final String getPassengers()
	{
		StringBuilder ss = new StringBuilder();

		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null && this.seats.get(i).get(j).getPassenger() != null)
				{
					ss .append(this.seats.get(i).get(j) + "\n");
				}
			}
		}

		return ss.toString();
	}

	// Return a string representation of the aircraft contents
	public final String toString()
	{
		StringBuilder ss = new StringBuilder();

		ss.append("Legend: XX = Aisle" + "\n");
		ss .append("        OO = Occupied" + "\n");
		ss .append("\n");

		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) == null)
				{
					ss .append(" XX ");
				}
				else if (this.seats.get(i).get(j).isAvailable())
				{
					ss.append(" " + seats.get(i).get(j).getName() + " ");
				}
				else
				{
					ss.append(" OO ");
				}
			}

			ss .append("\n");
		}

		return ss.toString();
	}

	// Get the passenger names and the seats
	public final String getPassengerAndSeats()
	{
		StringBuilder ss = new StringBuilder();

		// Each data will be arranged in 3 lines, where seat number first, then first name, then last name
		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null && this.seats.get(i).get(j).getPassenger() != null)
				{
					Passenger passenger = this.seats.get(i).get(j).getPassenger();
					ss.append(this.seats.get(i).get(j).getName() + "\n");
					ss.append(passenger.getFirstName()+ "\n");
					ss.append(passenger.getLastName() + "\n");
				}
			}
		}

		return ss.toString();
	}

	// Get the type of plane
	public final String getName()
	{
		return this.name;
	}

	// Count how many passengers are booked
	public final int getPassengersCount()
	{
		int count = 0;

		for (int i = 0; i < this.seats.size(); i++)
		{
			for (int j = 0; j < this.seats.get(i).size(); j++)
			{
				if (this.seats.get(i).get(j) != null && this.seats.get(i).get(j).getPassenger() != null)
				{
					count++;
				}
			}
		}

		return count;
	}

	private String name; // Name of the aircraft
	private int aisleIndex; // The column in the seats that is not supposed to be occupied
	private Vector<Vector<Seat >> seats = new Vector<Vector<Seat>>(); // The seating arrangement

}
// Display the seating arrangement 

