package org.zerock.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteService {

    // add 메소드에 쌓이는 데이터를 선언해줌
    private Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>();
    private Integer idx = 0; // 온 쪽지에 번호를 매겨줌


    public Integer add(NoteDTO noteDTO){  // 쪽지 등록(추가),
        // Integer 는 리턴 타입 add 메소드명, NoteDTO noteDTO는 파라미터

        noteDTO.setNo(++idx); // 번호 셋팅 add가 실행 할때마다 번호(idx)가 ++  setter
        String owner = noteDTO.getWhom(); // 누구에게 보냈는지 찾음. 누구에게 보내지고 쌓여짐. whom이 누군지 알아냄. getter

        ArrayList<NoteDTO> noteDTOS = noteMap.get(owner); //owner리스트를 확인

        if(noteDTOS == null){
            ArrayList<NoteDTO> noteList = new ArrayList<>();
            noteList.add(noteDTO); // 쪽지 넣고
            noteMap.put(owner,noteList ); // 쪽지 추가
        }else {
            noteDTOS.add(noteDTO);
        }

        return idx;
    } // end add

    public ArrayList<NoteDTO> getList(String owner){ //쪽지조회
        return noteMap.get(owner); // noteMap에서 owner(키)가 받은 값을 리턴하면 조회는 끝
    } // ArrayList<NoteDTO> 로 리턴값으로 선언




//    public static void main(String[] args) {
//        NoteService service = new NoteService();
//        NoteDTO noteDTO = NoteDTO.builder().who("user2").whom("user1").content("이해가 안가").build();
//        service.add(noteDTO);
//
//        NoteDTO noteDTO2 = NoteDTO.builder().who("user3").whom("user1").content("나도 이해가 안가").build();
//        service.add(noteDTO2);
//
//        NoteDTO noteDTO3 = NoteDTO.builder().who("user1").whom("user2").content("끝나고 남아").build();
//        service.add(noteDTO3);
//
//        System.out.println(service.noteMap);
//
//
//    }
}