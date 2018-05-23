package dev.chernykh.notepad;

import java.util.List;

/**
 * Data access interface defines operations for notes.
 */
public interface NoteDao {
    /**
     * Find all notes with pagination.
     *
     * @param offset an offset from the beginning of a table
     * @param size   size of a page
     * @return a list of notes
     */
    List<Note> findAll(int offset, int size);

    /**
     * Save a new note.
     *
     * @param note a new note
     */
    void save(Note note);

    /**
     * Find notes which match a query string. Return result with pagination.
     *
     * @param query  a query string
     * @param offset an offset from the beginning of the result
     * @param size   size of a page
     * @return a list of notes
     */
    List<Note> find(String query, int offset, int size);
}
