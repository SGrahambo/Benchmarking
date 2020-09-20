import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;


public class Benchmarking {
	
	//*	
	//Name: Stephen Graham
	//CptS 233: Programming Assignment #1
	//Date: 9/17/20
	//git rep url: https://github.com/SGrahambo/Benchmarking.git
	//*
	
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
		
		//create Linked List and index counter
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int index = -1;
		
		
		//add and sort items from file to list
		
		long listCreationStart = System.nanoTime();
		while (readFile.hasNextInt()) {
			int n = readFile.nextInt();
			int s = index;
			int l = 0;

			if (index < 0){
				list.add(0, n);
				index++;
				System.out.println(n);
			}
					
			//stops while loop when element added to index
			while (s == index){
				if (n <= list.get(l)){
					list.add(l, n);
					index++;
					System.out.println(n);
				} else if (l == index){
					list.add(n);
					index++;
					System.out.println(n);
				}
					l++;				
			}
		}
		long listCreationFinish = System.nanoTime();
		readFile.close();
		
			//get max value in list
		long maxTimeStart = System.nanoTime();
		int max = list.get(index);
		long maxTimeFinish = System.nanoTime();
			
			
			//get min value from list
		long minTimeStart = System.nanoTime();	
		int min = list.get(0);
		long minTimeFinish = System.nanoTime();
			
			// Get the median value from list			
		long medTimeStart = System.nanoTime();
		int median = list.get(index/2);
		long medTimeFinish = System.nanoTime();
		
		
		System.out.println("The total number of items are: " + (index + 1));
		System.out.println("The max value is: " + max);
		System.out.println("The min value is: " + min);
		System.out.println("The median of the values is: " + median);
		
		//calculate times and display
		String sp = "microseconds";
		long listCreationTime = (listCreationFinish - listCreationStart)/1000;
		if (listCreationTime > 1000){
			listCreationTime = listCreationTime/1000;
			sp = "milliseconds";
		}
		if (listCreationTime > 1000){
			listCreationTime = listCreationTime/1000;
			sp = "seconds";
		}
		System.out.println("List creation time: " + listCreationTime + " " + sp);
		
		
		sp = "microseconds";
		long maxTime = (maxTimeFinish - maxTimeStart)/1000;
		if (maxTime > 1000){
			maxTime = maxTime/1000;
			sp = "milliseconds";
		}
		if (maxTime > 1000){
			maxTime = maxTime/1000;
			sp = "seconds";
		}
		System.out.println("The max value was calculated in " + maxTime + " " + sp);


		sp = "microseconds";
		long minTime = (minTimeFinish - minTimeStart)/1000;
		if (minTime > 1000){
			minTime = minTime/1000;
			sp = "milliseconds";
		}
		if (minTime > 1000){
			minTime = minTime/1000;
			sp = "seconds";
		}
		System.out.println("The min value was calculated in " + minTime + " " + sp);
		
		
		sp = "microseconds";
		long medTime = (medTimeFinish - medTimeStart)/1000;
		if (medTime > 1000){
			medTime = medTime/1000;
			sp = "milliseconds";
		}
		if (medTime > 1000){
			medTime = medTime/1000;
			sp = "seconds";
		}
		System.out.println("The median value was calculated in " + medTime + " " + sp);
		}
		
		
		catch (FileNotFoundException ex)  
    {
        System.out.println("Oh wait. That book doesn't exist, or you lost it, or you forgot the extension, or whoever wrote this code is an idiot.");
    }
		
		}
		
		
	}


	