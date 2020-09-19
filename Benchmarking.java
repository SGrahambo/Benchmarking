import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;


public class Benchmarking {
	
	
	
	public static void main(String[] args) throws InterruptedException{
		
		Scanner readme = new Scanner(System.in);
		
		
		String fileName = "";
		
		// Checks for commandline argument
		
		if (args.length == 0) {
		System.out.println("You forgot to enter the filename in the command line again. Best tell me what it is or nothing happens: ");
		
		//user input of filename
		
		fileName = readme.nextLine();
		}else
		{
		
		fileName = args[0];
		}
		
		System.out.println("Get yourself nice and comfy, because today's story is \"" + fileName + "\".");
		System.out.println("And it's not a picture book this time so use your imagination.");
		
		
		// Reading from file
		
		try {
		File file = new File(fileName);
		Scanner readFile = new Scanner(file);
		int line = readFile.nextInt();
		
		//create Linked List and index counter
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int index = 0;
		
		
		//add items from file to list
		
		long listCreationStart = System.nanoTime();
		while (readFile.hasNextInt()) {
			int n = readFile.nextInt();
			list.add(n);
			index++;
		}
		long listCreationFinish = System.nanoTime();
		readFile.close();
		
		//get max value in list
		
		int max = 0;
		int value;
		long maxTimeStart = System.nanoTime();
		for (int count = 0; count < index; count++){
			value = list.get(count);
			if (count == 0 || max < value){
				max = value;
			}	
			
		}
			long maxTimeFinish = System.nanoTime();
			
			
			//get min value from list
			
		int min = 0;
		long minTimeStart = System.nanoTime();
		for (int count = 0; count < index; count++){
			value = list.get(count);
			if (count == 0 || min > value){
				min = value;
			}	
		}
			long minTimeFinish = System.nanoTime();
			
			// Get the median value from list
			
		int totalValue = 0;
		long medTimeStart = System.nanoTime();
		for (int count = 0; count < index; count++){
			value = list.get(count);
			totalValue = totalValue + value;
			}
		int median = totalValue/(index + 1);
		long medTimeFinish = System.nanoTime();
		
		
		//calculate times time in nanoseconds
		
		long listCreationTime = (listCreationFinish - listCreationStart);
		long maxTime = (maxTimeFinish - maxTimeStart);
		long minTime = (minTimeFinish - minTimeStart);
		long medTime = (medTimeFinish - medTimeStart);
			
		
		//Print results
		
		System.out.println("The total number of items are: " + (index + 1));
		System.out.println("List creation time: " + listCreationTime + " nanoseconds");
		System.out.println("The max value is: " + max);
		System.out.println("The max value was calculated in " + maxTime + " nanoseconds");
		System.out.println("The min value is: " + min);
		System.out.println("The min value was calculated in " + minTime + " nanoseconds");
		System.out.println("The sum of the values is: " + totalValue);
		System.out.println("The median of the values is: " + median);
		System.out.println("The median value was calculated in " + medTime + " nanoseconds");
		
		}
		
		
		catch (FileNotFoundException ex)  
    {
        System.out.println("Oh wait. That book doesn't exist, or you lost it, or you forgot the extension, or whoever wrote this code is an idiot.");
    }
		
		}
		
		
	}


	