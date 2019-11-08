package main.java;

public class Game {
	LinkedList<Frame> frames;

	public LinkedList<Frame> getFrames() {
		return frames;
	}

	public Game() {
		frames = new LinkedList<Frame>();
		FrameFactory factory = new FrameFactory();
		frames.add(factory.getFrame(frames.size()));
	}

	public int score() {
		int score = 0;
		Node<Frame> node = frames.getHead();

		while(node != null) {
			Frame frame = node.getValue();
			if(frame.isSpare()) {
				Frame next = node.getNext().getValue();
				score += frame.getScore() + next.getScore();
			} else if(frame.isStrike() && node.getNext() != null ) {
				Node<Frame> next = node.getNext();
				if(next.getValue().isStrike()) {
					Node<Frame> next_next = next.getNext();
					if(next_next != null) {
						score += frame.getScore() + next.getValue().getScore() + next_next.getValue().getRolls().get(0).getPins();
					}
				} else {
					score += frame.getScore() + next.getValue().getScore();
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
		if(last.canRoll()) {
			last.roll(score);
		} else {
			FrameFactory factory = new FrameFactory();
			Frame frame = factory.getFrame(frames.size());
			frame.roll(score);
			frames.add(frame);
		}
	}
}
