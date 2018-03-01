package car;

import utils.Point;

import java.util.List;
import java.util.StringJoiner;

public class Car {
	private int id;
	private int timeLeft;
	private Point pos;
	private Ride ride;
	private List<Integer> acceptedRides;

	public Car(int id, int timeLeft) {
		this.id = id;
		pos = new Point(0, 0);
		this.timeLeft = timeLeft;
		ride = null;
	}

	public boolean addPassenger(Ride ride) {
		if (ride == null && canYouGetThereOnTime(ride.getFrom(), pos.distanceTo(ride.getFrom()))) {
			this.ride = ride;
			acceptedRides.add(ride.getId());
			return true;
		} else {
			return false;
		}
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

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(Integer.toString(id));
		acceptedRides.forEach(id -> joiner.add(Integer.toString(id)));
		return joiner.toString();
	}
}
