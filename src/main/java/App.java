/*
ARTUR FILARDI VICTORIANO
LUCCA DE OLIVEIRA FILIZZOLA
INF3A
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class App {

    private static int port = 2222;
    private static List<List<Integer>> list;
    private static boolean aux = true;
    private static Socket socket = null;
    private static ObjectOutputStream objectOutputStream = null;
    private static DataOutputStream dataOutputStream = null;
    private static ObjectInputStream objectInputStream = null;

    public static List<List<Integer>> SortList(List<List<Integer>> list) throws ClassNotFoundException, IOException {
        socket = new Socket("localhost", port);
        App.list = list;

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(list);

            list = (List<List<Integer>>) objectInputStream.readObject();

            socket.close();

            return list;

        } catch (IOException e) {

        }
        return null;
    }
}
