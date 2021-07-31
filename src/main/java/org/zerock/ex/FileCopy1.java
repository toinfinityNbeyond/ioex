package org.zerock.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileCopy1 {

    //bad code
    public static void main(String[] args) throws Exception {



        //URL url = new URL("http://mp4.cine21.com/cine21.com/movie/trailer/2021/06/moga_1tr.mp4");
        //InputStream in = url.openStream();
        InputStream in = new FileInputStream("C:\\Users\\82102\\aaa.jpg");

        System.out.println(in);

        OutputStream out = new FileOutputStream("C:\\Users\\82102\\copy.jpg");

        long start = System.currentTimeMillis();

        while(true){

            int data = in.read();

            //System.out.println(data);

            if(data == -1){ break;}

            out.write(data);


        }//end while
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}