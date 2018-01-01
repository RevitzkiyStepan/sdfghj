import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "D://Download/OSfile.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("показати файл? [true] / Обновити данні в файлі? [false]");
            boolean showOrUpdateFile = scanner.nextBoolean();

            if (showOrUpdateFile) {
                showFileInConsol();
            } else {
                System.out.println("Введіть ім’я та день народження(день і місяць)");
                String str  = new Scanner(System.in).nextLine();
//                String str = scanner.nextLine();
                UpdateFile(str);
            }
        }
    }

    private static void UpdateFile(String str) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String oldFile = readFromFile();
        stringBuilder.append(oldFile);
        stringBuilder.append(str);
        writeFile(stringBuilder.toString());
    }

    private static void writeFile(String s) {
        File file = new File(FILE_NAME);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.println(s);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFromFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            File file = new File(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }
            } finally {
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private static void showFileInConsol() throws IOException {
        try {
            File file = new File(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    System.out.println(s);
                }
            } finally {
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
