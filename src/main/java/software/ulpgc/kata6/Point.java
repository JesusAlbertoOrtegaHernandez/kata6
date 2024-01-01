package software.ulpgc.kata6;

public record Point(int x, int y) {
    public static Point at(int x, int y){
        return new Point(x, y);
    }

    public Point add(Point offset){
        return new Point(this.x + offset.x, this.y + offset.y);
    }
}
