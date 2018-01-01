import java.util.ArrayList;

public class Main {

    static char[] upSTR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] downSTR = {'3', '5', '8', '7', '2', '0', '9', '1', '4', '6'};


    //03715 284 69
    //37150 842 96

    static String resultUP = "";
    static String resultDOWN = "";

    static String transposition = "";

    static int n = 0;

    static ArrayList<String> upArrayList = new ArrayList<>();
    static ArrayList<String> downArrayList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < upSTR.length; i++) {
            upArrayList.add(String.valueOf(upSTR[i]));
            downArrayList.add(String.valueOf(downSTR[i]));
        }

        while (resultUP.length() - n != upSTR.length) {
            resultUP += findUpLoop();
            resultUP += " ";
            n++;
        }

        String[] arr = resultUP.split(" ");

        for (int i = 0; i < arr.length; i++) {
            resultDOWN += findDOWNLoop(arr[i]);
            resultDOWN += " ";
        }




        //TODO: тут виводиться добуток незалежних циклів
        System.out.println(resultUP);
        System.out.println(resultDOWN);


        for (int i = 0; i < arr.length; i++) {
            transposition += findTrans(arr[i]);
            transposition += " ";
        }


        //TODO: тут виводяться транспозиції
        System.out.println(transposition);


        //TODO: перший спосіб про кількість транспозицій
        if (transposition.split( " ").length % 2 == 0) {
            System.out.println("парне");
        } else {
            System.out.println("непарне");
        }


        //TODO: другий спосіб через інверсію

        if (findParne() % 2 == 0) {
            System.out.println("парне");
        } else {
            System.out.println("непарне");
        }



        //TODO: тут виводяться степені перестановки
        for (int i = 0; i < arr.length; i++) {
           GetAllStep(arr[i]);
        }





    }


    static void GetAllStep(String s) { //return res[][] where all step, take value[] where our data, n - len of value[], and give len - length of res[][] (c# = ref, java - none:( )

        int[] value = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            value[i] = Integer.valueOf(s.charAt(i))-48;
        }

        int m = 1000;
        int n = value.length;
        int[][] res = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n+1; j++) {
                res[i][j] = -1;
            }
        }
        m = 0;
        //all before - create mas[][]

        for (int i = 2; i < n; i++) { //step 2..n-1 (1 no reson, n after it)
            int val = 0;
            boolean[] check = new boolean[n];
            for (int j = 0; j < n; j++) check[i] = false; //as a simple - {1 2 3 4} and step 2 -> {1 3} {2 4} so must check other ways in cycle
            int k = 0; //cycle must calc all numbers
            int ind = 0; //for adding in res[][]
            do {
                for (int j = 0; j < n; j++) {
                    if (!check[j]) {
                        val = j;
                        break;
                    }
                }
                m++; //add len mas[][]
                boolean fatr = false; //for check if already cycle (return to first)
                for (int j = val;; j += i, ind++) {
                    if (j >= n) j %= n; //we go for cycle while not return to first
                    if (j == val) { //check for firts and second first
                        if (!fatr) {
                            fatr = true;
                        } else {
                            break;
                        }
                    }
                    k++;
                    check[j] = true;
                    res[m-1][ind] = value[j]; //build mass in step cycle
                }
                res[m-1][n] = i;
            } while (k != n);

        }
        for (int i = 0; i < n; i++) { // step n (all have 1 value)
            m++;
            res[m-1][0] = value[i];
            res[m-1][n] = n;
        }

        for (int i = 0; i < m; i++) {
            if (res[i][n] == 1) break;
            for (int j = 0; j < n; j++) {
                if (res[i][j] == -1) continue;

                System.out.print(res[i][j] + " ");
            }

            System.out.println(" <> "  + res[i][n]);
        }
        System.out.println();

    }

    private static int findParne() {
        int resUP = 0;
        int resDOWN = 0;

        for (int i = 0; i < upSTR.length; i++) {
            for (int j = i; j < upSTR.length; j++) {
                if (Integer.valueOf(upSTR[i]) > Integer.valueOf(upSTR[j])) {
                    resUP++;
                }

                if (Integer.valueOf(downSTR[i]) > Integer.valueOf(downSTR[j])) {
                    resDOWN++;
                }
            }
        }
        return resUP + resDOWN;
    }

    private static String findTrans(String s) {
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            res += s.charAt(0) + "_" + s.charAt(i) + " ";

        }
        return res;
    }

    private static String findDOWNLoop(String s) {
        String res = s.substring(1, s.length()) + s.substring(0, 1);
        return res;
    }

    private static String findUpLoop() {
        String str = upArrayList.get(0) + downArrayList.get(0);

        while (str.charAt(0) != str.charAt(str.length() - 1)) {
            str += downArrayList.get(upArrayList.indexOf(String.valueOf(str.charAt(str.length() - 1))));
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = 0; j < upArrayList.size() - 1; j++) {
                if (String.valueOf(str.charAt(i)).equals(upArrayList.get(j))) {
                    upArrayList.remove(j);
                    downArrayList.remove(j);
                }
            }
        }
        return str.substring(0, str.length() - 1);
    }
}
