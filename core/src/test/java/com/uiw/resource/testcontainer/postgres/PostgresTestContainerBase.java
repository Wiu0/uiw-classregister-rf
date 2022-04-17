package com.uiw.resource.testcontainer.postgres;

import com.uiw.resource.testcontainer.TestContainerBase;
import com.uiw.resource.testcontainer.postgres.property.PostgresTestContainerBaseContextProperties;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;
import java.util.Optional;

public class PostgresTestContainerBase implements TestContainerBase {

    public static final String SCRIPT_0_INITIAL = "step_0_initial.sql";
    public static final String SCRIPT_1_TABLE = "step_1_create_tables.sql";

    static PostgreSQLContainer<?> postgresSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse(PostgresTestContainerBaseContextProperties.TEST_CONTAINER_NAME));

    public static PostgresTestContainerBaseContextProperties getConfigProperties() {
        return PostgresTestContainerBaseContextProperties.builder()
                .host(postgresSQLContainer.getContainerIpAddress())
                .password(postgresSQLContainer.getPassword())
                .database(postgresSQLContainer.getDatabaseName())
                .port(postgresSQLContainer.getFirstMappedPort())
                .username(postgresSQLContainer.getUsername())
                .build();
    }

    @Override
    public PostgresTestContainerBaseContextProperties startContainer() {
        postgresSQLContainer.start();
        return getConfigProperties();
    }

    @Override
    public void init(Map<String, String> initArgs) {
        Optional.ofNullable(initArgs.get(SCRIPT_0_INITIAL))
                .ifPresent(script -> postgresSQLContainer.withClasspathResourceMapping(script, "/docker-entrypoint-initdb.d/".concat(SCRIPT_0_INITIAL), BindMode.READ_WRITE));
        Optional.ofNullable(initArgs.get(SCRIPT_1_TABLE))
                .ifPresent(script -> postgresSQLContainer.withClasspathResourceMapping(script, "/docker-entrypoint-initdb.d/".concat(SCRIPT_1_TABLE), BindMode.READ_WRITE));
    }

    @Override
    public void stop() {
        postgresSQLContainer.stop();
    }


}
