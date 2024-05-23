
package controller;

import java.util.LinkedList;
import model.Tecnico;    
   
import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class daoTecnico extends dao {
    
    public int create(Tecnico tecnico) throws SQLException {
        return super.executeUpdate("INSERT INTO TECNICO (NOME,ESPECIALIDADE,EMAIL) VALUES (?,?,?)", tecnico.getNome(), tecnico.getEmail(), tecnico.getEspecialidade());
    }
    
    public int update(Tecnico tecnico) throws SQLException{
        return super.executeUpdate("UPDATE TECNICO SET NOME = ?, ESPECIALIDADE = ?, EMAIL = ? WHERE ID = ?", tecnico.getNome(), tecnico.getEmail(), tecnico.getEspecialidade());
    }
    
    public int delete(Tecnico tecnico) throws SQLException{
        return super.executeUpdate("DELETE FROM TECNICO WHERE ID = " + tecnico.getId());
    }
    
    public Tecnico read(int id) throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM TECNICO WHERE ID = ?", id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Tecnico> read() throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM TECNICO ORDER BY NOME");
        List<Tecnico> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
    //Método que faz o mapeamento de um registro relacional em objeto
    private Tecnico montaObjeto(ResultSet rs) throws SQLException{
        Tecnico tecnico = new Tecnico();
        tecnico.setId(rs.getInt("id"));
        tecnico.setNome(rs.getString("nome"));
        tecnico.setEmail(rs.getString("email"));
        tecnico.setEspecialidade(rs.getString("especialidade"));
        return tecnico;
    }
}

