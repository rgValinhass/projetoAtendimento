
package model;

import enums.Classificacao;
import enums.Status;
import java.time.LocalDate;


public class Atendimento implements java.io.Serializable{
    
    private int id;
    private LocalDate data;
    private Usuario usuario;
    private Tecnico tecnico;
    private Chamado chamado;
    private Classificacao classificacao;
    private Status status;
    private String descricao;

    public Atendimento() {
        this.setId(0);
        this.setData(null);
        this.setUsuario(null);
        this.setTecnico(null);
        this.setChamado(null);
        this.setClassificacao(Classificacao.N);
        this.setStatus(Status.P);
        this.setDescricao("");
    }

    public Atendimento(int id, LocalDate data, Usuario usuario, Tecnico tecnico, Chamado chamado, Classificacao classificacao, Status status, String descricao) {
        this.setId(id);
        this.setData(data);
        this.setUsuario(usuario);
        this.setTecnico(tecnico);
        this.setChamado(chamado);
        this.setClassificacao(classificacao);
        this.setStatus(status);
        this.setDescricao(descricao);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data == null ? LocalDate.now() : data;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario == null ? new Usuario() : usuario;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico == null ? new Tecnico() : tecnico;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado == null ? new Chamado() : chamado;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty() ? "DESCRIÇÃO" : descricao.toUpperCase();
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public Chamado getChamado() {
        return this.chamado;
    }

    public Classificacao getClassificacao() {
        return this.classificacao;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() { 
        return "Atendimento: "+usuario+ " Técnico: "+tecnico+" Problema: "+descricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        return this.id == other.id;
    }
    
    
}
