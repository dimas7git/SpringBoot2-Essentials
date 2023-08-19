// Interface que define a conexão com o banco de dados e as queries relacionadas à entidade Anime
package academy.devdojo.springboot2.curso.repository;

import java.util.List;

import academy.devdojo.springboot2.curso.domain.Anime;

public interface AnimeRepository {
    List<Anime> listAll(); // Método para listar todos os animes do banco de dados
}
