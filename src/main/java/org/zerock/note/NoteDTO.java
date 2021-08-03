package org.zerock.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO { //노트안에 들어갈 내용. 쪽지에 쓸 내용(변수들)

    
private Integer no;
private String who,whom;
private String content;


}
