package DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


    /* SOBRE O PROGRAMA
       
    */

public class Insert 
{
    private String name;
    private String user;
    private String pass;
    private String confirm_pass;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }
    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }
    
    
    public void insertIn() throws SQLException{
        String sql = "INSERT INTO usuarios.user("
                + "name"
                + "user"
                + "pass"
                + "confirm_pass)"
                + "VALUES(?,?,?,?);";
        
        ConexaoDB conn = new ConexaoDB();
        PreparedStatement preparedStatement = conn.manipulacaoStatement(sql);
    
    
        try{
            preparedStatement.setString(1, conn.getName());
            preparedStatement.setString(2, conn.getName());
            preparedStatement.setString(3, conn.getName());
            preparedStatement.setString(4, conn.getName());
            int res = preparedStatement.executeUpdate();
            
            if(res==1){
                System.out.println("Dados inseridos com sucesso!");
            }else{
                System.out.println("Falha ao inserir os dados!");
            }
            
        }catch(SQLException err){
            System.out.println("Falha ao inserir os dados!(catch)");
        }finally{
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conn.desconectar();
        }
    
    
    
    
    }
    
    
    
    
    
}
