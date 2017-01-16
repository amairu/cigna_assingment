package romanCalculator.util;

public class RomanHandle {
	public static int convertRomanToInt (String roman) {
		if (roman.isEmpty()) {
			return 0;
		}
		
		int romanLength = roman.length();
		int result = 0;
		int preCurrentValue = 0;
		
		for (int i = romanLength-1; i>=0; i--) {
			int currentValue = getRomanIntValue(roman.charAt(i));
			
			if (i == romanLength - 1) {
				result += currentValue;
			} else {
				if (currentValue < preCurrentValue) {
					result -= currentValue;
				} else {
					result += currentValue;
				}
			}
			
			preCurrentValue = currentValue;
		}
		
		return result;
	}
	
	public static String convertIntToRoman (int value) {
		String roman = "";
		
		int romanValue[] = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String romanNumber[] = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		int numberOfRepeatRoman = 0;
		for(int i=0; value>0; i++) {
			numberOfRepeatRoman = value/romanValue[i];
			for(int j=0; j<numberOfRepeatRoman; j++){
				roman += romanNumber[i];
			}
			value = value%romanValue[i];
		}
		
		return roman;
	}
	
	private static int getRomanIntValue(char ch) {
		int value = 0;
		switch(ch){
			case 'I':
				value = 1;
				break;
			case 'V':
				value = 5;
				break;
			case 'X':
				value = 10;
				break;
			case 'L':
				value = 50;
				break;
			case 'C':
				value = 100;
				break;
			case 'D':
				value = 500;
				break;
			case 'M':
				value = 1000;
				break;
			default:
				value = 0;
				break;
		}
		return value;
	}
}
