public class Usuario {
    private int codigo;
    private String nome;
    private String senha;
    private char sexo;

    public Usuario () {}

    public Usuario(int codigo, String nome, String senha, char sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.sexo = sexo;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
