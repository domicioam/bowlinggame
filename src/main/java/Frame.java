package main.java;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	
	List<Roll> rolls;
	
	public Frame() {
		rolls = new ArrayList<Roll>();
	}

	public List<Roll> getRolls() {
		return rolls;
	}

	public void roll(int score) throws IllegalArgumentException {
		if(rolls.size() >= 1 && rolls.get(0).getPins() == 10) {
			throw new IllegalArgumentException("A frame which contains a strike can only have one roll.");
		}
		
		Roll roll = new Roll();
		roll.setPins(score);
		rolls.add(roll);
	}

	public int getScore() {
		int score = 0;
		
		for (Roll roll : rolls) {
			score += roll.getPins();
		}
		
		return score;
	}
}
