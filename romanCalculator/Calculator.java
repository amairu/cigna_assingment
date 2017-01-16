package romanCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import romanCalculator.util.InputHandle;
import romanCalculator.util.RomanHandle;

public class Calculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String fileName = "input.txt";
		
		System.out.print("Input file's name is <" + fileName + ">:");
		try{
			String newFileName = in.nextLine();
			if (!newFileName.isEmpty()) {
				fileName = newFileName;
			}
			
			System.out.println("\nProblems are:");
			
			List<String> inputLines = InputHandle.readFileFromCurrentDirectory(fileName);
			Iterator<String> iter = inputLines.iterator();
			List<String> resultList = new ArrayList<String>();
			while(iter.hasNext()) {
				String romanLine = iter.next();
				System.out.println("  "+romanLine);
				resultList.add(romanCalculate(romanLine));
			}
			
			System.out.println("\nResults are:");
			Iterator<String> resultListIter = resultList.iterator();
			while(resultListIter.hasNext()) {
				System.out.println("  " + resultListIter.next());
			}
		}catch(Exception e){
			System.out.printf(e.getMessage());
		}finally {
			in.close();
		}
	}
	
	private static String romanCalculate(String equation) throws Exception{
		String[] result = equation.split("(?<=[-+*/])|(?=[-+*/])");
		String first = result[0];
		String second = result[2];
		String operator = result[1];
		
		if(result.length != 3 || first.isEmpty() || second.isEmpty()) {
			throw new Exception("Error: Wrong format!");
		}
		
		if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
			throw new Exception("Error: Wrong format!");
		}
		
		int intResult = processCalculator(
							RomanHandle.convertRomanToInt(first.toUpperCase()), 
							RomanHandle.convertRomanToInt(second.toUpperCase()), 
							operator);
		return RomanHandle.convertIntToRoman(intResult);
	}
	
	private static int processCalculator(int first, int second, String operator) {
		int result = 0;
		switch(operator){
			case "+":
				result = first + second;
				break;
			case "-":
				result = first - second;
				break;
			case "*":
				result = first * second;
				break;
			case "/":
				result = first / second;
				break;
			default:
				result = 0;
				break;
		}
		return result;
	}

}
