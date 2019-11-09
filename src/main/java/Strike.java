package main.java;

public class Strike extends Frame {

	@Override
	public int score() {
		int score = 0;
		if(next != null ) {
			if(next instanceof Strike) {
				Frame next_next = next.getNext();
				if(next_next != null) {
					score += getScore() + next.getScore() + next_next.getRolls().get(0).getPins();
				}
			} else {
				score += getScore() + next.getScore();
			}

		}
		
		return score;
	}
	
	@Override
	public boolean canRoll() {
		return !(getRolls().size() == 1);
	}
}
