package joshix.bluegalaxy.main;

public class Utils {

	public static String arrayToString(String[] array, int startIndex) {
		String result = "";
		for (int i = startIndex; i < array.length; i++) {
			if(i == startIndex) {
				result = result + array[i];
			} else {
				result = result + " " + array[i];
			}
		}
		return result;
	}
	
	public static int Normalize(int number) {
		if(number < 0)
			number *= -1;
		
		return number;
	}
	
	public static double Normalize(double number) {
		if(number < 0)
			number *= -1;
		
		return number;
	}
	
	public static float Normalize(float number) {
		if(number < 0)
			number *= -1;
		
		return number;
	}
	
	public static int addStupid(int op, int op_) {
		
		String resultText = new Integer(op).toString() + new Integer(op).toString();
		return Integer.parseInt(resultText);
	}
}
