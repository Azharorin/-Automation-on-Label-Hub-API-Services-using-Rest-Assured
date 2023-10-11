package model;

public class TagCreation {
    public String name;
 public int task_id;
  public  String short_form;
  public  String category;
  public String description;

    // Constructors, getters, and setters
    public TagCreation() {
        // Default constructor
    }

    public TagCreation(String name, int task_id, String short_form, String category, String description) {
        this.name = name;
        this.task_id = task_id;
        this.short_form = short_form;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getShort_form() {
        return short_form;
    }

    public void setShort_form(String short_form) {
        this.short_form = short_form;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


