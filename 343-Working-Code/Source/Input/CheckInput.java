import java.util.Scanner;
// Holds the Scanner Object
public class CheckInput {
	/**
	 * Gets a valid integer value between a defined range
	 * @param min the smallest valid input
	 * @param max the largest valid input
	 * @param prompt the string that prompts the user to enter some decision
	 * @return validated integer between min and max
	 */
	public static int getIntBetween(int min, int max, String prompt) {
		Scanner in = new Scanner(System.in);
		int input = min - 1;
		boolean valid = false;
		while(!valid) {
			System.out.print(prompt + ": ");
			if(in.hasNextInt()) {
				input = in.nextInt();
				in.nextLine();
				if(input > (min - 1) && input < (max + 1)) {
					valid = true;
					return input;
				}
				else {
					System.out.println("\nInvalid Range. Please enter a digit between " + min  + " and " + max + ".\n");
				}
			}
			else {
				System.out.println("\nInvalid Input. Please enter an integer.\n");
                in.nextLine();
			}
		}
		return input;
	}
	
	/**
	 * Gets a valid positive integer value
	 * @param prompt the string that prompts the user to enter some decision
	 * @return validated positive integer
	 */
	public static int getPositiveInt(String prompt) {
		Scanner in = new Scanner(System.in);
		int input = -1;
		boolean valid = false;
		while(!valid) {
			System.out.print(prompt + ": ");
			if(in.hasNextInt()) {
				input = in.nextInt();
				in.nextLine();
				if(input >= 0) {
					valid = true;
					return input;
				}
				else {
					System.out.println("\nInvalid Sign. Please enter a positive integer.\n");
				}
			}
			else {
				System.out.println("\nInvalid Input. Please enter an integer.\n");
                in.nextLine();
			}
		}
		return input;
	}
	
	/**
	 * Gets a valid float value
	 * @param prompt the string that prompts the user to enter some decision
	 * @return validated float value
	 */
	public static float getPositiveFloat(String prompt) {
		Scanner in = new Scanner(System.in);
		float input = -1f;
		boolean valid = false;
		while(!valid) {
			System.out.print(prompt + ": ");
			if(in.hasNextFloat()) {
				input = in.nextFloat();
				in.nextLine();
				if(input >= 0) {
					valid = true;
					return input;
				}
				else {
					System.out.println("\nInvalid Sign. Please enter a positive float.\n");
				}
			}
			else {
				System.out.println("\nInvalid Input. Please enter an float.\n");
                in.nextLine();
			}
		}
		return input;
	}
	
	/**
	 * Gets user input String -- not much to see here b/c it's like a normal Scanner; Built
	 * to save writing extra lines of code
	 * @param prompt the string that prompts the user to enter some decision
	 * @return inputted String
	 */
	public static String getString(String prompt) {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.print(prompt + ": ");
		input = in.nextLine();
		return input;
	}
}
