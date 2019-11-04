package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Game;

class BowlingGameTest {
	private Game game;
	
	@Test
	void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}
	
	@Test
	void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}
	
	@Test
	void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}

	@BeforeEach
	private void setUp() {
		game = new Game();
	}
	
	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	private void rollMany(int n, int pins) {
		for(int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}
}
