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
            System.out.println("1. Listar usuários");
            System.out.println("2. Inserir usuário");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Excluir usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarUsuarios(dao);
                    break;
                case 2:
                    inserirUsuario(scanner, dao);
                    break;
                case 3:
                    atualizarUsuario(scanner, dao);
                    break;
                case 4:
                    excluirUsuario(scanner, dao);
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

    private static void listarUsuarios(DAO dao) {
        try {
            List<Usuario> usuarios = dao.listar();
            for (Usuario usuario : usuarios) {
                System.out.println("Código: " + usuario.getCodigo());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println("Sexo: " + usuario.getSexo());
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar usuários.");
        }
    }

    private static void inserirUsuario(Scanner scanner, DAO dao) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        Usuario usuario = new Usuario(0, nome, senha, sexo);
        try {
            dao.inserir(usuario);
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir usuário.");
        }
    }

    private static void atualizarUsuario(Scanner scanner, DAO dao) {
        System.out.print("Código do usuário a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova senha: ");
        String senha = scanner.nextLine();
        System.out.print("Novo sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        Usuario usuario = new Usuario(codigo, nome, senha, sexo);
        try {
            dao.atualizar(usuario);
            System.out.println("Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar usuário.");
        }
    }

    private static void excluirUsuario(Scanner scanner, DAO dao) {
        System.out.print("Código do usuário a ser excluído: ");
        int codigo = scanner.nextInt();

        try {
            dao.excluir(codigo);
            System.out.println("Usuário excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir usuário.");
        }
    }
}