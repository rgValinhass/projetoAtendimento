
package enums;


public enum Classificacao {
    C("Crítico"),
    U("Urgente"),
    N("Normal");
    
    private String descricao;
    
    private Classificacao(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
