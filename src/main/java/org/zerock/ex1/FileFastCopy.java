package org.zerock.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileFastCopy {

    public static void main(String[] args) {

        //try with resource
        try(InputStream fin = new FileInputStream("C:\\Users\\82102\\sample.txt");
            OutputStream fos = new FileOutputStream("C:\\Users\\82102\\copy.txt");
            ) {

            byte[] arr = new byte[5]; //8kb
            while (true) {
                int count = fin.read(arr); // 몇 개나 새로운 데이터를 읽었나를 의미

                System.out.println("COUT: " + count);
                System.out.println(Arrays.toString(arr));

                if(count == -1) { break;} //-1 는 더이상의 읽을 데이터가 없다면을 의미
                //fos.write(arr, 0, count);
                fos.write(arr);
            }//end while

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
