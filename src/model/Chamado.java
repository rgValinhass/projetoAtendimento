
package model;


public class Chamado implements java.io.Serializable{
    
    private int id;
    private String nome;
    
    public Chamado(){
        this.setId(0);
        this.setNome("Sem nome");
    }
    
    public Chamado(int id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome.trim().isEmpty() ? "Nome vazio" : nome.toUpperCase();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Chamado other = (Chamado) obj;
        return this.id == other.id;
    }
    
}
