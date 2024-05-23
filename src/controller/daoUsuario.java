
package controller;

import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Usuario;


public class daoUsuario extends dao {
    
    public int create(Usuario usuario) throws SQLException {
        return super.executeUpdate("INSERT INTO USUARIO (NOME,EMAIL,SETOR) VALUES (?,?,?)", usuario.getNome(), usuario.getEmail(), usuario.getSetor());
    }
    
    public int update(Usuario usuario) throws SQLException{
        return super.executeUpdate("UPDATE USUARIO SET NOME = ?, EMAIL = ?, SETOR = ? WHERE ID = ?", usuario.getNome(), usuario.getEmail(), usuario.getSetor());
    }
    
    public int delete(Usuario usuario) throws SQLException{
        return super.executeUpdate("DELETE FROM USUARIO WHERE ID = " + usuario.getId());
    }
    
    public Usuario read(int id) throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM USUARIO WHERE ID = ?", id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Usuario> read() throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM USUARIO ORDER BY NOME");
        List<Usuario> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
    //Método que faz o mapeamento de um registro relacional em objeto
    private Usuario montaObjeto(ResultSet rs) throws SQLException{
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSetor(rs.getString("setor"));
        return usuario;
    }
}
