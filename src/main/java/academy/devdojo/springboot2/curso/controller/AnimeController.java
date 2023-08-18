package academy.devdojo.springboot2.curso.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.util.DateUtil;
import lombok.extern.log4j.Log4j2;

@RestController // Anotação indicando que esta classe é um controlador REST
@RequestMapping("anime") // Mapeia a URL base para todas as rotas neste controlador
@Log4j2 // Cria automaticamente um logger com o Lombok e Log4j2

public class AnimeController {

    private DateUtil dateUtil;

    // Injetando a dependência DateUtil no construtor
    public AnimeController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    // Mapeando a URL localhost:8080/anime/list para este método
    @GetMapping(path = "list")
    public List<Anime> list() {
        // Registrando uma mensagem de log com a data e hora atual formatada
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        return List.of(new Anime("One Piece"), new Anime("Naruto"));
    }
}
