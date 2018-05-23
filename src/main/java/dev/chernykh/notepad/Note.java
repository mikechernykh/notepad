package dev.chernykh.notepad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity class representing a row of a table.
 */
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotBlank(message = "NotBlank.note.name")
    private String name;
}
