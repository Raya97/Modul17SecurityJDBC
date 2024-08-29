package com.example.todolist.service;

import com.example.todolist.repository.NoteRepository;
import com.example.todolist.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Note not found"));
    }
}

