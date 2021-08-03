package org.zerock.note;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//소켓으로 연결된 메세지가 들어온다.
//NoteDTO부분을 서비스한테 던져주면 보관해줌.
public class NoteServer {
    // bad code
    public static void main(String[] args) throws  Exception {

        NoteService service = new NoteService();

        //serversocket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ready...");
        //loop
        while (true){

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream =
                    new DataInputStream(socket.getInputStream());
            String msg = dataInputStream.readUTF(); // utf로 읽어.

            Gson gson = new Gson();

            Command command = gson.fromJson(msg, Command.class); //커맨드 타입의 인스턴스로 만들어줘.
            //msg를 커맨드 타입을 읽어준다~

            System.out.println(command);

            String oper = command.getOper(); //getter Command클래스에서 가져옴.

            if (oper.equalsIgnoreCase("ADD")){
                service.add(command.getNoteDTO());
            }else if(oper.equalsIgnoreCase("READ")){
                String owner = command.getNoteDTO().getWhom();
                System.out.println(service.getList(owner));
            }

        }
        //socket

        //DataInputStream readUTF() => 문자열

        //Gson => 문자열을 Command 객체

        //Command객체의 oper 값이 ADD 면 service.add()

    }
}
