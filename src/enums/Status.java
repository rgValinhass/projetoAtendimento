
package enums;


public enum Status {
    F("Finalizado"),
    P("Pendente"),
    A("Atrasado");
    
    private String descricao;
    
    private Status(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
