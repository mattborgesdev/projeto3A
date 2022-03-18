package testes.login;

import persistencia.LoginDAO;
        
public class TestaLoginDAOaltera {

    public static void main(String[] args) throws Exception{
        
        System.out.println(LoginDAO.altera(777,7));
    }
    
}
