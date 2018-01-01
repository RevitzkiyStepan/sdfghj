import java.util.Arrays;

public class Main {

    public static char[] arr = {'1','2', '3', '4', '5'};

    public static void main(String[] args) {

        String str = "1 2 3 4 ";
        System.out.println(str.split(" ").length);

        int r = 4; // кількість елементів у сполученні
        int[] arr = {1,2,3,4}; // початковий масив для сполучення розміру r
        int n = 6; // Загальна кількість елементів множини
        int combinationCount = factorial(n) / (factorial(r) * factorial((n - r)));
        for (int i = 1; i <= combinationCount; i++)
        {
            for(int j = 0; j < arr.length; j++)
                System.out.print(arr[j] + " ");

            arr = GetNextCombination(arr,n,r);
            System.out.println();
        }

    }

    public static int[] GetNextCombination(int[] arr, int n, int r)
    {
        int pos = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (arr[i] != n - r + i + 1)
            {
                pos = i;
                break;
            }
        }
        arr[pos]++;
        for (int i = pos + 1; i < arr.length; i++)
            arr[i] = arr[i - 1] + 1;

        return arr;
    }

    public static int factorial(int n)
    {
        int ans = 1;
        for(int i = 1; i <= n; i++)
            ans*=i;
        return  ans;
    }
}
