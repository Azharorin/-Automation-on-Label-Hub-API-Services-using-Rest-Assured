package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProjectCreate {
    @JsonProperty("name")


    public  String name;
    @JsonProperty("description")

    public String description;
    @JsonProperty("tasks")

    public List<Task> tasks;

    public ProjectCreate() {

    }

    public ProjectCreate(String name, String description, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}




