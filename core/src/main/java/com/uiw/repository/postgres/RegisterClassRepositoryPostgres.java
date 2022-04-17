package com.uiw.repository.postgres;

import com.uiw.entity.StudentEntity;
import com.uiw.enums.StudentStatus;
import com.uiw.repository.RegisterClassRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class RegisterClassRepositoryPostgres implements RegisterClassRepository {

    @Override
    public List<StudentEntity> findStudentByInstituteIdAndCourseIdAndSchoolClassId(Long instituteId, Long courseId, Long schoolClassId) {
        return Arrays.asList(StudentEntity.builder()
                .id(0L)
                .name("William Noronha")
                .nickName("wiu")
                .order((byte)1)
                .status(StudentStatus.ACTIVE).build());
    }
}
