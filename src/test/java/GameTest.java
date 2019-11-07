package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Game;

class GameTest {
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
	
	@Test
	void testOneStrike() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}
	
	@Test
	void testLastFrame() {
		rollMany(18, 0);
		assertEquals(9, game.getFrames().size());
		rollMany(3, 10);
		assertEquals(30, game.score());
	}
	
	@Test
	void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}
	
	@Test
	void testMaxFrames() {
		rollMany(20, 0);
		assertEquals(10, game.getFrames().size());
	}

	private void rollStrike() {
		game.roll(10);
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
