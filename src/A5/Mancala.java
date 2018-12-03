package A5;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Mancala {


	public static void main(String[] args) {
		
		try {
			//change file address 
			Scanner bringFile = new Scanner(new File("C:/Users/ssgc/eclipse-workspace/Ass5COMP251/src/A5/testMancala.txt"));
			int countZero = 0;
			
			int numProblems = bringFile.nextInt();
			
			int []  moves = new int[numProblems];
			int iterScen = 0;
			
			bringFile.nextLine(); 
			
			ArrayList<int[]> bucket = new ArrayList<int []>();
			
			
			//All scenarios are in bucket
			for (int iter = 0; iter < numProblems; iter++) {
				int[] scenario = new int[12];
				for (int i = 0; i < 12; i++) {
					scenario[i] = bringFile.nextInt();
				}
				bucket.add(scenario);
				if (bringFile.hasNext()) {
					bringFile.nextLine();
				}
				else {
					//System.out.println("Thats enough");
				}
				
			}
			
			
			//Printing all scenarios in bucket
			for (int [] scenario : bucket) {
				for (int i = 0; i < 12; i++) {
					System.out.print(scenario[i]);
				}
				System.out.println();
			}
			System.out.println();
			
			
			//The Mancala Strategy
			for (int [] scenario : bucket) {
				int movesMade = 0;
				//check if scenario is empty or full or has 1 pebble
				for (int i = 0; i < 12; i++) {
					if (scenario[i] == 0){
						countZero++;
					}
				}
				//No moves can be made
				if (countZero == 12 || countZero == 11 || countZero == 0) {
					moves[iterScen] = 0;
				}
				
				else {
					
					//Does ABC fit _** or **_
					// ABC = 011 or 110
					//break when scenario[9]
					
					int shiftCtr = 0;
					
					while (shiftCtr < 10) {
						
						
						for (int i = 0; i < 10; i++) {
							
							
							int A = scenario[i];
							int B = scenario[i+1];
							int C = scenario[i+2];
							
							if ((A == 0) && (B == 1) && (C == 1)) {
								//turning B = 0
								B = 0;
								A = 1;
								C = 0;
								shiftCtr = 0;
								movesMade++; 
							}
							if ((A == 1) && (B == 1) && (C == 0)) {
								B = 0;
								A = 0;
								C = 1;
								shiftCtr = 0;
								movesMade++;
							}
							shiftCtr++;
						}
											
					}
					
				}
	
				moves[iterScen] = movesMade;
				iterScen++;
			}
			
			//Print all moves
			System.out.println("Moves made: ");
			for(int i = 0; i < moves.length; i++) {
				System.out.println(moves[i]);
			}
			
			
		}catch (FileNotFoundException fnf) {
			System.out.println("File not there");
		}
		
		
		
		
		

	}

}
