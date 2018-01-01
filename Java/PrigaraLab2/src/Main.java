import java.util.ArrayList;
import java.util.Random;

public class Main {

    static int n = 10;
    static  ArrayList<Task> arrayList = new ArrayList<>();
    static Random random = new Random();


    static int RAM = 64;
    static int HD = 1000;
    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            arrayList.add(new Task(random.nextInt(64)));
            System.out.println(arrayList.get(i).size);
        }

        while (true) {
            for (int i = 0; i < 10; i++){
                if (arrayList.get(i).size < RAM) {
                    RAM -= arrayList.get(i).size;
                    arrayList.remove(i);
                } else {

                }
            }

        }




    }


    static class RAM {
        int size = 64;

        int[] segmentRAM;


        private void createRAMsegment(ArrayList<Task> arrayList) {
            segmentRAM = new int[arrayList.size()];

            int j = Integer.MIN_VALUE;
            for (int i = 0; i < arrayList.size(); i++) {

            }
        }
    }


    static class Task {
        int size;
        boolean status;
        int k;

        int[] arraySegment;

        public Task(int size) {
            this.size = size;
        }

        private void createSegment() {
            if (size % 4 == 0) {
                k = size % 4;
            } else {
                k = size % 4 + 1;
            }

            arraySegment = new int[k];

            for (int i = 0; i < k; i++) {
                arraySegment[i] = 4;
            }
        }
    }

}
