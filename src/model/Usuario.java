//id nome email setor
package model;


public class Usuario implements java.io.Serializable{
    
    private int id;
    private String nome;
    private String email;
    private String setor;
    
    public Usuario(){
        this.setId(0);
        this.setNome("Sem Nome");
        this.setEmail("");
        this.setSetor("Sem Setor");
    }
    
    public Usuario(int id, String nome, String email, String setor){
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSetor(setor);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "Sem nome" : nome.toUpperCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void setSetor(String setor) {
        this.setor = setor.trim().isEmpty() ? "Sem Setor" : setor.toUpperCase();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSetor() {
        return this.setor;
    }

    @Override
    public String toString() {
        return this.nome + " / " + this.setor + " / " + this.email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }
    
    
}
