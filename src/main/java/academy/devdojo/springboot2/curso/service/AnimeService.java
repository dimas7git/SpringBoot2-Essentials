// Classe que implementa a lógica das regras de negócio relacionadas a animes
package academy.devdojo.springboot2.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.repository.AnimeRepository;
import academy.devdojo.springboot2.curso.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.curso.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service // Indica que esta classe é um componente de serviço Spring
@RequiredArgsConstructor
public class AnimeService {
    
    private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        // Retorna a lista de animes pré-definida
        return animeRepository.findAll();
    }

    // Método que busca um anime pelo ID (exemplo de regra de negócio)
    public Anime findByIdOrThrowBadRequestException(long id) {
        // Busca o anime na lista por ID e lança uma exceção caso não seja encontrado
        return animeRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    // Método para salvar um novo anime na lista
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    // Método para deletar um anime da lista pelo ID
    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    // Método para substituir um anime na lista pelo ID
    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
            .id(savedAnime.getId())
            .name(animePutRequestBody.getName())
            .build();

        animeRepository.save(anime);
    }
}
