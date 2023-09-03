// Classe que implementa a lógica das regras de negócio relacionadas a animes
package academy.devdojo.springboot2.curso.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.mapper.AnimeMapper;
import academy.devdojo.springboot2.curso.repository.AnimeRepository;
import academy.devdojo.springboot2.curso.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.curso.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service // Indica que esta classe é um componente de serviço Spring
@RequiredArgsConstructor
public class AnimeService {
    
    private final AnimeRepository animeRepository;
    
    // Método para listar todos os animes
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    // Método para buscar um anime pelo ID ou lançar uma exceção se não encontrado
    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    // Método para salvar um novo anime a partir da requisição AnimePostRequestBody
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    // Método para deletar um anime pelo ID
    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    // Método para substituir um anime pelo ID a partir da requisição AnimePutRequestBody
    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
