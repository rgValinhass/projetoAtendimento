
package cruds;
import abstratas.Dados;
import java.sql.*;

public class crudChamado {
    
    public int create(String nome) throws SQLException{
        String SQL = "INSERT INTO CHAMADO (NOME) VALUES(?)";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        return pst.executeUpdate();
    }
    
    public int update(int id, String nome) throws SQLException{
        String SQL = "UPDATE CHAMADO SET NOME = ? WHERE ID = ?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        pst.setInt(2, id);
        return pst.executeUpdate();
    }
    
    public int delete (int id) throws SQLException{
        String SQL = "DELETE FROM CHAMADO WHERE ID = ?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt(1, id);
        return pst.executeUpdate();
    }
    
    public ResultSet read(int id) throws SQLException{
        String SQL = "SELECT * FROM CHAMADO WHERE ID = ?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    
    public ResultSet read() throws SQLException {
        String SQL = "SELECT * FROM CHAMADO ORDER BY NOME";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        return pst.executeQuery();
    }
}
