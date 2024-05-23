package tests;

import cruds.crudChamado;
import java.sql.*;

public class testCrud {
    
    public static void main(String[] args){
        crudChamado crud = new crudChamado();
        
        try{
            /*crud.create("Computador não liga");
            crud.create("Teclado nao funciona");
            crud.create("Sem internet");
            crud.create("Monitor nao mostra nada");*/
            crud.create("Mouse nao funciona");
            ResultSet rs = crud.read();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("nome"));
            }
        }catch (SQLException ex){
            System.out.println("Erro " + ex.getMessage());
        }
    }
    
}
