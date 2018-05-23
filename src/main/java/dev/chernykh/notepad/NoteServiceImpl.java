package dev.chernykh.notepad;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of the {@link NoteService} interface.
 */

@AllArgsConstructor
@Service
@Slf4j
public class NoteServiceImpl implements NoteService {
    private final NoteDao noteDao;

    public List<Note> getAll(int offset, int size) {
        log.info("NOTE SERVICE: get all notes");
        return noteDao.findAll(offset, size);
    }

    @Override
    public void create(@NonNull Note note) {
        log.info("NOTE SERVICE: create a new note");
        noteDao.save(note);
    }

    @Override
    public List<Note> search(String query, int offset, int size) {
        log.info("NOTE SERVICE: search notes matching query string");
        if (query.isEmpty()) {
            return Collections.emptyList();
        }
        return noteDao.find(query, offset, size);
    }
}
