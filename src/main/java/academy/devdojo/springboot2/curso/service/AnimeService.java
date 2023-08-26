// Classe que implementa a lógica das regras de negócio relacionadas a animes
package academy.devdojo.springboot2.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.curso.domain.Anime;

@Service // Indica que esta classe é um componente de serviço Spring
public class AnimeService {
    private static List<Anime> animes;
    
    // Inicialização estática da lista de animes com alguns valores pré-definidos
    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "One Piece"), new Anime(2L, "Naruto")));
    }
    
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

    // Método para salvar um novo anime na lista
    public Anime save(Anime anime) {
        // Gera um ID aleatório para o anime
        anime.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        
        // Adiciona o anime à lista
        animes.add(anime);
        
        // Retorna o anime salvo com o novo ID
        return anime;
    }

    // Método para deletar um anime da lista pelo ID
    public void delete(long id) {
        // Busca o anime na lista pelo ID e remove se encontrado
        animes.remove(findById(id));
    }

    // Método para substituir um anime na lista pelo ID
    public void replace(Anime anime) {
        // Remove o anime atual pelo ID e adiciona o novo anime
        delete(anime.getId());
        animes.add(anime);
    }
}
