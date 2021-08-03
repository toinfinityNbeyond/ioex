package org.zerock.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Command {

    private String oper; //추가 조회 삭제를 결정

    private NoteDTO noteDTO; // 객체안에 객체를 가지는 구조


}
