package testes.produto;

import persistencia.ProdutoDAO;

public class TestaProdutoDAOaltera {

    public static void main(String[] args) throws Exception{
        
        System.out.println(ProdutoDAO.altera("12345","Cafézinho",7.50));
    }
    
}
