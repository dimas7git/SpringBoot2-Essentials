// Classe com os endpoints relacionados a animes
package academy.devdojo.springboot2.curso.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.service.AnimeService;
import academy.devdojo.springboot2.curso.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController // Anotação indicando que esta classe é um controlador REST
@RequestMapping("animes") // Mapeia a URL base para todas as rotas neste controlador
@Log4j2 // Cria automaticamente um logger com o Lombok e Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    // Mapeando a URL localhost:8080/animes para este método
    @GetMapping
    public List<Anime> list() {
        // Registrando uma mensagem de log com a data e hora atual formatada
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        // Chama o serviço para listar todos os animes
        return animeService.listAll();
    }
}
