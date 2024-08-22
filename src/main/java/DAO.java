import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/exercicio02";
    private static final String USER = "ti2cc";
    private static final String PASSWORD = "ti@cc";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do PostgreSQL não encontrado.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void inserir(Songs song) throws SQLException {
        String sql = "INSERT INTO songs (nome, artista, genero) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, song.getNome());
            stmt.setString(2, song.getArtista());
            stmt.setString(3, song.getGenero());
            stmt.executeUpdate();
        }
    }

    public List<Songs> listar() throws SQLException {
        List<Songs> songsList = new ArrayList<>();
        String sql = "SELECT * FROM songs";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Songs song = new Songs();
                song.setCodigo(rs.getInt("codigo"));
                song.setNome(rs.getString("nome"));
                song.setArtista(rs.getString("artista"));
                song.setGenero(rs.getString("genero"));
                songsList.add(song);
            }
        }
        return songsList;
    }

    public void atualizar(Songs song) throws SQLException {
        String sql = "UPDATE songs SET nome = ?, artista = ?, genero = ? WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, song.getNome());
            stmt.setString(2, song.getArtista());
            stmt.setString(3, song.getGenero());
            stmt.setInt(4, song.getCodigo());
            stmt.executeUpdate();
        }
    }

    public void excluir(int codigo) throws SQLException {
        String sql = "DELETE FROM songs WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }
}
