package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Frame;
import main.java.TenthFrame;

class TenthFrameTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void should_let_roll_when_one_roll() {
		Frame frame = new Frame();
		frame.roll(0);
		
		assertTrue(frame.canRoll());
	}
	
	@Test
	void should_let_roll_when_two_rolls() {
		TenthFrame frame = new TenthFrame();
		frame.roll(0);
		frame.roll(0);
		
		assertTrue(frame.canRoll());
	}

}
