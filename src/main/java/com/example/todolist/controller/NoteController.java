package com.example.todolist.controller;

import com.example.todolist.model.Note;
import com.example.todolist.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    // Constructor-based dependency injection for NoteService
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Handle GET requests for listing all notes
    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll()); // Add the list of notes to the model
        return "note/list"; // Return the view name "list" located in the "note" directory
    }

    // Handle POST requests to delete a note by its ID
    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id); // Delete the note with the provided ID
        return "redirect:/note/list"; // Redirect to the notes list after deletion
    }

    // Handle GET requests for displaying the edit form for a specific note
    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") Long id, Model model) {
        try {
            Note note = noteService.getById(id); // Retrieve the note by its ID

            // Debugging output to verify the retrieved note
            System.out.println("Note: " + note);

            model.addAttribute("note", note);  // Add the "note" object to the model
            return "note/edit";  // Return the view name "edit" located in the "note" directory
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", e.getMessage());// Add the error message to the model
            return "error/404"; // Return the view name "404" located in the "error" directory (create error/404.html template)
        }
    }



    // Handle POST requests for saving the edited note
    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.update(note); // Update the note with the provided data
        return "redirect:/note/list"; // Redirect to the notes list after saving the changes
    }
}
