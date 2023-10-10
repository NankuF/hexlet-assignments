package exercise;

// BEGIN
public class Segment {
    private Point begin;
    private Point end;

    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Point getBeginPoint() {
        return this.begin;
    }

    public Point getEndPoint() {
        return this.end;
    }

    public Point getMidPoint() {
        var x = (this.end.getX() + this.begin.getX())/2;
        var y = (this.end.getY() + this.begin.getY())/2;
        return new Point(x, y);
    }
}
// END
