public class Gold {
	private int NumGold;
	
	public Gold(int numGold) {
		NumGold = numGold;
	}
	
	public int getNumGold() {
		return NumGold;
	}
	
	public void DecreaseGold(int num) {
		NumGold -= num;
	}
	
	public void printLeftGold() {
		System.out.println("This run, we have " + NumGold + " gold left.");
	}

}
