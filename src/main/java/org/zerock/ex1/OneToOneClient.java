package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception {


        Scanner keyScanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 9999);

        System.out.println("Connected....");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);

        for(int i=0; i < 100; i++) {
            //문자열을 byte[] 바꿔서 out.write (바이트배열) // 속도를 빨리하려고 배열 사용
            String msg = keyScanner.nextLine()+"\n"; // \n이 있어야 값을 읽어들일 수 있다.서버용 엔터를 추가해준 것. nextline까지만 있으면 클라이언트에서만 입력된 것.

            out.write(msg.getBytes());
            System.out.println("-------------------------------------");
            System.out.println(inScanner.nextLine());

        }// end for


        out.close();
        socket.close();


    }
}
