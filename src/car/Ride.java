package car;
import utils.Point;
import utils.TimeSpan;

public class Ride {
    private Point from, to;
    private TimeSpan timeSpan;
    private int id;

    public Ride(Point from, Point to, TimeSpan ts, int id){
        this.from = from;
        this.to = to;
        timeSpan = ts;
        this.id = id;
    }

    public Point getFrom(){
        return from;
    }

    public Point getto(){
        return to;
    }

    public TimeSpan getTimeSpan(){
        return timeSpan;
    }

    public int getId() {
        return id;
    }
}
