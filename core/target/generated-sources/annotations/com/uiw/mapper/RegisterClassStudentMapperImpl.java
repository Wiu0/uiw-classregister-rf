package com.uiw.mapper;

import com.uiw.entity.StudentEntity;
import com.uiw.vo.StudentVO;
import com.uiw.vo.StudentVO.StudentVOBuilder;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T21:23:21-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class RegisterClassStudentMapperImpl implements RegisterClassStudentMapper {

    @Override
    public StudentVO toMap(StudentEntity studentEntities) {
        if ( studentEntities == null ) {
            return null;
        }

        StudentVOBuilder studentVO = StudentVO.builder();

        studentVO.id( studentEntities.getId() );
        studentVO.name( studentEntities.getName() );
        studentVO.nickName( studentEntities.getNickName() );
        studentVO.order( studentEntities.getOrder() );

        return studentVO.build();
    }
}
