// Interface que define a conexão com o banco de dados e as queries relacionadas à entidade Anime
package academy.devdojo.springboot2.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.devdojo.springboot2.curso.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long>{
    List<Anime> findByName(String name);
}
