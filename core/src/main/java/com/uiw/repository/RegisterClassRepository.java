package com.uiw.repository;

import com.uiw.entity.StudentEntity;

import java.util.List;

public interface RegisterClassRepository {
    List<StudentEntity> findStudentByInstituteIdAndCourseIdAndSchoolClassId(Long instituteId, Long courseId, Long schoolClassId);
}
