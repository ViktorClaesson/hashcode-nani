package car;

import utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Car {
	private int id;
	private int timeLeft;
	private Point pos;
	private ArrayList<Ride> rides;
	private List<Integer> acceptedRides;

	public int lastTime;

	public Car(int id, int timeLeft) {
		this.id = id;
		pos = new Point(0, 0);
		this.timeLeft = timeLeft;
		rides = new ArrayList<>();
		lastTime = 0;
	}

	public boolean addPassenger(Ride ride) {
		if (canYouGetThereOnTime(ride.getFrom(), pos.distanceTo(ride.getFrom()))) {
			rides.add(ride);
			acceptedRides.add(ride.getId());
			timeLeft -= ride.getTimeSpan().getTotalTime();
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
		joiner.add(Integer.toString(id));
		acceptedRides.forEach(id -> joiner.add(Integer.toString(id)));
		return joiner.toString();
	}
}
