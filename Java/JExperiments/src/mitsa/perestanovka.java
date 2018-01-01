package mitsa;

import java.util.Arrays;

/**
 * Created by aronDillQs5328 on 10.06.2017.
 */
public class perestanovka {

    public static String toString(int[] num) {
        String str = "";
        for(int i=0;i<num.length;i++) {
            str+=num[i] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 2};

        System.out.println(toString(num));
        for(int u = 0; u < num.length*num.length;u++) {

            for(int i = num.length-1;i>=0;i--) {
                if(num[i-1] < num[i]) {
                    for(int j = i; j<num.length;j++) {
                        if(num[j] > num[i])
                    }
                }
            }


        }


    }
}
