import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;

public class Produtos {
    int quantidade;
    String nome;
    double preco;

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS produtos (ID INTEGER PRIMARY KEY, Nome VARCHAR, Quantidade INTEGER, Preco DOUBLE)");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirProdutos(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO produtos (Nome, Quantidade, Preco) VALUES(?, ?, ?)")) {
            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.setDouble(3, Double.parseDouble(s[2]));
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void lerProduto() {
        System.out.println("FOI1!");
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM produtos WHERE Nome = ?")) {
            System.out.println("plmds");
            selectStatement.setString(1, Cadastro.caralho);
            System.out.println("plmds2");
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("plmds3");
            System.out.println(resultSet.toString());
            while (resultSet.next()) {
                System.out.println("FOI2!");
                String name = resultSet.getString("Nome");
                Integer quanto = resultSet.getInt("Quantidade");
                Double valor = resultSet.getDouble("Preco");
                System.out.println("FOI3!");
                if (Cadastro.caralho.equals(name)) {
                System.out.println("O produto selecionado é:" +name+quanto+valor);
            }else{
                System.out.println("Produto invalido!");}
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }

    public void deleteProduto(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto... //Insira seu código aqui")) {

            //Insira seu código aqui

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produtos: " + e.getMessage());

        }
    }
}
