package org.zerock.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyInOut {

    public static void main(String[] args) {

        InputStream in = System.in;
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\82102\\test.txt"); // FileOutputStream  JVM 과 JVM의 바깥쪽이랑 통신을 해야하는 상황에서는 예외처리를 해야만한다.
                                      // 내용이 들어갈 장소를 만들어 준다.
            for (int i = 0; i < 10; i++) {
                int data = in.read(); // 1byte의 내용을 읽는다. 키보드로 입력한 내용을 읽어준다.
                out.write(data); // 텍스트 파일에 넣어준다.
            }
        } catch (Exception e) {
            e.printStackTrace(); // 에러의 이유를 보여준다. 공식 외워라(from.다은)
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {  // FileNotFoundException이 아니고 범용적으로 Exception으로 받아줌(write의 경우 JVM의 범위를 넘어가기 때문에)
                } //close 시 할 수 있는게 없다, 에러의 영역으로 넘어감.
            }
            if (out != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }

        }

    }
}