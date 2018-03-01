package car;

import utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Car {
	private int timeLeft;
	private Point pos;
	private List<Ride> rides;

	public int lastTime;

	public Car(int timeLeft) {
		pos = new Point(0, 0);
		this.timeLeft = timeLeft;
		lastTime = 0;
		rides = new ArrayList<>();
	}

	public boolean addPassenger(Ride ride) {
		if ((pos.distanceTo(ride.getFrom()) + ride.getFrom().distanceTo(ride.getTo())) <= timeLeft) {
			rides.add(ride);
			timeLeft -= ride.getTimeSpan().getTotalTime();
			pos = ride.getTo();
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

	public Point lastPosition(){
		return rides.get(rides.size()-1).getTo();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(Integer.toString(rides.size()));
		rides.forEach(ride -> joiner.add(Integer.toString(ride.getId())));
		return joiner.toString();
	}
}
