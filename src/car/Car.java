package car;

public class Car {
	private int x,y;
	private boolean hasPassanger;

	public Car (int x, int y){
		this.x = x;
		this.y = y;
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
