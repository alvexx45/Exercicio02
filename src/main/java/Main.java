import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar músicas");
            System.out.println("2. Inserir música");
            System.out.println("3. Atualizar música");
            System.out.println("4. Excluir música");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarMusicas(dao);
                    break;
                case 2:
                    inserirMusica(scanner, dao);
                    break;
                case 3:
                    atualizarMusica(scanner, dao);
                    break;
                case 4:
                    excluirMusica(scanner, dao);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void listarMusicas(DAO dao) {
        try {
            List<Songs> songs = dao.listar();
            for (Songs song : songs) {
                System.out.println("Código: " + song.getCodigo());
                System.out.println("Nome: " + song.getNome());
                System.out.println("Artista: " + song.getArtista());
                System.out.println("Gênero: " + song.getGenero());
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar músicas.");
        }
    }

    private static void inserirMusica(Scanner scanner, DAO dao) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        Songs song = new Songs(0, nome, artista, genero);
        try {
            dao.inserir(song);
            System.out.println("Música inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir música.");
        }
    }

    private static void atualizarMusica(Scanner scanner, DAO dao) {
        System.out.print("Código da música a ser atualizada: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova artista: ");
        String artista = scanner.nextLine();
        System.out.print("Novo gênero: ");
        String genero = scanner.nextLine();

        Songs song = new Songs(codigo, nome, artista, genero);
        try {
            dao.atualizar(song);
            System.out.println("Música atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar música.");
        }
    }

    private static void excluirMusica(Scanner scanner, DAO dao) {
        System.out.print("Código da música a ser excluída: ");
        int codigo = scanner.nextInt();

        try {
            dao.excluir(codigo);
            System.out.println("Música excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir música.");
        }
    }
}
