
package model;


public class Tecnico implements java.io.Serializable{
    
    private int id;
    private String nome;
    private String especialidade;
    private String email;
    
    public Tecnico(){
        this.setId(0);
        this.setNome("Sem nome");
        this.setEspecialidade("Sem especialidade");
        this.setEmail("Sem email");
    }
    
    public Tecnico(int id, String nome, String especialidade, String email){
        this.setId(id);
        this.setNome(nome);
        this.setEspecialidade(especialidade);
        this.setEmail(email);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "Sem nome" : nome.toUpperCase();
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setEmail(String email) {
        this.email = email.trim().isEmpty() ? "Sem email" : email.toLowerCase();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Tecnico other = (Tecnico) obj;
        return this.id == other.id;
    }
    
}
