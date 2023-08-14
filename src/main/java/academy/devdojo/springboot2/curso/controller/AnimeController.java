package academy.devdojo.springboot2.curso.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.devdojo.springboot2.curso.domain.Anime;

@RestController
@RequestMapping("anime")
public class AnimeController {
    //localhost:8080/anime/list
    @GetMapping(path = "list")
    public List<Anime> list(){
        return List.of(new Anime("One Piece"), new Anime("Naruto"));
    }
}
