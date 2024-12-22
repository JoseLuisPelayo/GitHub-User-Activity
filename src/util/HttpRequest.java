package util;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class HttpRequest {

    public static String[] get(String stringUrl) {
        try {
            URL url = new URI(stringUrl).toURL();
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            String[] response = new String[2];

            if (responseCode != 200) {
                response[1] = "Error: " + responseCode;
            } else {
                StringBuilder infoString = new StringBuilder();
                Scanner in = new Scanner(url.openStream());

                while (in.hasNextLine()) {
                    infoString.append(in.nextLine());
                }

                in.close();

                response[0] = infoString.toString();
                response[1] = "" + responseCode;
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
