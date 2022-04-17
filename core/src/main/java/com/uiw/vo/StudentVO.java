package com.uiw.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentVO {

    private Long id;
    private String name;
    private String nickName;
    private Byte order;
}
