package Experiment1;

/**
 * Created by aronDillQs5328 on 27.05.2017.
 */
public class Box {
    private int X;
    private int Y;
    private int W;

    public Box(int x, int y, int w) {
        X = x;
        Y = y;
        W = w;
    }

    public Box() {

    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    @Override
    public String toString() {
        return "Box{" +
                "X=" + X +
                ", Y=" + Y +
                ", W=" + W +
                '}';
    }

}
