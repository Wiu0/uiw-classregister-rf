package com.uiw.entity;

import com.uiw.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentEntity {

    private Long id;
    private String name;
    private String nickName;
    private Byte order;
    private StudentStatus status;

}
