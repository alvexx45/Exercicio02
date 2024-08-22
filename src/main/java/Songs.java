public class Songs {
    private int codigo;
    private String nome;
    private String artista;
    private String genero;

    // Construtor padrão
    public Songs() {}

    // Construtor parametrizado
    public Songs(int codigo, String nome, String artista, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", artista='" + artista + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
