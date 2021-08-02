package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");

        Socket client = serverSocket.accept();

        System.out.println("client connected...");

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        Scanner inScanner = new Scanner(in); // input이랑 연결된 스캐너 , system은 키보드로 입력 받은 값.  in은 클라이언트가 보내준 값을 입력 받는다.

        for(int i=0; i < 100;i++) {

            String line = inScanner.nextLine(); // 클라이언트가 쓴 내용을 불러온다. 엔터값까지 받는다.

            System.out.println(line);

            String myMsg = keyScanner.nextLine()+"\n"; // 값을 보낼 때는 \n이 꼭 필요하다
            out.write(myMsg.getBytes()); // 바이트 배열로 바꿔서 클라이언트로 보냄

        }// end for


        inScanner.close();
        in.close();
        client.close();
        serverSocket.close();

    }
}
