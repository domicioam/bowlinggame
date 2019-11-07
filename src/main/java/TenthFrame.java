package main.java;

public class TenthFrame extends Frame {
		@Override
		public void roll(int score) throws IllegalArgumentException {
			if(rolls.size() >= 3) {
				throw new IllegalArgumentException("Maximum allowed rolls reached.");
			}
			
			Roll roll = new Roll();
			roll.setPins(score);
			rolls.add(roll);
		}
		
		@Override
		public boolean canRoll() {
			return !(getRolls().size() == 3);
		}
}
