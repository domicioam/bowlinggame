package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Frame;
import main.java.FrameFactory;

class FrameFactoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testNonTenthFrame() {
		FrameFactory factory = new FrameFactory();
		Frame frame = factory.getFrame(9);
		frame.roll(5);
		frame.roll(5);
		assertEquals(10, frame.getScore());
	}
	
	@Test
	void should_not_permit_two_rolls_when_strike() {
		FrameFactory factory = new FrameFactory();
		Frame frame = factory.getFrame(9);
		frame.roll(10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  frame.roll(0);
		});
	}

	@Test
	void testTenthFrame() {
		FrameFactory factory = new FrameFactory();
		Frame frame = factory.getFrame(10);
		frame.roll(10);
		frame.roll(10);
		frame.roll(10);
		assertEquals(30, frame.getScore());
	}

}
