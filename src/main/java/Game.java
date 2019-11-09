package main.java;

public class Game {
	LinkedList frames;
	
	public LinkedList getFrames() {
		return frames;
	}

	public Game() {
		frames = new LinkedList();
	}

	public int score() {
		int score = 0;
		Frame frame = frames.getHead();
		
		while(frame != null) {
			score += frame.score();
			frame = frame.getNext();
		}
		
		return score;
	}

	public void roll(int score) {
		if(frames.size() == 0) {
			FrameFactory factory = new FrameFactory();
			frames.add(factory.getFrame(frames.size(), score));
		}
		
		Frame last = frames.getLast();
		if(last.canRoll()) {
			last.roll(score);
		} else {
			FrameFactory factory = new FrameFactory();
			Frame frame = factory.getFrame(frames.size(), score);
			frame.roll(score);
			frames.add(frame);
		}
	}
}
