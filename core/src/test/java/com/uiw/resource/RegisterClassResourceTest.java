package com.uiw.resource;

import com.uiw.vo.StudentVO;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RegisterClassResourceTest {

    @ConfigProperty(name = "root_test")
    String rootTest;

    @Test
    void should_return_a_class_registered_student() throws IOException {
        String jsonStr = IOUtils.toString(new FileReader(rootTest.concat("/files/class_registered_student.json")));
        List<StudentVO> students = new JsonArray(jsonStr).stream()
                .map(s ->  new JsonObject(s.toString()).mapTo(StudentVO.class))
                .collect(Collectors.toList());

        given().when().get("register_class/institute/1/course/1/school_class/1").then()
                .statusCode(200)
                .body(is(jsonStr));
    }

}
