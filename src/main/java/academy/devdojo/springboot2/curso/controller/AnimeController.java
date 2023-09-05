// Classe com os endpoints relacionados a animes
package academy.devdojo.springboot2.curso.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.curso.requests.AnimePutRequestBody;
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
    public ResponseEntity<List<Anime>> list() {
        // Registrando uma mensagem de log com a data e hora atual formatada
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        // Chama o serviço para listar todos os animes e retorna com status OK
        return ResponseEntity.ok(animeService.listAll());
    }
    
    // Mapeando a URL localhost:8080/animes/{id} para este método
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        // Chama o serviço para buscar um anime pelo ID e retorna com status OK se encontrado
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }

     @GetMapping(path = "/find/{nome}")
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
        // Chama o serviço para buscar um anime pelo ID e retorna com status OK se encontrado
        return ResponseEntity.ok(animeService.findByNAme(name));
    }

    // Mapeando a URL localhost:8080/animes para este método com o método HTTP POST
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody){
        // Chama o serviço para salvar um novo anime e retorna com status CREATED
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    // Mapeando a URL localhost:8080/animes/{id} para este método com o método HTTP DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        // Chama o serviço para deletar um anime pelo ID e retorna com status NO_CONTENT
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Mapeando a URL localhost:8080/animes para este método com o método HTTP PUT
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        // Chama o serviço para substituir um anime pelo ID e retorna com status NO_CONTENT
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
