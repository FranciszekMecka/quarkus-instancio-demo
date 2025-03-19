package com.example.fullstack.factory.task;

import com.example.fullstack.entity.task.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.instancio.Instancio;

import java.util.List;

@ApplicationScoped
public class TaskFactory {

    public List<Task> createBatch(int amount) {
        return Instancio.ofList(Task.class).size(amount).create();
    }

}
