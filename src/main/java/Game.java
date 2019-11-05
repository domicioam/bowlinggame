package main.java;

import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Frame> frames;
	
	public Game() {
		frames = new ArrayList<Frame>();
		frames.add(new Frame());
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < frames.size(); i++) {
			Frame frame = frames.get(i);
			if(frame.isSpare()) {
				Frame next = frames.get(i + 1);
				score += frame.getScore(next);
			} else {
				score += frame.getScore();
			}
		}
		
		return score;
	}

	public void roll(int score) {
		Frame last = frames.get(frames.size() - 1);
		if(last.getRolls().size() == 2) {
			Frame current = new Frame();
			current.roll(score);
			frames.add(current);
		} else {
			last.roll(score);
		}
	}

}
