
package sohaibwork;import java.util.*;

public class SharedFunctions
{
	// Initialize the Shared Functions

	// Initialize the SharedFunctions
	public SharedFunctions()
	{
	}

	// Forces the user to enter an integer

	// Forces the user to enter an integer value
	public final int getInt(String prompt)
	{
		while (true)
		{
			System.out.print(prompt);
			String tempValue;
			tempValue = new Scanner(System.in).nextLine();

			int value;
                        try{
                            value=Integer.parseInt(tempValue);
                            return value;
                        }catch(NumberFormatException e)
                        {
                            
                        }
                            
			System.out.print("Error: Please enter an numerical value");
			System.out.print("\n");
		}
	}
	// Forces the user to enter a string value

	// Forces the user to enter a string value
	public final String getString(String prompt)
	{
		while (true)
		{
			System.out.print(prompt);
			String value;
			value = new Scanner(System.in).nextLine();

			if (value.length() == 0)
			{
				System.out.print("Error: Please enter a string");
				System.out.print("\n");
				continue;
			}
			return value;
		}
	}
}