package JRabin;

/**
 * Created by aronDillQs5328 on 29.05.2017.
 */
public class Rabin {
    public static void main(String[] args) {
        String s = morisSearch("ty","qwerty");
        //System.out.println("qwerty".hashCode());
        //System.out.println("qwe".hashCode());

        System.out.println(s);
    }

//    private static String rabinSearch(String str, String subStr) {
//        int strHCode = str.substring(0, subStr.length()).hashCode();
//        int subStrHCode = subStr.hashCode();
//        for (int i = 0; i + subStr.length() < str.length(); i++) {
//            if (strHCode == subStrHCode) {
//                if (str.substring(i, i + subStr.length()).equals(subStr)) {
//                    return "Знайдено";
//                }
//            } else {
//                strHCode = str.substring(i + 1, i + 1 + subStr.length()).hashCode();
//                System.out.println(strHCode);
//            }
//        }
//        if(strHCode == subStrHCode) {
//            if(str.substring(str.length() - subStr.length(), str.length()).equals(subStr)) {
//                return "Знайдено";
//            }
//        }
//        return "Не знайдено";
//    }


    private static int[] prefix(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            int k = res[i - 1];
            while (k > 0 && s.charAt(k) != s.charAt(i - 1)) {
                k = res[k - 1];
            }
            if (s.charAt(k) == s.charAt(i - 1)) {
                k++;
            }
            res[i] = k;
        }
        return res;
    }

    //TODO: ще це не забути!!!
    //Алгоритм Кнута-Морріса-Пратта
    private static String morisSearch(String subStr, String str) {
        int index = -1;
        int[] f = prefix(subStr);
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            while (k > 0 && subStr.charAt(k) != str.charAt(i)) {
                k = f[k - 1];
            }
            if (subStr.charAt(k) == str.charAt(i)) {
                k = k + 1;
            }
            if (k == subStr.length()) {
                index = i - subStr.length() + 1;
                break;
            }
        }
        if (index > -1) {
            return "Знайдено";
        }
        return "Не знайдено";
    }
}
