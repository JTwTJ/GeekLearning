
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangwentao
 * @date 2020/12/30
 */
public class HttpServer01 {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(40);
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket accept) {
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 ok");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.println("hello.nio");
            printWriter.close();
            accept.close();
            System.out.println(111);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
