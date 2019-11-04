package main.java;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Game {

	private int score;
	
	List<Frame> frames;
	
	public Game() {
		frames = new ArrayList<Frame>();
		frames.add(new Frame());
	}

	public int score() {
		return this.score;
	}

	public void roll(int score) {
		Frame last = frames.get(frames.size() - 1);
		if(last.getRolls().size() == 2) {
			Frame current = new Frame();
			current.roll(score);
		}
	}

}
