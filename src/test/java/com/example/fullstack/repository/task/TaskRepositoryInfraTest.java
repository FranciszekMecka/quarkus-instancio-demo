package com.example.fullstack.repository.task;

import com.example.fullstack.entity.task.Task;
import com.example.fullstack.repository.TaskRepository;
import com.google.common.base.Stopwatch;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

@QuarkusTest
public class TaskRepositoryInfraTest {

    @Inject
    TaskRepository taskRepository;

    @Test
    @TestTransaction
    void shouldPersistEntity_whenPersist_givenRandomEntity() {
        Task task = Instancio.of(Task.class).ignore(field(Task::getId)).create();

        taskRepository.persist(task);

        assertThat(taskRepository.findById(task.getId())).isNotNull();
    }

    @Test
    @TestTransaction
    void shouldPersistListOfEntities_whenPersist_givenRandomEntities() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        List<Task> tasks = Instancio.ofList(Task.class)
            .size(10_000)
            .ignore(field(Task::getId)).create();

        taskRepository.persist(tasks);

        stopwatch.stop();
        System.out.println("Instancio.create() took: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }

}
