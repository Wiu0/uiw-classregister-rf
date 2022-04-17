package com.uiw.service;

import com.uiw.vo.StudentVO;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.function.Supplier;

public interface RegisterClassService {

    List<StudentVO> findStudentByInstituteIdAndCourseIdAndSchoolClassId(Long instituteId, Long courseId, Long schoolClassId);

    default Supplier<NotFoundException> getNotFoundExceptionSupplier(Long instituteId, Long courseId, Long schoolClassId) {
        return () -> new NotFoundException("Students not found for this instituteId, courseId and schoolClassId "
                .concat(instituteId.toString()).concat(", ")
                .concat(courseId.toString()).concat(", ")
                .concat(schoolClassId.toString()));
    }
}
