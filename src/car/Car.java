package car;

import utils.Point;

public class Car {
	private int timeLeft;
	private Point pos;
	private boolean hasPassenger;

	public Car (int x, int y, int timeLeft){
		pos = new Point(x,y);
		this.timeLeft = timeLeft;
	}

	public boolean addPassenger(){
		if (!hasPassenger){
			return hasPassenger = true;
		}
		return false;
	}

	public boolean dropPassenger(){
		if (hasPassenger){
			hasPassenger = false;
			return true;
		}
		return false;
	}

	public boolean hasPassenger(){
		return hasPassenger();
	}

	public int timeLeft(){
		return timeLeft;
	}

	public boolean isThereEnoughTime(int time){
		return (timeLeft >= time);
	}

	public boolean canYouGetThereOnTime(Point pickUpPoint, int time){
		if (isThereEnoughTime(time) && pos.distanceTo(pickUpPoint) < time){
			return true;
		} else {
			return false;
		}
	}
}
