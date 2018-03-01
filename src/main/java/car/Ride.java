package car;
import utils.Point;
import utils.TimeSpan;

public class Ride {
    private Point from, to;
    private TimeSpan timeSpan;
    private int id;

    public Ride(int id, Point from, Point to, TimeSpan ts){
        this.id = id;
        this.from = from;
        this.to = to;
        timeSpan = ts;
    }

    public Point getFrom(){
        return from;
    }

    public Point getTo(){
        return to;
    }

    public TimeSpan getTimeSpan(){
        return timeSpan;
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return from.distanceTo(to);
    }
}
