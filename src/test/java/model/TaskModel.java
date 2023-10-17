package model;

import java.util.ArrayList;

public class TaskModel {

       public  int id;
       public ArrayList<Integer> tags;

        // Constructors, getters, and setters



    public TaskModel() {
        // Initialize the ArrayList of tags
        this.tags = new ArrayList<>();
    }

    public TaskModel(int id, ArrayList<Integer> tags) {
        this.id = id;
        this.tags = tags;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ArrayList<Integer> getTags() {
            return tags;
        }

        public void setTags(ArrayList<Integer> tags) {
            this.tags = tags;
        }
    }

