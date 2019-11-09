package main.java;

public class FrameFactory {

	public Frame getFrame(int framesSize, int score) {
		if(framesSize < 9 && score < 10) {
			return new Default();
		}
		else if(framesSize < 9 && score == 10) {
			return new Strike();
		}
		else if(framesSize == 9) {
			return new TenthFrame();
		}

		return null;
	}

}
