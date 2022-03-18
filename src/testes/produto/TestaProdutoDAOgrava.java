package testes.produto;

import modelo.Produto;
import persistencia.ProdutoDAO;

public class TestaProdutoDAOgrava {
    
    public static void main(String[] args) throws Exception {
        
        Produto produto = new Produto();
        produto.setCodBarra("14785");
        produto.setNome("Balinha");
        produto.setPreco(0.10);
        
        System.out.println(ProdutoDAO.grava(produto));
    }
    
}
