import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Main {

    public static char[] arr = {'1', '2', '3', '4'}; //TODO: 49 107 101 50 52

    public static void main(String[] args) {
        while(isNext(arr)) {
            getNextGen(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    static int pos = 0;
    private static void getNextGen(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                pos = i;
                break;
            }
        }

        char minE = Character.MAX_VALUE;
        int pos2 = 0;
        for(int i = pos - 1; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[i] && arr[j] < minE) {
                    minE = arr[j];
                    pos2 = j;
                }
            }
        }
        char k = arr[pos-1];
        arr[pos-1] = arr[pos2];
        arr[pos2] = k;

        Arrays.sort(arr, pos, arr.length);
    }

    private static boolean isNext(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                return true;
            }
        }
        return false;
    }
}
