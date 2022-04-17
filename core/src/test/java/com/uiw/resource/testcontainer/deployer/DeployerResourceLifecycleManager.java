package com.uiw.resource.testcontainer.deployer;

import com.uiw.resource.testcontainer.TestContainerBase;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface DeployerResourceLifecycleManager extends QuarkusTestResourceLifecycleManager {

    Map<String, String> properties = new HashMap<>();

    @Override
    default Map<String, String> start() {
        Arrays.stream(this.getClass().getAnnotationsByType((QuarkusTestResource.class)))
                .forEach(quarkusTestResource -> {
                           synchronized (TestContainerBase.notify) {
                               try {
                                   TestContainerBase.notify.wait();
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }
                           }
                        }
                );
        Optional.ofNullable(startAll()).ifPresent(properties::putAll);

        return properties;
    }

    Map<String, String> startAll();

    @Override
    default void stop() {

    }

    @Override
    default void init(Map<String, String> initArgs) {
        Optional.ofNullable(initArgs).ifPresent(properties::putAll);
    }
}
