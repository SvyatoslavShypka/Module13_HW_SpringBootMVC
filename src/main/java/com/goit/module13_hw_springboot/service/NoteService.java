package com.goit.module13_hw_springboot.service;

import com.goit.module13_hw_springboot.entity.Note;
import com.goit.module13_hw_springboot.exception.RecordNotFoundException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class NoteService {

    private Map<Long, Note> map = new HashMap<>();

    public NoteService() {
    }

    public List<Note> listAll() {
        List<Note> result = new ArrayList<>();
        for (Map.Entry<Long, Note> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public Note add(Note note) {
        Random random = new Random();
        note.setId(random.nextLong(1000000));
        map.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (map.remove(id) == null) {
            throw new RecordNotFoundException("Note was not found");
        }
    }

    public void update(Note note) {
        Note getNote = getById(note.getId());
        getNote.setTitle(note.getTitle());
        getNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        Note result;
        result = map.get(id);
        if (result == null) {
            throw new RecordNotFoundException("Note was not found");
        }
        return result;
    }

}
