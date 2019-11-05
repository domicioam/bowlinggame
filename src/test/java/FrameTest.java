package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.Frame;

class FrameTest {

	@Test
	void should_have_two_rolls_when_score_equals_to_zero() {
		Frame frame = new Frame();
		frame.roll(0);
		frame.roll(0);
		assertEquals(2, frame.getRolls().size());
	}
	
	@Test
	void should_permit_strike() {
		Frame frame = new Frame();
		frame.roll(10);
		
		assertEquals(1, frame.getRolls().size());
		assertEquals(10, frame.getScore());
		assertTrue(frame.isStrike());
	}
	
	@Test
	void should_not_permit_two_rolls_when_strike() {
		Frame frame = new Frame();
		frame.roll(10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  frame.roll(0);
		});
	}
	
	@Test
	void testSpare() {
		Frame frame = new Frame();
		rollSpare(frame);
		
		assertTrue(frame.isSpare());
	}
	
	@Test
	void test_is_not_spare() {
		Frame frame = new Frame();
		frame.roll(4);
		frame.roll(5);
		
		assertFalse(frame.isSpare());
	}
	
	@Test
	void test_strike_is_not_spare() {
		Frame frame = new Frame();
		frame.roll(10);
		
		assertFalse(frame.isSpare());
	}
	
	@Test
	void testSpareScore() {
		Frame frame = new Frame();
		rollSpare(frame);
		Frame next = new Frame();
		next.roll(3);
		
		assertEquals(13, frame.getScore(next));
	}

	private void rollSpare(Frame frame) {
		frame.roll(5);
		frame.roll(5);
	}
}
