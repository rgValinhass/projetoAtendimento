
package controller;

import abstratas.dao;
import java.sql.SQLException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Chamado;


public class daoChamado extends dao {
    
    public int create(Chamado chamado) throws SQLException {
        return super.executeUpdate("INSERT INTO CHAMADO (NOME) VALUES (?) ", chamado.getNome());
    }
    
    public int update (Chamado chamado) throws SQLException{
        return super.executeUpdate("UPDATE CHAMADO SET NOME = ? WHERE ID = ?", chamado.getNome());
    }
    
    public int delete(Chamado chamado) throws SQLException{
        return super.executeUpdate("DELETE FROM CHAMADO WHERE ID = " + chamado.getId());
    }
    
    public Chamado read(int id) throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM CHAMADO WHERE ID = ?", id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Chamado> read() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM CHAMADO ORDER BY NOME");
        List<Chamado> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
    private Chamado montaObjeto(ResultSet rs) throws SQLException{
        Chamado chamado = new Chamado();
        chamado.setId(rs.getInt("id"));
        chamado.setNome(rs.getString("nome"));
        return chamado;
    }
    
}
