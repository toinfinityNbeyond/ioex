package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EchoServer {

    //bad code
    public static void main(String[] args)throws Exception {

        Map<String, String[]> map = new HashMap<>();

        map.put("kor", new String[]{"불고기","비빔밥"});
        map.put("jap", new String[]{"초밥","라멘"});
        map.put("wes", new String[]{"피자","파스타"});


        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready..");
        //루프 시작
        while(true){
            //연결 accept() Socket
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());

            //클라이언트가 보낸 메시지 읽기
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String msg = inScanner.nextLine();
            System.out.println(msg); //kor,jap

            String[] arr = map.get(msg);

            //읽은 메시지를 다시 전송
            String sendMsg = null;

            if(arr == null){
                sendMsg ="다른 키워드를 입력하세요\n";
            }else {
                int idx = (int)(Math.random() * arr.length);
                sendMsg = arr[idx]+"\n";
            }


            OutputStream out = socket.getOutputStream();

            out.write(sendMsg.getBytes());
            out.flush();

            out.close();
            inScanner.close();
            in.close();
            socket.close();
            //소켓 연결 종료
        }//end while
    }
}


























//package org.zerock.ex1;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Map;
//
//public class EchoServer {     // 서버가 한개고 클라이언트가 여럿인 경우.
//
//    //bad code
//    public static void main(String[] args) throws Exception {
//
//        Map<String, String[]> map = new HashMap<>();
//
//        map.put("kor", new String[]{"불고기","비빔밥"});
//        map.put("jap", new String[]{"초밥","라멘"});
//        map.put("wes", new String[]{"피자","파스타"});
//
//        //서버 소켓 준비
//        ServerSocket serverSocket = new ServerSocket(9999);
//        System.out.println("Ready...");
//        //루프 시작
//        while(true){
//            //연결  accept() socket
//            Socket socket = serverSocket.accept();
//            System.out.println(socket.getInetAddress()); // 접속한 클라이언트의 주소를 알 수 있다.
//
//
//            //클라이언트가 보낸 메시지 읽기
//            InputStream in = socket.getInputStream(); // 이전 클래스와 다르게 연결과 끊는 시간이 비교적 짧음. 필요할 때만 열었다 닫았다.(할일만 하고 닫는다.)
//            Scanner inScanner = new Scanner(in);
//
//            String msg = inScanner.nextLine();
//            System.out.println(msg); //kor,jap
//
//            String[] arr = map.get(msg);
//
//            //읽은 메시지를 다시 전송
//            String sendMsg = null;
//
//            if(arr == null) {
//                sendMsg = "다른 키워드를 입력하세요\n";
//            } else {
//                int idx = (int)(Math.random() * arr.length);
//                sendMsg = arr[idx]+ "\n";
//            }
//
//            //읽은 메시지를 다시 전송
////            String sendMsg ="SERVER: "+ msg +"\n";
//
//            OutputStream out = socket.getOutputStream(); // 서버 => 클라이언트
//
//            out.write(sendMsg.getBytes());
//            out.flush(); // 빨대안에 내용을 밀어주는 것
//
//            out.close();
//            inScanner.close();
//            in.close();
//            socket.close();
//            //소켓 연결 종료
//
//        }//end while
//
//
//
//    }
//}
