package com.goit.module13_hw_springboot.controller;

import com.goit.module13_hw_springboot.entity.Note;
import com.goit.module13_hw_springboot.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    NoteService noteService = new NoteService();

    @GetMapping("/signup")
    public String showSignUpForm(Note note) {
        return "add-note";
    }

    @PostMapping("/addnote")
    public String addUser(Note note, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-note";
        }
        noteService.add(note);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showAllNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Note note = noteService.getById(id);

        model.addAttribute("note", note);
        return "update-note";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable("id") long id, Note note,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            note.setId(id);
            return "update-note";
        }
        noteService.update(note);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id, Model model) {
        noteService.deleteById(id);
        return "redirect:/index";
    }
}
