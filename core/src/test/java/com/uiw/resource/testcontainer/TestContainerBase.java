package com.uiw.resource.testcontainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

public interface TestContainerBase extends QuarkusTestResourceLifecycleManager {

    Object notify = new Object();

    default Map<String, String> start() {
        startContainer();

        synchronized (notify) {
            notify.notifyAll();
        }

        return properties();
    }

    default Map<String, String> properties() {
        return Map.of();
    }

    TestContainerBaseContextProperties startContainer();
}
