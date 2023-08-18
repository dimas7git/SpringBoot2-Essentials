package academy.devdojo.springboot2.curso.domain;

public class Anime {
    private String name;

    // Construtor que recebe o nome do anime como parâmetro
    public Anime(String name) {
        this.name = name;
    }

    // Construtor vazio (default)
    public Anime() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
