import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int SEGMENT_SIZE = 4;
    static int countTask = 10;
    static Map<Integer, Task> dictionaryTask;
    static Random rndTaskSize = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int n = 0;
    static int freeRAM = 64;

    public static void main(String[] args) {
        init();
    }

    static void init() {
        initTask();


    }

    static void loadTask() {
        for (int i = 0; i < countTask; i++) {
             if (dictionaryTask.get(i).size <= freeRAM && !dictionaryTask.get(i).isFinish) {
                 System.out.println("загрузка Task " + i + " в оперативну память");
                 System.out.println("обробка задачі...");
                 dictionaryTask.get(i).isFinish = true;
                 freeRAM -= dictionaryTask.get(i).size;
             } else {

             }
        }
    }

    static void initTask() {
        dictionaryTask = new HashMap<>();
        for (int i = 0; i < countTask; i++) {
            Task tsk = new Task(rndTaskSize.nextInt(64) + 1);
            System.out.println("Init Task " + i + ", Task size = " + tsk.size);
            tsk.createTaskSegment();
            dictionaryTask.put(i, tsk);
        }
    }

    static class Task {
        int size;
        int countSegment;
        boolean isFinish;

        public Task(int size) {
            this.size = size;
            countSegment = size % SEGMENT_SIZE == 0 ? size / SEGMENT_SIZE : size / SEGMENT_SIZE + 1;
            isFinish = false;
        }

        Map<Integer, Segment> dictionaryTaskSegment = new HashMap<>();

        void createTaskSegment() {
            for (int i = 0; i < countSegment; i++) {
                dictionaryTaskSegment.put(i, new Segment(false));
                System.out.println("\tInit task Segment " + i);
            }
        }
    }

    static class Segment {
        boolean usedRam;

        public Segment(boolean usedRam) {
            this.usedRam = usedRam;
        }
    }

}
