package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// importar classes do banco de dados
import DataBase.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataBase.Insert;


    /* SOBRE O PROGRAMA
       
    */

public class Registro extends ClasseGenericaDeComponentes
{
    
    

    // frame principal
    private void inicializarComponentes(){
        
        telaPrincipalRegistro = new JFrame("Registrar-se");
        telaPrincipalRegistro.setSize(401, 250); // largura / altura
        telaPrincipalRegistro.setLocationRelativeTo(null);
        telaPrincipalRegistro.setResizable(false);
        telaPrincipalRegistro.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Cancela fechar com "X"
        telaPrincipalRegistro.setLocationRelativeTo(null);
        telaPrincipalRegistro.setVisible(true);
        
        painelPrincipalRegistro = new JPanel();
        painelPrincipalRegistro.setSize(400, 250);
        painelPrincipalRegistro.setLocation(5, 5);
        painelPrincipalRegistro.setBackground(new Color(219,222,247)); // RBG
        painelPrincipalRegistro.setLayout(null);
        painelPrincipalRegistro.setVisible(true);
        
        //definindo os componentes...
            
            
            
            //título da tela...
            cadastroTitulo = new JLabel("<html><b>CADASTRO DE USUÁRIO</b>");
            Font cadTitulo = new Font("Arial",Font.ITALIC,15);
            cadastroTitulo.setFont(cadTitulo);
            cadastroTitulo.setBounds(100, -170, 200, 400);  //horizontal, vertical, altura, largura
            
            
            
            // texto nome...
            nomeCadastro = new JLabel("Nome:");
            Font fWork = new Font("Corbel",Font.BOLD,15);
            nomeCadastro.setFont(fWork);
            nomeCadastro.setBounds(9, 25, 100, 100);  //horizontal, vertical, altura, largura
            
            
            
            // barra nome...
           
            barraNomeRegistro = new JTextField(40);
            barraNomeRegistro.setBounds(160, 61, 225, 20);  //horizontal, vertical, altura, largura
            
            
            
            // texto login...
            nomeLoginCadastro = new JLabel("Novo Usuário:");
            nomeLoginCadastro.setBounds(9,83,230,40);  //horizontal, vertical, altura, largura
            nomeLoginCadastro.setFont(fWork);
            
            
            
            // barra login...
            barraLoginRegistro = new JTextField(20);
            barraLoginRegistro.setBounds(160, 89, 225, 20);  //horizontal, vertical, altura, largura
            
            
            
            // texto senha...
            nomeSenhaCadastro = new JLabel("Senha: ");
            nomeSenhaCadastro.setFont(fWork);
            nomeSenhaCadastro.setBounds(9, 80, 100, 100); //horizontal, vertical, altura, largura
            
            
            
            // barra senha...
            barraSenhaRegistro = new JPasswordField(40);
            barraSenhaRegistro.setBounds(160, 117, 225, 20);  //horizontal, vertical, altura, largura
            
            
            // texto confirmação de senha...
            nomeConfirmacaoSenha = new JLabel("Confirmação de senha:");
            nomeConfirmacaoSenha.setBounds(9, 148, 225, 20);  //horizontal, vertical, altura, largura
            nomeConfirmacaoSenha.setFont(fWork);
            
            
            //barra de confirmação de senha...
            barraConfirmaSenha = new JPasswordField(40);
            barraConfirmaSenha.setBounds(160, 145, 225, 20);   //horizontal, vertical, altura, largura
            
            
            // botão gravar...
            gravarRegistro = new JButton("Gravar");
            gravarRegistro.setBounds(9, 180, 130, 30);
            
            
            
            // botão cancelar...
            cancelarRegistro = new JButton("Cancelar");
            cancelarRegistro.setBounds(150, 180, 130, 30);
            
            
            
            
            
        
        // adicionando jpanel no jframe...
        telaPrincipalRegistro.getContentPane().add(painelPrincipalRegistro);
        telaPrincipalRegistro.revalidate();
        telaPrincipalRegistro.repaint();
        
        painelPrincipalRegistro.add(cadastroTitulo);
        painelPrincipalRegistro.add(nomeCadastro);
        painelPrincipalRegistro.add(barraNomeRegistro);
        painelPrincipalRegistro.add(nomeLoginCadastro);
        painelPrincipalRegistro.add(barraLoginRegistro);
        painelPrincipalRegistro.add(barraSenhaRegistro);
        painelPrincipalRegistro.add(barraConfirmaSenha);
        painelPrincipalRegistro.add(nomeSenhaCadastro);
        painelPrincipalRegistro.add(nomeConfirmacaoSenha);
        painelPrincipalRegistro.add(gravarRegistro);
          painelPrincipalRegistro.add(cancelarRegistro);
        
    }
    
    private void iniciarEventos()
    {
        
        // botão cancelar...
        cancelarRegistro.addActionListener(new ActionListener(){
                        
              @Override
              public void actionPerformed(ActionEvent ae) 
              {
                  // opção de cancelar a tela
                   Object[] opcoes = {"Sim","Não"};
                   int escolha = JOptionPane.showOptionDialog(null, "Deseja sair do registro?", "Sair",0, JOptionPane.CLOSED_OPTION, null, opcoes, opcoes[0]);
                   if(opcoes[escolha].equals("Sim")){
                       telaPrincipalRegistro.setVisible(false);
                   }              
              }
            
            });
        
        
        gravarRegistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
               Insert in = new Insert();
                try {
                    in.insertIn();
                } catch (SQLException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
                    
        
        
        
        });
        
        
        
    }
    
    
    
    
    
    
    
    
    //Construtor...
    public Registro(){
        inicializarComponentes();
        iniciarEventos();
        
    }
}