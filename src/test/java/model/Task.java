package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Task {


    @JsonProperty("id")

    public int id;
    @JsonProperty("tags")

    public List<Integer> tags;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

}
