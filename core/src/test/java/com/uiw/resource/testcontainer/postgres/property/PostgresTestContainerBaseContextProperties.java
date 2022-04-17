package com.uiw.resource.testcontainer.postgres.property;

import com.uiw.resource.testcontainer.TestContainerBaseContextProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostgresTestContainerBaseContextProperties implements TestContainerBaseContextProperties {

    public static final String TEST_CONTAINER_NAME = "postgres:alpine3.13";

    private String username;
    private String password;
    private String host;
    private int port;
    private String database;
    private String schema;

}
