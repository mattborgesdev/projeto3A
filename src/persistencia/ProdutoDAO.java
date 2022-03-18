package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ProdutoDAO {
 
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Produto> leTodos() throws Exception{
    List<Produto> listProduto = new ArrayList<Produto>();
    try {
    String sql = "SELECT * FROM PRODUTO";
    connection = GerenteDeConexao.getConnection();
    st = connection.prepareStatement(sql);
    rs = st.executeQuery();
    while (rs.next()) {
     Produto p = new Produto();
     p.setCodBarra(rs.getString("codBarra"));
     p.setNome(rs.getString("nome"));
     p.setPreco(rs.getDouble("preco"));
     listProduto.add(p);
     }
    st.close();
    } catch (Exception e) {
     System.out.println(e.getMessage());
     }
     return listProduto;
     }

    public static Produto leUm(String codBarra) throws Exception {
     Produto produto = new Produto();
     try {
     String sql = "SELECT * FROM produto WHERE codBarra = ?";
     connection = GerenteDeConexao.getConnection();
     st = connection.prepareStatement(sql);
     st.setString(1, codBarra);
     rs = st.executeQuery();
     if (rs.next()) {
     produto.setCodBarra(rs.getString("codBarra"));
     produto.setNome(rs.getString("nome"));
     produto.setPreco(rs.getDouble("preco"));
     }
     st.close();
     } catch (SQLException e) {
     System.out.println(e.getMessage());
     }
     return produto;
     }
    public static int grava(Produto produto) throws Exception {
     int ret = 0;
     try {
     String sql = "INSERT INTO Produto (codBarra,nome,preco) VALUES (?, ?, ?)";
     connection = GerenteDeConexao.getConnection();
     st = connection.prepareStatement(sql);
     st.setString(1, produto.getCodBarra());
     st.setString(2, produto.getNome());
     st.setDouble(3, produto.getPreco());
     ret = st.executeUpdate();
     st.close();
     } catch (SQLException e) {
     System.out.println(e.getMessage());
     }
     return ret;
     }
    public static int altera(String codBarra, String nome, Double preco) throws Exception {
     int ret = 0;
     try {
     String sql = "UPDATE produto SET preco = ? WHERE codBarra = ?";
     connection = GerenteDeConexao.getConnection();
     st = connection.prepareStatement(sql);
     st.setString(1, codBarra);
     st.setString(2, nome);
     st.setDouble(3, preco);
     ret = st.executeUpdate();
     st.close();
     } catch (SQLException e) {
     System.out.println(e.getMessage());
     }
     return ret;
     }
    public static int exclui(String codBarra) throws Exception {
     int ret = 0;

     try {
     String sql = "DELETE FROM produto WHERE codBarra = ?";
     connection = GerenteDeConexao.getConnection();
     st = connection.prepareStatement(sql);
     st.setString(1, codBarra);
     ret = st.executeUpdate();
     st.close();
     } catch (SQLException e) {
     System.out.println(e.getMessage());
     }
     return ret;
     }    
}
