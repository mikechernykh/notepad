package dev.chernykh.notepad;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link NoteDao} interface.
 */
@AllArgsConstructor
@Repository
public class NoteDaoImpl implements NoteDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Note> findAll(int offset, int size) {
        String sql = "SELECT * FROM notes LIMIT ?,?";
        return jdbcTemplate.query(sql, (resultSet) -> {
            ArrayList<Note> notes = new ArrayList<>();
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getLong("id"));
                note.setName(resultSet.getString("name"));
                notes.add(note);
            }
            return notes;
        }, offset, size);
    }

    @Override
    public void save(Note note) {
        String sql = "INSERT INTO notes(name) VALUES (?)";
        jdbcTemplate.update(sql, note.getName());
    }

    @Override
    public List<Note> find(String query, int offset, int size) {
        String sql = "SELECT * FROM notes WHERE MATCH (name) AGAINST (?) LIMIT ?,?";
        return jdbcTemplate.query(sql, (resultSet) -> {
            ArrayList<Note> notes = new ArrayList<>();
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getLong("id"));
                note.setName(resultSet.getString("name"));
                notes.add(note);
            }
            return notes;
        }, query, offset, size);
    }
}
