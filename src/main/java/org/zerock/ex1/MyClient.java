package org.zerock.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {
    // bad code
    public static void main(String[] args) throws Exception {

        //192.168.0.34
        Socket socket = new Socket("192.168.0.13", 9999);

        System.out.println(socket);

        InputStream in = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\Users\\82102\\get.jpg");

        byte[] buffer = new byte[1024*8]; // 바가지

        while (true){
            int count = in.read(buffer);
            if (count == -1) {break;}
            fos.write(buffer,0,count);

        }//end while


//        int data = in.read();
//        System.out.println(data);

        fos.close();

        socket.close();

    }
}



