package com.uiw.resource.register_class.testcontainers.deployer;

import com.uiw.resource.testcontainer.deployer.DeployerResourceLifecycleManager;
import com.uiw.resource.testcontainer.postgres.PostgresTestContainerBase;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.ResourceArg;
import lombok.extern.jbosslog.JBossLog;

import java.util.Map;

@QuarkusTestResource(
        value = PostgresTestContainerBase.class, parallel = true, initArgs = {
        @ResourceArg(name = PostgresTestContainerBase.SCRIPT_0_INITIAL, value = "script/step_0_initial.sql"),
        @ResourceArg(name = PostgresTestContainerBase.SCRIPT_1_TABLE, value = "script/step_1_create_tables.sql")}
        )
@JBossLog
public class DeployerResourceLifecycleManagerRegisterClass implements DeployerResourceLifecycleManager {

    @Override
    public Map<String, String> startAll() {
        log.info(PostgresTestContainerBase.getConfigProperties());
        return null;
    }
}
