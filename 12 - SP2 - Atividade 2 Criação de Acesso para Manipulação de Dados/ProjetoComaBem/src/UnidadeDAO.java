import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela manipulação dos dados da tabela unidade.
 * nela contém os métodos de inserção, exclusão, alteração e consulta de unidade no banco de dados.
 * **/
public class UnidadeDAO {

    /**
     * Método responsável por inserir uma unidade na tabela do bando de dados,
     * recebendo um objeto do tipo unidade como parâmetro.
     * **/
    public static void inserirUnidade(Unidades unidade) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("insert into unidade (UNI_COD, UNI_MEDIDA) values (?, ?)");
        ps.setInt(1, unidade.getUni_cod());
        ps.setString(2, unidade.getUni_medida());
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();
    }

    /**
     * Método cuja a função é excluir uma unidade do bando de dados recebendo como parâmetro
     * o código da unidade a ser excluído.
     * **/
    public static void excluirUnidade(Integer uni_cod) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("delete from unidade where (UNI_COD = ?) ");
        ps.setInt(1, uni_cod);
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();
    }

    /**
     * Método responsável pela atualização dos dados de uma determinada unidade, recebendo como parâmetro
     * a unidade com os dados atualizados e o código da unidade a ser alterada.
     * **/
    public static List<Unidades> updateUnidade(Unidades u, Integer uni_cod) throws SQLException {
        Conexao.getConnection();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("update unidade set UNI_MEDIDA = ? where (UNI_COD = ?)");
        ps.setString(1, u.getUni_medida());
        ps.setInt(2, uni_cod);
        ps.executeUpdate();
        ps.close();
        Conexao.closeConnetion();

        return consulta();
    }

    /**
     * Método que faz a verificação no banco de dados retornando uma lista com todas as unidades armazenadas no mesmo.
     * **/
    public static List<Unidades> consulta() throws SQLException {
        Conexao.getConnection();
        List<Unidades> list = new ArrayList<>();
        PreparedStatement ps = Conexao.getConnection().prepareStatement("select * from unidade");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Unidades unidades = new Unidades(rs.getInt("UNI_COD"), rs.getString("UNI_MEDIDA"));
            list.add(unidades);
        }
        return list;
    }
}
