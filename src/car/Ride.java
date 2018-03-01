package car;
import utils.Point;
import utils.TimeSpan;

public class Ride {
    private Point from, to;
    private TimeSpan timeSpan;

    public Ride(Point from, Point to, TimeSpan ts){
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
}
