package org.zerock.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteMapTest {

    public static void main(String[] args) {

        Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>();
        //String 데이터 타입.
        // data > NoteDTO > ArrayList >  Map
        // HashMap :
        //ArrayList<NoteDTO> 만들어진것 Map에 넣어짐

        String who = "user1"; //쪽지를 보내는 사람
        //쪽지 만들어주기 user2가 user1에게 커피한잔? 이라고 보냄
        NoteDTO newbie = NoteDTO.builder().who("user2").whom("user1").content("커피한잔?").build();
        //사용자에게 온 쪽지 목록 확인
        ArrayList<NoteDTO> noteDTOS = noteMap.get(who);

        if (noteDTOS == null) { //기존에 온 쪽지가 존재하지 않을 때
            //ArrayList로 쪽지함을 만들어 새로 온 쪽지를 넣어줌
            ArrayList<NoteDTO> noteList = new ArrayList<>(); //받은 쪽지를 notelist 에 넣어줌
            noteList.add(newbie); // 쪽지를 추가
            noteMap.put(who, noteList);

            // ArrayList를 만들어서 넣고
        } else {
            noteDTOS.add(newbie); //쪽지가 있었으면 기존에 있는 쪽지함에 새로온 쪽지를 넣어줌
        } // 그냥 넣어라.

    }
}
