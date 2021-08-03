package org.zerock.ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {   // 주인

    //bad code close 철저히
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999); // serversocket은 손님을 기다린다(지배인), 문 번호 9999

        System.out.println("Ready...");


        while (true){

            Socket client = serverSocket.accept(); //클라이언트와 연결된 종이컵 전화기 , 소켓 연결
            System.out.println(client);

            OutputStream out = client.getOutputStream(); // 클라이언트에게 파일을 보내줄것.

            File file = new File("C:\\Users\\82102\\aaa.jpg");

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
//            out.write(new String("Content-Length: " + file.length() + "\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg; charset=UTF-8\r\n\r\n").getBytes());


            //out.write(97);
            InputStream fin = new FileInputStream("C:\\Users\\82102\\aaa.jpg"); // 웹브라우저에 이미지 파일을 띄운다.

            byte[] buffer = new byte[1024*8]; // 바가지, 8kbyte. 괄호안에 버퍼 값을 지정.

            while (true){
                int count = fin.read(buffer); //count - 몇개나 새로운 데이터를 읽어들였는가 , 바가지로 데이터 읽기. 괄호안에 지정한 값 단위를 읽어온다.
                if (count == -1) {break;}
                out.write(buffer,0,count);  // 버퍼값, 버퍼의 읽어온 값을 처음부터 갯수만큼만 전송,

            }//end while

            //Thread.sleep(500);

            //fin.close();    // close 작업을 일찍해도 좋지않음.
            //out.close();
            //client.close();

        }//end while

    }
}
