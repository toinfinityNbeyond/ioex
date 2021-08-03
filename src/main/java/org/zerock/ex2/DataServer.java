package org.zerock.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ready..");

        while(true){

            Socket socket = serverSocket.accept();
            InputStream in  = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF();

            System.out.println("CLIENT MSG: " + str);

            String msg ="Luna";

            dos.writeUTF(msg);
            dos.flush();


        }//end while

    }
}