import java.io.BufferedReader;//Scaner
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.io.File;
import java.util.Scanner;

public class Aircraft{

	public static void main(String[] args) throws Exception {
		if (args.length != 1)
		{
			System.out.println("one and only one argument from the command line is available");
			System.exit(1);
		}
		try{
			File file = new File(args[0]);
			//BufferedReader reader = new BufferedReader(file);

			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				System.out.println(data);
				//regexChecker("?<=\\s|^)\\d+(?=\\s|$", data);

			}
			inputStream.close();
		}catch (IOException e){
			e.printStackTrace();
		}

				//reader.close();
	protected	long 		id;
	protected	String		name;
	protected	Coordinates coordinates;
	private		long		idCouter;

	protected	Aircraft(String name, Coordinates coordinates){

		this.name = name;
		this.coordinates = coordinates;
	}
	private		void/*long*/ nextld(){
		int i;
		i = 0;
	}


	}
}
	/*public static void regexChecker(String theRegex, String str2Check){

		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2Check);

		while (regexMatcher.find()){
			if (regexMatcher.group().length != 0){
				System.out.println("TYT");
			}
		}
	}	
	*/
