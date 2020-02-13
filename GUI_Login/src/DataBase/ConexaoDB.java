package DataBase;


    /* SOBRE O PROGRAMA
       Classe responsável gerenciar conexão e serviços de banco de dados.
    */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoDB 
{
    
    private Connection conecta;
    // atributos para inserção de dados
    private String name;
    private String user;
    private String pass;
    private String confirmPass;
    
    public boolean conexao() throws ClassNotFoundException{
        
        try{
        Class.forName("org.sqlite.JDBC");
        String caminho = "jdbc:sqlite:src/DataBase/usuarios.db";
        this.conecta = DriverManager.getConnection(caminho);
        System.out.println("Conexão com sucesso!");
        return true;
        }catch(SQLException e){
            System.out.println("Falha na conexão com SQLite!" + e.getMessage());
            return false;
        }
        
        
        
    }
    
    
    
    public Statement manipulacao(String sql){
        try{
            // prepareStatement entra dentro do banco e solta o códido passado como parâmetro
            return this.conecta.createStatement();
        }catch(SQLException err){
            return (PreparedStatement) err;
        }
    }
    
     
    public PreparedStatement manipulacaoStatement(String sql){
        try{
            // prepareStatement entra dentro do banco e solta o códido passado como parâmetro
            return this.conecta.prepareStatement(sql);
        }catch(SQLException err){
            return (PreparedStatement) err;
        }
    }
    
    
    
    
    
    
    public Connection getConection(){
        return this.conecta;
    }
    
    
    // INSERT TO DB

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

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
    
    
    public boolean desconectar() throws SQLException{
        try{
            this.conecta.close();
            if(this.conecta.isClosed()==true){
                System.out.println("Banco desconectado!");
                return true;
            }
        }catch(SQLException e){
            if(this.conecta.isClosed()==false){
                System.out.println("Erro em desconectar ao banco!");
                return false;
            }
        }
        return false;
    }
    
    
    
}
