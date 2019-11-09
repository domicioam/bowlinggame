package main.java;

public class TenthFrame extends Frame {
	@Override
	public int score() {
		return getScore();
	}

	@Override
	public boolean canRoll() {
		return !(getRolls().size() == 3);
	}
	
	@Override
	public void roll(int score) throws IllegalArgumentException {
		Roll roll = new Roll();
		roll.setPins(score);
		rolls.add(roll);
	}
}
