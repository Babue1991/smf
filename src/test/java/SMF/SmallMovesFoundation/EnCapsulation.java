package SMF.SmallMovesFoundation;

public class EnCapsulation {

	private static double Balance=10;

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {

		if(balance <= 20000) {
			Balance =balance;
		}else {
			System.out.println("The input value is not in range");
		}

	}
}
