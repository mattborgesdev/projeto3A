package testes.login;

import modelo.Login;
import persistencia.LoginDAO;
        
public class TestaLoginDAOgrava {

    public static void main(String[] args) throws Exception{
        
        Login login = new Login();
        login.setUsuario(7);
        login.setSenha(777);
        
        System.out.println(LoginDAO.grava(login));
    }
    
}