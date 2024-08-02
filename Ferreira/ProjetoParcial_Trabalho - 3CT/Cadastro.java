import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    String name;
    static String caralho;
    int quanto;
    double valor;
    Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();


    void adicionarProduto(){
        bancoDeDados.connect();
        produtos.createTable();
        scanner = new Scanner(System.in);
        Produtos produto = new Produtos();
        System.out.println("Digite o nome do produto: ");
        name = scanner.nextLine();
        System.out.println("Nome do produto salvo");
        System.out.println("Digite a quatidade que deseja adicionar desse produto:");
        quanto = scanner.nextInt();
        System.out.println("Quantidade do produto salva");
        System.out.println("Digite o preço do produto:");
        valor = scanner.nextDouble();
        List<String> lista = new ArrayList<>();
        produto.inserirProdutos();
        bancoDeDados.close();
    }

    void lerProduto(){
        bancoDeDados.connect();
        System.out.println("Claro, por favor digite o nome do produto que deseja ler: ");
        caralho = scanner.nextLine();
        produtos.lerProduto();
        System.out.println("FOI!");
        bancoDeDados.close();
    }
    void deletarProduto(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }

    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();

        //Insira seu código aqui

        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }

    void imprimirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar funcionário");
        System.out.println("6- Deletar funcionário");
        System.out.println("7- Sair");
    }
}
