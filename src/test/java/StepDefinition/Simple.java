package StepDefinition;

import java.util.Random;

public class Simple {

	public static void main(String[] args) {

		String principalName = "Principal";
		 Random random = new Random();
		 int y = random.nextInt(10000);   
		 String principalName1= principalName+y;
		 System.out.println(principalName1);
//		System.out.println("hello world");
	}

}
