package com.uiw.service.impl;

import com.uiw.entity.StudentEntity;
import com.uiw.mapper.RegisterClassStudentMapper;
import com.uiw.repository.register_class.postgres.RegisterClassRepository;
import com.uiw.service.RegisterClassService;
import com.uiw.vo.StudentVO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class RegisterClassServiceImpl implements RegisterClassService {

    @Inject
    RegisterClassStudentMapper registerClassStudentMapper;

    @Inject
    private RegisterClassRepository registerClassRepository;


    public List<StudentVO> findStudentByInstituteIdAndCourseIdAndSchoolClassId(Long instituteId, Long courseId, Long schoolClassId) {

        Optional<List<StudentEntity>> optionalStudentEntities = Optional.ofNullable(registerClassRepository
                .findStudentByInstituteIdAndCourseIdAndSchoolClassId(instituteId, courseId, schoolClassId));

        return optionalStudentEntities.orElseThrow(getNotFoundExceptionSupplier(instituteId, courseId, schoolClassId))
                .stream().map(s -> registerClassStudentMapper.toMap(s)).collect(Collectors.toList());
    }

}
