import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    String name, nomeFun;
    static String caralho, caralho2, caralho3, caralho4;
    int quanto;
    double valor, data,telefone;
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
        List<String[]> listaPlmdsFunciona = new ArrayList<>();
        listaPlmdsFunciona.add(new String[]{name, Integer.toString(quanto), Double.toString(valor)});

        produto.inserirProdutos(listaPlmdsFunciona);
        bancoDeDados.close();
    }

    void lerProduto(){
        bancoDeDados.connect();
        System.out.println("Claro, por favor digite o nome do produto que deseja ler: ");
        caralho = scanner.nextLine();
        produtos.lerProduto();
        bancoDeDados.close();
    }
    void deletarProduto(){
        bancoDeDados.connect();
        System.out.println("Digite qual produto quer excluir :");
        caralho2 = scanner.nextLine();
        produtos.nome = caralho2;
        produtos.deleteProduto();
        bancoDeDados.close();
    }

    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();
        scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Funcionario: ");
        nomeFun = scanner.nextLine();
        System.out.println("Nome do funcionario salvo");
        System.out.println("Digite o telefone de contato do funcionario:");
        telefone = scanner.nextDouble();
        System.out.println("Telefone do funcionario salvo");
        System.out.println("Digite a data de contratação do funcionario:");
        data = scanner.nextDouble();
        List<String[]> listaPlmdsFunciona2 = new ArrayList<>();
        listaPlmdsFunciona2.add(new String[]{nomeFun, Double.toString(telefone), Double.toString(data)});
        funcionarios.inserirFuncionario(listaPlmdsFunciona2);
        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();
        System.out.println("Claro, por favor digite o nome do Funcionario que deseja ler: ");
        caralho3 = scanner.nextLine();
        funcionarios.lerFuncionario();
        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();
        System.out.println("Digite qual Funcionario quer excluir :");
        caralho4 = scanner.nextLine();
        funcionarios.nome = caralho4;
        funcionarios.deleteFuncionario();
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
