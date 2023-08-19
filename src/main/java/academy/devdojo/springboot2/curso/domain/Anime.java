// Classe que representa os dados armazenados no banco de dados para a entidade Anime
package academy.devdojo.springboot2.curso.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Anotação Lombok que gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor // Anotação Lombok que gera um construtor com todos os campos
public class Anime {

    private Long id; // Identificador único do anime no banco de dados
    private String name; 
}
