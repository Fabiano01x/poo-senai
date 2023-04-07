import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela manipulação dos dados da tabela produtos.
 * nela contém os métodos de inserção, exclusão, alteração e consulta de produtos no banco de dados.
 * **/
public class ProdutoDAO {


    /**
     * Método responsável por inserir um produto na tabela do bando de dados,
     * recebendo um objeto do tipo produto como parâmetro.
     * **/
    public static void inserirProduto(Produtos produtos) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("insert into produtos (PRO_COD, PROD_NOME, PROD_VALOR, PROD_QUANTIDADE, UNIDADE_UNI_COD) values (?, ?, ?, ?, ?)");
        ps.setInt(1, produtos.getProd_cod());
        ps.setString(2, produtos.getProd_nome());
        ps.setDouble(3, produtos.getProd_valor());
        ps.setDouble(4, produtos.getProd_quantidade());
        ps.setInt(5, produtos.getUni_cd());
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();
    }

    /**
     * Método cuja a função é excluir um produto do bando de dados recebendo como parâmetro
     * o código do produto a ser excluído.
     * **/
    public static void excluirProduto(Integer PRO_COD) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("delete from produtos where (PRO_COD = ?) ");
        ps.setInt(1, PRO_COD);
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();
    }

    /**
     * Método responsável pela atualização dos dados de um determinado produto, recebendo como parâmetro
     * o produto com os dados atualizados e o código do produto a ser alterado.
     * **/
    public static List<Produtos> updateProduto(Produtos p, Integer pro_cod) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("update produtos set PROD_NOME = ?, PROD_VALOR = ?, PROD_QUANTIDADE = ?, UNIDADE_UNI_COD = ? where (PRO_COD = ?)");
        ps.setString(1, p.getProd_nome());
        ps.setDouble(2, p.getProd_valor());
        ps.setDouble(3, p.getProd_quantidade());
        ps.setDouble(4, p.getProd_quantidade());
        ps.setInt(5, pro_cod);
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();

        return consulta();
    }

    /**
     * Método que faz a verificação no banco de dados retornando uma lista com todos os produtos armazenados no mesmo.
     * **/
    public static List<Produtos> consulta() throws SQLException {
        Conexao.getConnection();
        List<Produtos> list = new ArrayList<>();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("select * from produtos");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Produtos produtos = new Produtos(rs.getInt("PRO_COD"), rs.getString("PROD_NOME"), rs.getDouble("PROD_VALOR"), rs.getDouble("PROD_QUANTIDADE"), rs.getInt("UNIDADE_UNI_COD"));
            list.add(produtos);
        }
        return list;
    }
}
