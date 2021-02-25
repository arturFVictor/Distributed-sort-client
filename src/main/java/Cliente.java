/*
ARTUR FILARDI VICTORIANO
LUCCA DE OLIVEIRA FILIZZOLA
INF3A
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Cliente {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<List<Integer>> list = FileHandler.read(""); //INSERT INPUT FILE PATH
        list = App.SortList(list);
        FileHandler.write(list, ""); //INSERT OUTPUT FILE PATH
    }
}
