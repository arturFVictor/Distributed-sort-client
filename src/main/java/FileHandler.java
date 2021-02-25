/*
ARTUR FILARDI VICTORIANO
LUCCA DE OLIVEIRA FILIZZOLA
INF3A
*/

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public static List<List<Integer>> list;
    public static List<Integer> tempList;

    public static List<List<Integer>> read(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(path));
        tempList = new ArrayList();
        list = new ArrayList();

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (!line.isEmpty()) {
                tempList.add(Integer.parseInt(line));
            } else {
                list.add(tempList);
                tempList = new ArrayList();
            }
        }

        return list;
    }

    public static void write(List<List<Integer>> list, String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        List<Integer> tempList;
        for (int i = 0; i < list.size(); i++) {
            tempList = list.get(i);
            buffWrite.append("\n");
            for (int n = 0; n < tempList.size(); n++) {
                buffWrite.append(tempList.get(n) + "\n");
            }
        }
        buffWrite.close();
    }
}
