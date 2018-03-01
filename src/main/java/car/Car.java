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
	public int currentTime;
	public Point currentPosition;

	public int lastTime;

	public Car(int id, int timeLeft) {
		this.id = id;
		pos = new Point(0, 0);
		this.timeLeft = timeLeft;
		rides = new ArrayList<>();
		int currentTime = 0;
	}

	public boolean addPassenger(Ride ride, int lastTime) {
		if (canYouGetThereOnTime(ride.getFrom(), pos.distanceTo(ride.getFrom()))) {
			rides.add(ride);
			acceptedRides.add(ride.getId());
			timeLeft -= ride.getTimeSpan().getTotalTime();
			this.lastTime = lastTime;
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
		if (rides.isEmpty()){
			return new Point(0,0);
		}
		return rides.get(rides.size()-1).getTo();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(Integer.toString(rides.size()));
		acceptedRides.forEach(id -> joiner.add(Integer.toString(id)));
		return joiner.toString();
	}
}
