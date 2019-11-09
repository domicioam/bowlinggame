package main.java;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	public Frame() {
		rolls = new ArrayList<Roll>();
	}

	public abstract boolean canRoll();
	
	protected Frame next = null;
	protected List<Roll> rolls;
	
	public Frame getNext() {
		return next;
	}

	public void setNext(Frame next) {
		this.next = next;
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
	
	public abstract int score();
	
	protected int getScore() {
		int score = 0;

		for (Roll roll : rolls) {
			score += roll.getPins();
		}

		return score;
	}
}