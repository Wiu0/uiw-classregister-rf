package com.uiw.resource;

import com.uiw.service.RegisterClassService;
import com.uiw.vo.StudentVO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/register_class")
public class RegisterClassResource {

    @Inject
    RegisterClassService registerClassService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/institute/{instituteId}/course/{courseId}/school_class/{schoolClassId}")
    public List<StudentVO> findStudentRegisterClass(Long instituteId, Long courseId, Long schoolClassId) {
        return registerClassService.findStudentByInstituteIdAndCourseIdAndSchoolClassId(instituteId, courseId, schoolClassId);
    }

}
