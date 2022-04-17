package com.uiw.mapper;

import com.uiw.entity.StudentEntity;
import com.uiw.vo.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface RegisterClassStudentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nickName", source = "nickName")
    @Mapping(target = "order", source = "order")
    StudentVO toMap(StudentEntity studentEntities);
}
