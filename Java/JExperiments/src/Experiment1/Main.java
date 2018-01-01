package Experiment1;

/**
 * Created by aronDillQs5328 on 27.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        Box box1 = new Box(10,10,10);
        System.out.println("Box 1\n" + box1.toString());

        Box box2 = new Box(5,5,5);
        System.out.println("Box 2\n" + box2.toString());

        Box box3 = box2;
        System.out.println("Box 3\n" + box3.toString());

        //box2.setX(10);
        //System.out.println("Box 3m\n" + box3.toString());

    }
}
