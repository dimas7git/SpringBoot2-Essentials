// Classe que representa os dados armazenados no banco de dados para a entidade Anime
package academy.devdojo.springboot2.curso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotação Lombok que gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor // Anotação Lombok que gera um construtor com todos os campo
@NoArgsConstructor
@Entity
@Builder
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do anime no banco de dados
    private String name; 
}
