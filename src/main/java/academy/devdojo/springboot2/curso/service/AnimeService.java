// Classe que implementa a lógica das regras de negócio relacionadas a animes
package academy.devdojo.springboot2.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academy.devdojo.springboot2.curso.domain.Anime;

@Service // Indica que esta classe é um componente de serviço Spring
public class AnimeService {

    // Método que retorna uma lista de animes fictícios (exemplo de regra de negócio)
    public List<Anime> listAll() {
        // Retorna uma lista de animes com IDs e nomes pré-definidos
        return List.of(new Anime(1L, "One Piece"), new Anime(2L, "Naruto"));
    }
}
