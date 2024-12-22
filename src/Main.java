import util.HttpRequest;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String user = "JoseLuisPelayo";
        String url = "https://api.github.com/users/" + user + "/events";

        String[] response = HttpRequest.get(url);

        if (response[1].equals("200"))
            System.out.println(response[0]);


    }
}
