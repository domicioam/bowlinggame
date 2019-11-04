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
	}
	
	@Test
	void should_not_permit_two_rolls_when_strike() {
		Frame frame = new Frame();
		frame.roll(10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  frame.roll(0);
		});
	}
}
