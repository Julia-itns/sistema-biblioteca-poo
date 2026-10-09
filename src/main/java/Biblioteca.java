import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Material> materiais;

    public Biblioteca() {
        this.materiais = new ArrayList<>();
    }

    public void adicionarMaterial(Scanner scanner) throws CampoObrigatorioException {
        System.out.println("Digite o título do material:");
        String titulo = scanner.nextLine();
        if (titulo.isBlank()) {
            throw new CampoObrigatorioException("Por favor, preencha todos os campos obrigatórios.");
        }

        System.out.println("Digite o autor do material:");
        String autor = scanner.nextLine();
        if (autor.isBlank()) {
            throw new CampoObrigatorioException("Por favor, preencha todos os campos obrigatórios.");
        }

        System.out.println("Qual o tipo do material? \n1- Livro \n2- Revista");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            cadastrarLivro(scanner, titulo, autor);
        } else if (tipo == 2) {
            cadastrarRevista(scanner, titulo, autor);
        } else {
            throw new IllegalArgumentException("Tipo de material inválido");
        }
    }

    private void cadastrarLivro(Scanner scanner, String titulo, String autor) {
        System.out.println("Qual o gênero do livro?");
        System.out.println("1 - Romance \n2 - Ficção \n3 - Acadêmico");
        int opcaoGenero = scanner.nextInt();
        scanner.nextLine();

        Genero genero;
        if (opcaoGenero == 1){
            genero = Genero.ROMANCE;
        } else if (opcaoGenero == 2) {
            genero = Genero.FICCAO;
        } else if (opcaoGenero == 3) {
            genero = Genero.ACADEMICO;
        }else {
            throw new IllegalArgumentException("Gênero inválido");
        }

        Livro livro = new Livro(titulo, autor, genero);
        materiais.add(livro);
        System.out.println("Novo material cadastrado com sucesso!");
    }

    private void cadastrarRevista(Scanner scanner, String titulo, String autor) {
        System.out.println("Qual o número da revista?");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero <= 0) {
            throw new IllegalArgumentException("O número da revista deve ser maior que zero");
        }

        Revista revista = new Revista(titulo, autor, numero);
        materiais.add(revista);
        System.out.println("Novo material cadastrado com sucesso!");
    }

    public void listarMateriais() {
        if (materiais.isEmpty()) {
            System.out.println("Não há materiais cadastrados");
        } else {
            for (Material material : materiais) {
                System.out.println(material);
            }
        }
    }

    public void pesquisarMaterial(Scanner scanner) throws MaterialNaoEncontradoException {
        System.out.println("Digite o título procurado:");
        String tituloProcurado = scanner.nextLine();

        ArrayList<Material> encontrados = new ArrayList<>();

        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(tituloProcurado)) {
                encontrados.add(material);
            }
        }

        if (encontrados.isEmpty()) {
            throw new MaterialNaoEncontradoException("Material não encontrado");
        }

        System.out.println("Foram encontrado(s) " + encontrados.size() + " material(is):");
        for (Material material : encontrados) {
            System.out.println(material);
        }
    }

    public void excluirMaterial(Scanner scanner) throws MaterialNaoEncontradoException {
        System.out.println("Digite o título do material a excluir:");
        String tituloProcurado = scanner.nextLine();

        for (int i = 0; i < materiais.size(); i++) {
            if (materiais.get(i).getTitulo().equalsIgnoreCase(tituloProcurado)) {
                materiais.remove(i);
                System.out.println("Material excluído com sucesso!");
                return;
            }
        }

        throw new MaterialNaoEncontradoException("Material não encontrado");
    }
}