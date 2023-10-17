package model;

import java.util.ArrayList;

public class ProjectModel {

 public String name;
    public String description;
    public ArrayList<TaskModel> tasks;

    // Constructors, getters, and setters

    public ProjectModel() {
        // Initialize the ArrayList of tasks
        this.tasks = new ArrayList<>();
    }

    public ProjectModel(String name, String description, ArrayList<TaskModel> tasks) {
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

    public ArrayList<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }
}

