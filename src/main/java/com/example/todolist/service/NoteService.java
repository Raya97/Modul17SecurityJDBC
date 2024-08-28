package com.example.todolist.service;

import com.example.todolist.model.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    // A map to store notes with their IDs as keys
    private final Map<Long, Note> notes = new HashMap<>();
    private long currentId = 1L; // A counter to generate unique IDs for new notes

    // Returns a list of all notes
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    // Adds a new note and assigns it a unique ID
    public Note add(Note note) {
        note.setId(currentId++); // Set a unique ID to the note
        notes.put(note.getId(), note); // Store the note in the map
        return note;
    }

    // Initializes the service with some default notes
    @PostConstruct
    public void init() {
        add(new Note(null, "First Note", "This is the first note.")); // Add the first note
        add(new Note(null, "Second Note", "This is the second note.")); // Add the second note
    }

    // Deletes a note by its ID
    public void deleteById(long id) {
        if (!notes.containsKey(id)) { // Check if the note exists
            throw new NoSuchElementException("Note with id " + id + " not found"); // Throw an exception if not found
        }
        notes.remove(id);
    }

    // Check if the note exists
    public void update(Note note) {
        if (!notes.containsKey(note.getId())) { // Check if the note exists
            throw new NoSuchElementException("Note with id " + note.getId() + " not found"); // Throw an exception if not found
        }
        notes.put(note.getId(), note); // Update the note in the map
    }


    // Retrieves a note by its ID
    public Note getById(long id) {
        if (!notes.containsKey(id)) { // Check if the note exists
            throw new NoSuchElementException("Note with id " + id + " not found"); // Throw an exception if not found
        }
        return notes.get(id); // Return the found note
    }
}
