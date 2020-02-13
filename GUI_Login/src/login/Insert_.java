package login;

import DataBase.ConexaoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class Insert_ {
    
    private String name;
    private String user;
    private String pass;
    private String confirmPass;
    
    Registro registro = new Registro();

    public String getNome() {
        return name;
    }
    public void setNome(String name) {
        this.name = name;
    }

    
    public String getUsuario() {
        return user;
    }
    public void setUsuario(String user) {
        this.user = user;
    }

    
    public String getSenha() {
        return pass;
    }
    public void setSenha(String pass) {
        this.pass = pass;
    }

    
    public String getConfirmaSenha() {
        return confirmPass;
    }
    public void setConfirmaSenha(String confirmPass) {
        this.confirmPass = confirmPass;
    }
        
    Connection conn = null;
    
    private Connection connect() throws ClassNotFoundException{
        
        //Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:src/DataBase/usuarios.db";
        
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException err){
            System.out.println("Erro na conexão com SQL! " + err.getMessage());
        }
        return conn;
    }
    
    public void inserir(String name,String user,String pass,String confirmPass) throws ClassNotFoundException{
           
        String sql = "INSERT INTO user(name,user,pass,confirm_pass)"
                + "VALUES"
                + "(?,?,?,?);";
        
        try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, sql);
            pstmt.setString(2, sql);
            pstmt.setString(3, sql);
            pstmt.setString(4, sql);
        }catch(SQLException erro){
            System.out.println("Erro em inserir os dados!"+erro.getMessage());
        }
            
    }
    
    public boolean desconectar() throws SQLException{
        try{
            this.conn.close();
            if(this.conn.isClosed()==true){
                System.out.println("Banco desconectado!");
                return true;
            }
        }catch(SQLException e){
            if(this.conn.isClosed()==false){
                System.out.println("Erro em desconectar ao banco!");
                return false;
            }
        }
        return false;
    }
}
