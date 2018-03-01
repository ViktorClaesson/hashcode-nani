package utils;

public class TimeSpan {
    private int start, finish;

    public TimeSpan(int start, int finish){
        this.start = start;
        this.finish = finish;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

    public int getTotalTime(){
        return finish - start;
    }

    public boolean withinSpan(int time){
        return (start <= time && time <= finish);
    }
}
