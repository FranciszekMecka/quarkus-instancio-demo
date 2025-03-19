package com.example.fullstack.factory.task;

import com.example.fullstack.entity.task.Task;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
public class TaskFactoryUnitTest {

    @Inject
    TaskFactory taskFactory;

    @Test
    void createBatchTest() {
        List<Task> batch = taskFactory.createBatch(100000);

        assertThat(batch.isEmpty()).isFalse();
    }
}
