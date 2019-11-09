package main.java;

public class Default extends Frame {
	@Override
	public int score() {
		if(getScore() == 10) {
			return getScore() + next.getRolls().get(0).getPins();
		}
		
		return getScore();
	}

	@Override
	public boolean canRoll() {
		return !(getRolls().size() == 2);
	}
}
