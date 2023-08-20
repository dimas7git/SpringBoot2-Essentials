// Classe que implementa a lógica das regras de negócio relacionadas a animes
package academy.devdojo.springboot2.curso.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.curso.domain.Anime;

@Service // Indica que esta classe é um componente de serviço Spring
public class AnimeService {
    private List<Anime> animes = List.of(new Anime(1L, "One Piece"), new Anime(2L, "Naruto"));
    
    // Método que retorna uma lista de todos os animes (exemplo de regra de negócio)
    public List<Anime> listAll() {
        // Retorna a lista de animes pré-definida
        return animes;
    }

    // Método que busca um anime pelo ID (exemplo de regra de negócio)
    public Anime findById(long id) {
        // Busca o anime na lista por ID e lança uma exceção caso não seja encontrado
        return animes.stream()
            .filter(anime -> anime.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
    }
}
