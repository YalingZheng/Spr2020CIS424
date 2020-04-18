import java.util.Random;

public class GoldDiggers extends Thread {
	Random r = new Random();
	Gold gold;
	String threadname = "Thread-";
	public GoldDiggers(String threadname, Gold gold) {
		this.gold = gold;
		this.threadname = threadname;
	}
	
	@Override
	public void run() {
		for (int i=0; i<GameConstants.numTimesDiggingGold;i++) {
			// idle for a random time
			try {
				Thread.sleep(GameConstants.maxWaitTime);
			} catch (InterruptedException e) {
				System.out.println("Sleeping agent being interrupted!");
			}
			// Dig gold
			//System.out.println(threadname + " " + " begins to dig gold");
			gold.DecreaseGold(GameConstants.QtyGoldDiggedEachTime);
			//System.out.println(threadname + " finshes digging gold" );
			//gold.printLeftGold();
		}	
	}
}
