package dev.chernykh.notepad;

import java.util.List;

/**
 * The interface represents operations to perform on notes.
 */
public interface NoteService {

    /**
     * Get a list of notes with pagination.
     *
     * @param offset a page number
     * @param size size of a page
     * @return a list of notes
     */
    List<Note> getAll(int offset, int size);

    /**
     * Save a new note.
     *
     * @param note
     */
    void create(Note note);

    /**
     * Look up notes by query string.
     *
     * @param query a query string
     * @param offset a page number
     * @param size size of a page
     * @return a list of notes
     */
    List<Note> search(String query, int offset, int size);
}
