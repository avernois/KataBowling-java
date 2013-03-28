package fr.craftinglabs.dojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame game;
	
	@Before
	public void setUp() {
		game = new BowlingGame();
	}
	
	
	@Test
	public void emptyGame() {

		rollMany(20, 0);

		assertEquals(0, game.score());
	}

	@Test
	public void allRollWith1PinDown() {

		rollMany(20, 1);

		assertEquals(20, game.score());
	}

	@Test
	public void rollWithOneSpare() {
		
		game.roll(6);
		game.roll(4);
		game.roll(7);
		rollMany(17, 0);
		

		assertEquals(24, game.score());
	}

	
	@Test
	public void rollsThatLooksLikeASpare() {
		
		game.roll(0);
		game.roll(4);
		game.roll(6);
		game.roll(7);
		
		rollMany(16, 0);
		

		assertEquals(17, game.score());
	}
	
	@Test
	public void firstFrameIsAStrike() {
		
		game.roll(10);
		game.roll(4);
		game.roll(5);
		
		rollMany(17, 0);
		

		assertEquals(28, game.score());
	}
	
	@Test
	public void perfectGame() {
		
		
		rollMany(12, 10);
		

		assertEquals(300, game.score());
	}
	
	
	private void rollMany(int nbOfRoll, int pinDown) {
		for (int i = 0; i < nbOfRoll; i++) {
			game.roll(pinDown);
		}
	}
}
