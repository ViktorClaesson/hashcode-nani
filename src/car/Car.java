package car;

import point.Point;

public class Car {
	private Point pos;
	private boolean hasPassanger;

	public Car (int x, int y){
		pos = new Point(x,y);
	}

	public boolean addPassanger(){
		if (!hasPassanger){
			return hasPassanger = true;
		}
		return false;
	}

	public boolean hasPassanger(){
		return hasPassanger();
	}
}
