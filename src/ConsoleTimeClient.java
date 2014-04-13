/**
 * Created by Optimus on 13.04.2014.
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ConsoleTimeClient {

    public static void main(String args[]) {

        String str = null;

        try {
            // Create a socket
            Socket soc = new Socket(InetAddress.getLocalHost(), 8020);

            // Serialize today's date to a outputstream associated to the socket
            OutputStream outputStream = soc.getOutputStream();
            ObjectOutput output = new ObjectOutputStream(outputStream);
            output.writeObject("time");
            //output.writeObject(new Date());

            InputStream inputStream = soc.getInputStream();
            ObjectInput input = new ObjectInputStream(inputStream);
            str = (String) input.readObject();
            System.out.println(str);

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}
