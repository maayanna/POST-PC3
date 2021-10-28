package com.example.todoboom;

public class Todo {

    private String description;
    private boolean isDone;

    Todo(String todoItem, boolean isDone){
        this.description = todoItem;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public boolean getDone(){
        return isDone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}
