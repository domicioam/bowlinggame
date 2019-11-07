package main.java;

public class FrameFactory {

	public Frame getFrame(int framesSize) {
		if(framesSize < 9) {
			return new Frame();
		} else if(framesSize == 9) {
			return new TenthFrame();
		}
		
		return null;
	}

}
