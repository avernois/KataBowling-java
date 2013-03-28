package fr.craftinglabs.dojo;

public class BowlingGame {

	
	int roll[] = new int[22];
	int currentRoll = 0; 
	
	public void roll(int pinDown) {
		roll[currentRoll] = pinDown;
		currentRoll += 1;
	}

	public int score() {
		int score = 0;
		int rollIndex = 0;

		for (int frame = 0; frame < 10; frame++) {
	
			if (isStrike(rollIndex)) {
				score += 10 + strikeBonus(rollIndex);
				rollIndex += 1;
			} else if (isSpare(rollIndex)) {
				score += 10 + spareBonus(rollIndex);
				rollIndex += 2;
			} else {
				score += frameScore(rollIndex);				
				rollIndex += 2;
			}
			
		}
		
		return score;
	}

	private boolean isStrike(int rollIndex) {
		return roll[rollIndex] == 10;
	}
	
	private int strikeBonus(int rollIndex) {
		return roll[rollIndex+1] + roll[rollIndex+2];
	}

	private int frameScore(int rollIndex) {
		return roll[rollIndex] + roll[rollIndex +1];
	}

	private int spareBonus(int index) {
		return roll[index+2];
	}
	

	private boolean isSpare(int index) {
		return roll[index] + roll[index+1] == 10;
	}
}
