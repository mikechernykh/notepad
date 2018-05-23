package dev.chernykh.notepad;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * The controller to add, display and search notes.
 */
@AllArgsConstructor
@Controller
@RequestMapping("/notes")
public class NotesController {
    private final NoteService noteService;

    /**
     * Create a new note.
     *
     * @param pageable pagination information
     * @return model and view name
     */
    @GetMapping
    public ModelAndView notes(@PageableDefault Pageable pageable) {
        ModelMap model = new ModelMap();
        model.addAttribute(noteService.getAll(pageable.getOffset(), pageable.getPageSize()));
        return new ModelAndView("notes", model);
    }

    /**
     * Display a creation form.
     *
     * @return model and view name
     */
    @GetMapping("create")
    public ModelAndView createNoteForm() {
        ModelMap model = new ModelMap();
        model.addAttribute(new Note());
        return new ModelAndView("create", model);
    }

    /**
     * Validate and save a new note.
     *
     * @param note   a new note
     * @param result validation errors if exist
     * @return model and view name
     */
    @PostMapping("create")
    public ModelAndView createNote(@Valid @ModelAttribute Note note, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("create");
        }
        noteService.create(note);
        return new ModelAndView("redirect:/");
    }

    /**
     * Find notes match query string.
     *
     * @param query a query string
     * @param pageable pagination information
     * @return model and view name
     */
    @GetMapping(value = "search", params = {"q"})
    public ModelAndView search(@RequestParam("q") String query, @PageableDefault Pageable pageable) {
        ModelMap model = new ModelMap();
        model.addAttribute("q", query);
        model.addAttribute(noteService.search(query, pageable.getOffset(), pageable.getPageSize()));
        return new ModelAndView("notes", model);
    }
}
