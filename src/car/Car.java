package car;

import utils.Point;

public class Car {
	private int timeLeft;
	private Point pos;
	private Ride ride;

	public Car(int x, int y, int timeLeft) {
		pos = new Point(x, y);
		this.timeLeft = timeLeft;
		ride = null;
	}

	public boolean addPassenger(Ride ride) {
		if (ride == null && canYouGetThereOnTime(ride.getFrom(), pos.distanceTo(ride.getFrom()))) {
			this.ride = ride;
			return true;
		} else {
			return false;
		}
	}

	public int timeLeft() {
		return timeLeft;
	}

	public boolean isThereEnoughTime(int time) {
		return (timeLeft >= time);
	}

	public boolean canYouGetThereOnTime(Point pickUpPoint, int time) {
		if (isThereEnoughTime(time) && pos.distanceTo(pickUpPoint) < time) {
			return true;
		} else {
			return false;
		}
	}
}
