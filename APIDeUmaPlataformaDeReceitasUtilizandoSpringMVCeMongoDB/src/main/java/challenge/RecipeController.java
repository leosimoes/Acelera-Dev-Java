package challenge;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @PostMapping()
    public Recipe save(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Recipe recipe, @PathVariable(value = "id") String id) {
        service.update(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Recipe> get(@PathVariable(value = "id") String id) {
        return service.get(id);
    }

    @GetMapping("/ingredient")
    public List<Recipe> listByIngredient(@RequestParam String ingredient) {
        return service.listByIngredient(ingredient);
    }

    @GetMapping("/search")
    public List<Recipe> search(@RequestParam String search) {
        return service.search(search);
    }

    @PostMapping("/{id}/like/{userId}")
    public void like(@PathVariable(value = "id") String id, @PathVariable(value = "userId") String userId) {
        service.like(id, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public void unlike(@PathVariable(value = "id") String id, @PathVariable(value = "userId") String userId) {
        service.unlike(id, userId);
    }

    @PostMapping("/{id}/comment")
    public RecipeComment addComment(@PathVariable(value = "id") String id, @RequestBody RecipeComment comment) {
        return service.addComment(id, comment);
    }

    @PutMapping("/{id}/comment/{commentId}")
    public void updateComment(@PathVariable(value = "id") String id, @PathVariable(value = "commentId") String commentId, @RequestBody RecipeComment comment) {
        service.updateComment(id, commentId, comment);
    }

    @DeleteMapping("/{id}/comment/{commentId}")
    public void deleteComment(@PathVariable(value = "id") String id, @PathVariable(value = "commentId") String commentId) {
        service.deleteComment(id, commentId);
    }
}
