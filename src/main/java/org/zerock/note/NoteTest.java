package org.zerock.note;

import com.google.gson.Gson;

public class NoteTest {

    public static void main(String[] args) {

//        //Json의 장점 : 직접 문자를 DTO로 바꾸지 않아도 자동으로 만들어줌.문자열로 데이터로
//
//        NoteDTO dto = NoteDTO.builder().who("A").whom("B").content("밥먹자").build();
//
//
//        Gson gson = new Gson();
//
//        String jsonStr = gson.toJson(dto);
//
//        System.out.println(jsonStr);
//
//        NoteDTO result = gson.fromJson(jsonStr, NoteDTO.class);
//
//        System.out.println(result);
        // json은 문자열 => 객체 , 객체=>문자열로 바꿔줄 수 있어짐. 이 기능을 해주는 포맷중 하나.


        //add
        NoteDTO data = NoteDTO.builder().who("A").whom("B").content("커피 한잔?").build();

        Command command = Command.builder().oper("ADD").noteDTO(data).build();
        //command 클래스 지정한 oper add 기능이
        //data > NoteDTO > oper ("어떤기능을 사용?")
        //oper : 값을 가지고 추가를 해야하는지 뭔지 확인

        System.out.println(command);
        //Command(oper=ADD, noteDTO=NoteDTO(no=null, who=A, whom=B, content=커피 한잔?))


        Gson gson = new Gson();

        System.out.println(gson.toJson(command));
        //{"oper":"ADD","noteDTO":{"who":"A","whom":"B","content":"커피 한잔?"}}
        // 문자열로 " " 가 붙는다.
        // json을 통해 객체를 문자열로 만들어 줌. (String)


        // 이 클래스는 json의 기능을 확인하려고 만든 클래스이다.


    }
}
