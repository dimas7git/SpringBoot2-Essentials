package academy.devdojo.springboot2.curso.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.exception.BadRequestException;
import academy.devdojo.springboot2.curso.mapper.AnimeMapper;
import academy.devdojo.springboot2.curso.repository.AnimeRepository;
import academy.devdojo.springboot2.curso.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.curso.requests.AnimePutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service // Indica que esta classe é um componente de serviço Spring, permitindo que o Spring a gerencie e a injete em outros componentes quando necessário.
@RequiredArgsConstructor // Gera automaticamente um construtor com todos os campos marcados como final.
public class AnimeService {
    
    private final AnimeRepository animeRepository;
    
    // Método para listar todos os animes
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    // Método para buscar animes pelo nome
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }
    
    // Método para buscar um anime pelo ID ou lançar uma exceção BadRequestException se não encontrado
    public Anime findByIdOrThrowBadRequestException(long id) {
        // Busca um anime pelo ID e, se não encontrado, lança uma exceção BadRequestException
        return animeRepository.findById(id)
            .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    // Método para salvar um novo anime a partir da requisição AnimePostRequestBody
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        // Converte a requisição em um objeto Anime e o salva no repositório
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    
    // Método para deletar um anime pelo ID
    public void delete(long id) {
        // Chama o método findByIdOrThrowBadRequestException para garantir que o anime existe antes de excluí-lo
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    // Método para substituir um anime pelo ID a partir da requisição AnimePutRequestBody
    public void replace(AnimePutRequestBody animePutRequestBody) {
        // Busca o anime existente pelo ID ou lança uma exceção BadRequestException se não encontrado
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        
        // Converte o AnimePutRequestBody em um objeto Anime
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        
        // Define o mesmo ID do anime existente para garantir que a substituição ocorra no registro correto
        anime.setId(savedAnime.getId());
        
        // Salva o anime atualizado no repositório
        animeRepository.save(anime);
    }
}
