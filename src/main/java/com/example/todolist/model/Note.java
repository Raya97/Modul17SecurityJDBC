package com.example.todolist.model;

public class Note {
    private Long id; // Unique identifier for the note
    private String title; // Title of the note
    private String content;  // Content of the note

    // Constructor that accepts all three fields
    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getter for 'id'
    public Long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'title'
    public String getTitle() {
        return title;
    }

    // Setter for 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for 'content'
    public String getContent() {
        return content;
    }

    // Setter for 'content'
    public void setContent(String content) {
        this.content = content;
    }
}

