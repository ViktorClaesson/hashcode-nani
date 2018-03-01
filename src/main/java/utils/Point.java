package utils;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return ((x + y) * (x + y + 1) )/ 2 + y;
    }

    public List<Point> getNeighbours() {
        List<Point> neighbours = new ArrayList<>(8);
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(x == i && y == j)) {
                    neighbours.add(new Point(i, j));
                }
            }
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    public boolean insideBoard(int size) {
        return (x >= 0 && x < size) && (y >= 0 && y < size);
    }

    @Override
    public String toString() {
        return "X,Y (" + x + "," + y + ")";
    }

    public int distanceTo(Point point){
        int dX;
        int dY;

        if ((point.x - this.x) < 0){
            dX = -(point.x - this.x);
        } else {
            dX = (point.x - this.x);
        }

        if ((point.y - this.y) < 0){
            dY = -(point.y - this.y);
        } else {
            dY = (point.y - this.y);
        }

        return (dX + dY);
    }
}
