import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {
    String nome;
    double data, telefone;

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario (ID INTEGER PRIMARY KEY, Nome VARCHAR, Telefone DOUBLE, Data DOUBLE)");
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirFuncionario(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionario (Nome, Telefone, Data) VALUES (?, ?, ?)")) {
            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setDouble(2, Double.parseDouble(s[1]));
                insertStatement.setDouble(3, Double.parseDouble(s[2]));
                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Funcionario: " + e.getMessage());
        }
    }

    public void lerFuncionario() {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario WHERE Nome = ? ")) {
            selectStatement.setString(1, Cadastro.caralho3);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println(resultSet.toString());
            while (resultSet.next()) {
                String name = resultSet.getString("Nome");
                Double fone = resultSet.getDouble("Telefone");
                Double data = resultSet.getDouble("Data");
                if (Cadastro.caralho3.equals(name)) {
                    System.out.println("O Funcionario selecionado é:" +name +"," +fone + ","+ data);
                }else{
                    System.out.println("Funcionario invalido!");}
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deleteFuncionario() {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario WHERE Nome = ?")) {
            deleteStatement.setString(1, nome);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Funcionario deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }}
