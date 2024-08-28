package com.example.todolist.service;

import com.example.todolist.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private long currentId = 1L;

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        note.setId(currentId++);
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with id " + id + " not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new NoSuchElementException("Note with id " + note.getId() + " not found");
        }
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note with id " + id + " not found");
        }
        return notes.get(id);
    }
}
