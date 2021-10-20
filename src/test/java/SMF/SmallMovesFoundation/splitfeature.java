package SMF.SmallMovesFoundation;

public class splitfeature {

	public static void main(String args[]) {
		String str = "word1, $word2";
		int len = str.length();
		System.out.println("the length of the string is"+len);
		System.out.println("The value is " +str.charAt(12));
		for(int i=len-1 ; i >0 ; i--) {
		//	System.out.println(i);
			char c = str.charAt(i);
			System.out.println("The reversed strin value is"+c);
		}
		
		
		String[] afterSplit = str.split(",$");

		for(String a : afterSplit) {
			System.out.println(a);
		}

	}
}