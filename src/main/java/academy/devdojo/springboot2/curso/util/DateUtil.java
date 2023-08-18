package academy.devdojo.springboot2.curso.util;

import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component // Indica que esta classe é um componente Spring gerenciado
public class DateUtil {

    // Método para formatar um LocalDateTime no estilo de banco de dados
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        // Cria um formato de data e hora específico
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Formata o LocalDateTime usando o formato especificado
        return formatter.format(localDateTime);
    }
}
