
package controller;

import abstratas.dao;
import enums.Classificacao;
import enums.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Atendimento;


public class daoAtendimento extends dao {
    public int create(Atendimento atendimento) throws SQLException {
        String SQL = "INSERT INTO ATENDIMENTO (data, id_usuario, id_tecnico, id_chamado, classificacao, status, descricao) VALUES(?,?,?,?,?,?,?)";
        return super.executeUpdate(SQL, atendimento.getData(), atendimento.getUsuario().getId(), atendimento.getTecnico().getId(), atendimento.getChamado().getId(), atendimento.getClassificacao().name(), atendimento.getStatus().name(), atendimento.getDescricao());
    }
    
    public int update(Atendimento atendimento) throws SQLException {
        String SQL = "UPDATE ATENDIMENTO SET data = ?, id_usuario = ?, id_tecnico = ?, id_chamado = ?, classificacao = ?, status = ?, descricao = ? WHERE ID = ?";
        return super.executeUpdate(SQL, atendimento.getData(), atendimento.getUsuario().getId(), atendimento.getTecnico().getId(), atendimento.getChamado().getId(), atendimento.getClassificacao().name(), atendimento.getStatus().name(), atendimento.getDescricao(), atendimento.getId());
    }
    
    public int delete(Atendimento atendimento) throws SQLException {
        return super.executeUpdate("DELETE FROM ATENDIMENTO WHERE ID = " + atendimento.getId());
    }
    
    public Atendimento read(int id) throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM ATENDIMENTO WHERE ID = ?", id);
        return (!rs.next() ? null : montaObjeto(rs));
    }
    
    public List<Atendimento> read() throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM ATENDIMENTO ORDER BY DATA");
        List<Atendimento> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
     private Atendimento montaObjeto(ResultSet rs) throws SQLException {
        Atendimento atendimento = new Atendimento();
        atendimento.setId(rs.getInt("id"));
        atendimento.setData(rs.getDate("data").toLocalDate());
        atendimento.setUsuario(new daoUsuario().read(rs.getInt("id_usuario")));
        atendimento.setTecnico(new daoTecnico().read(rs.getInt("id_tecnico")));
        atendimento.setChamado(new daoChamado().read(rs.getInt("id_chamado")));
        atendimento.setClassificacao(Classificacao.valueOf(rs.getString("classificacao")));
        atendimento.setStatus(Status.valueOf(rs.getString("status")));
        atendimento.setDescricao(rs.getString("descricao"));
        return atendimento;
    }
}
