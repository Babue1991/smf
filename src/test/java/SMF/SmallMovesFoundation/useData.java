package SMF.SmallMovesFoundation;

public class useData {

	public static void main(String[] args) {


		EnCapsulation obj = new EnCapsulation();

		
		double balance = obj.getBalance();
		System.out.println("Before balance "+balance);

		obj.setBalance(10000);
		double bla1 =obj.getBalance();

		System.out.println("After balance "+bla1);
	

	}

}
