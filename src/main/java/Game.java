package main.java;

public class Game {
	LinkedList<Frame> frames;
	
	public Game() {
		frames = new LinkedList<Frame>();
		frames.add(new Frame());
	}

	public int score() {
		int score = 0;
		Node<Frame> node = frames.getHead();
		
		while(node != null) {
			Frame frame = node.getValue();
			if(frame.isSpare()) {
				Frame next = node.getNext().getValue();
				score += frame.getScore() + next.getScore();
			} else if(frame.isStrike()) {
				Frame next = node.getNext().getValue();
				if(next.isStrike()) {
					Frame next_next = node.getNext().getNext().getValue();
					score += frame.getScore() + next.getScore() + next_next.getRolls().get(0).getPins();
				} else {
					score += frame.getScore() + next.getScore();
				}
			} else {
				score += frame.getScore();
			}
			node = node.getNext();
		}
		
		return score;
	}

	public void roll(int score) {
		Frame last = frames.getLast().getValue();
		if(last.getRolls().size() == 2 || last.isStrike()) {
			Frame frame = new Frame();
			frame.roll(score);
			frames.add(frame);
		} else {
			last.roll(score);
		}
	}
}
