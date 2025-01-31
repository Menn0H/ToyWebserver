import java.net.*;
import java.io.*;

public class Main {

/* 
 * TODO:
 *      -write to logging file
 *      -add tls (quick?)
 *      -Command line args (e.g. path to html file)
 *
 *
*/
public static void main(String[] args) {
        String welcomingMessage = "You've succesfully connected to the server!\n";
        String httpAccept = "HTTP/1.1 200 OK\r\n" +
                            "Access-Control-Allow-Origin: *\r\n" +
                            "Connection: Keep-Alive\r\n" +
                            "Content-Type: text/html; charset=utf-8\r\n"+
                            "\r\n";
        String content = "<h1>Kirsten en Chica zijn lief <3</h1>";

        try {
            System.out.println("[info]: Creating socket...");
            ServerSocket ssoc = new ServerSocket(8000);
            System.out.println("[info]: Socket created, localhost:8000");

            while (true) {
                System.out.println("[info]: Listening for connection...");
                Socket soc = ssoc.accept();
                System.out.println("[info]: Host connected from: " + soc.getInetAddress());

                OutputStream os = soc.getOutputStream();
                os.write(httpAccept.getBytes("UTF-8"));
                os.write(content.getBytes("UTF-8"));
                os.flush();

                soc.close();
            }     
            //System.out.println("[info]: Closing connection...");
            //soc.close();
            //ssoc.close();
            
        } catch (Exception e) {
            System.out.println("[error]: " + e);
        }
    }

}
