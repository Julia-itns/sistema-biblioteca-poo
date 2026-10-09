import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = 0;

        do {
            System.out.println("----------MENU----------");
            System.out.println("1 - Adicionar material");
            System.out.println("2 - Listar materiais");
            System.out.println("3 - Pesquisar material");
            System.out.println("4 - Excluir material");
            System.out.println("5 - Sair");
            System.out.println("Digite sua opção:");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        try {
                            biblioteca.adicionarMaterial(scanner);
                        } catch (CampoObrigatorioException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        biblioteca.listarMateriais();
                        break;
                    case 3:
                        try {
                            biblioteca.pesquisarMaterial(scanner);
                        } catch (MaterialNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            biblioteca.excluirMaterial(scanner);
                        } catch (MaterialNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tente novamente");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 5);

        scanner.close();
    }
}