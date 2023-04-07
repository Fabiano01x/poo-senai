import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {



        // Instânciação de um novo produto para ser testado conforme os métodos a seguir
        Produtos produtos = new Produtos(6, "Feijão", 20.00, 2.0, 1);


        // Consulta
        //System.out.println(ProdutoDAO.consulta().toString());

        // Inserir Produto

        //ProdutoDAO.inserirProduto(produtos);

        // Excluir Produto
        //ProdutoDAO.excluirProduto(6);

        // Alterar Produto
        //System.out.println(ProdutoDAO.updateProduto(produtos, 6));


        // Instânciação de uma nova medida para ser testada conforme os métodos a seguir
        Unidades u = new Unidades(5, "Kilometro");

        // Alterar Unidade
        //System.out.println(UnidadeDAO.updateUnidade(u, 5));

        // Excluir Unidade
        UnidadeDAO.excluirUnidade(5);

        // Consultar Unidade
        UnidadeDAO.consulta();

        // Inserir Unidade
        //UnidadeDAO.inserirUnidade(u);
    }

}
