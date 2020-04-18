public class TestingConcurrencyDiggingGold {
	
	public static void TestDiggingGold() {
		int numThreads = 50;
		int initialNumGold = 500;
		// Note that in the GameConstants.java, 
		// A gold digger digs one gold a time (QtyGoldDiggedEachTime=1)
		// A gold digger digs ten times (numTimesDiggingGold = 10)
		// define gold whose initial quantity is 500
		Gold gold = new Gold(initialNumGold);
		// Define ten gold diggers
		GoldDiggers[] golddiggers = new GoldDiggers[numThreads]; 
		// Initialize each gold digger with a name, and the gold object it will dig
		for (int i=0; i<numThreads;i++ ) {
			golddiggers[i] = new GoldDiggers("Thread-" + (i+1),  gold);
		}
		// Start all ten gold diggers
		for (int i=0; i<numThreads;i++) {
			golddiggers[i].start();
		}
		// wait for all the gold diggers finish
		for (int i=0; i<numThreads;i++) {
			try {
				golddiggers[i].join();
			}
		   catch (InterruptedException e) {
			System.out.println("Interrupted Error while join: " + e.getMessage());
		   }
		}
		System.out.println("If run correctly, ZERO gold should be left. ");
		gold.printLeftGold();
		System.out.println();
	}
	
	public static void main(String[] args) {
		// Run ten times to 
		for (int i=0; i<10;i++) {
			System.out.println("***** Run " + (i+1) +" ********");
			TestDiggingGold();
			System.out.println("*******************************");
		}
	}

}
