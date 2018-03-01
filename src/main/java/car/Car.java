package car;

import utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Car {
	private int timeLeft;
	private Point pos;
	public List<Ride> rides;
	public int currentTime;
	public Point currentPosition;

	public int lastTime;

	public Car(int timeLeft) {
		pos = new Point(0, 0);
		this.timeLeft = timeLeft;
		lastTime = 0;
		rides = new ArrayList<>();
	}

	public int optimalRoute(Ride ride){
		int tempo = 0;
		tempo +=currentPosition.distanceTo(ride.getFrom());
		tempo +=((ride.getTimeSpan().getStart())-currentTime);
		return tempo;
    }

	public boolean addPassenger(Ride ride) {
		int wait = Math.max(0, ride.getTimeSpan().getStart() - (currentTime + pos.distanceTo(ride.getFrom())));
		int rideDistance = pos.distanceTo(ride.getFrom()) + ride.getDistance();
		if ((rideDistance + wait) <= timeLeft && (currentTime + rideDistance + wait) <= ride.getTimeSpan().getFinish()) {
			rides.add(ride);
			timeLeft -= rideDistance + wait;
			currentTime += rideDistance + wait;
			pos = ride.getTo();
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
		rides.forEach(ride -> joiner.add(Integer.toString(ride.getId())));
		return joiner.toString();
	}
}
