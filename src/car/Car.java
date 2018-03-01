package car;

import utils.Point;

public class Car {
	private int id;
	private int timeLeft;
	private Point pos;
	private Ride ride;

	public Car(int id, int timeLeft) {
		this.id = id;
		pos = new Point(0, 0);
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
