package academy.devdojo.springboot2.curso.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.devdojo.springboot2.curso.domain.Anime;
import academy.devdojo.springboot2.curso.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.curso.requests.AnimePutRequestBody;

@Mapper(componentModel = "spring") // Indica que esta classe é um mapeador gerado pelo MapStruct
public abstract class AnimeMapper {
    // Obtém uma instância do mapeador usando o Factory Method de MapStruct
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    
    // Converte uma requisição AnimePostRequestBody em um objeto Anime
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    
    // Converte uma requisição AnimePutRequestBody em um objeto Anime
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
