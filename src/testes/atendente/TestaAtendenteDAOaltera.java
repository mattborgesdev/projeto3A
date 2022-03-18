package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOaltera {

    public static void main(String[] args) throws Exception{
        
        System.out.println(AtendenteDAO.altera("Joaquina",10));
    }
    
}
