package login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class GUILogin extends ClasseGenericaDeComponentes
{
    JFrame telaLogon; 
    JPanel painelPrincipal;
    JLabel tituloLoginPrincipal;
    JLabel login, nomeSenha;
    JLabel senha, nomeLogin;
    JLabel registrar;
    static JTextField digLogin;
    static JPasswordField digSenha;
    static String validar;
    JButton acessar;
    JButton cancelar;
    
    
    
    private void inicializarComponentes()
    {
        // frame principal de login e senha
        telaLogon = new JFrame("Iniciar Sessão");
        telaLogon.setSize(300, 380);
        telaLogon.setLocationRelativeTo(null);
        telaLogon.setResizable(false);
        telaLogon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaLogon.setLocationRelativeTo(null);
        telaLogon.setVisible(true);
        
        // painel principal da tela de login e senha
        painelPrincipal = new JPanel();
        painelPrincipal.setSize(450, 500);
        painelPrincipal.setLocation(5, 5);
        painelPrincipal.setBackground(new Color(64,68,111)); // RBG
        painelPrincipal.setLayout(null);
        
        
        // definindo os componentes
        tituloLoginPrincipal = new JLabel("Iniciar Sessão");
        login                = new JLabel("Login");
        senha                = new JLabel("Senha");
        nomeSenha            = new JLabel("Senha: bruno2020");
        nomeLogin            = new JLabel("Login: bruno@icon.interprise.com");
        digLogin             = new JTextField(30);
        digSenha             = new JPasswordField(12);
        acessar              = new JButton("Entrar");
        cancelar             = new JButton("Cancelar");
        registrar            = new JLabel("Registrar-se");
        
        // ajustando posição dos componentes
            
            // Título da tela
            tituloLoginPrincipal.setBounds(89, 20, 200, 90);
            tituloLoginPrincipal.setForeground(new Color(210,210,210));
            Font f = new Font("Corbel",Font.BOLD,20);
            tituloLoginPrincipal.setFont(f);
            
            // nome login          
            login.setBounds(35, 80, 200, 90);   // horizontal/vertical/largura/altura
            login.setForeground(Color.WHITE);
            Font fWork = new Font("Corbel",Font.BOLD,15);
            login.setFont(fWork);
                       
            // barra do login   
            digLogin.setBounds(35, 140, 225, 20);
            digLogin.setBorder(null);
            digLogin.setForeground(new Color(64,68,111));
            Font fWorkField = new Font("Arial",Font.ITALIC,13);
            digLogin.setFont(fWorkField);
            
            // nome senha
            senha.setBounds(35, 140, 200, 90);   // horizontal/vertical/largura/altura
            senha.setForeground(Color.WHITE);
            senha.setFont(fWork);
            
            // barra password
            digSenha.setBounds(35, 197, 225, 20);  // horizontal/vertical/largura/altura
            digSenha.setBorder(null);
            digSenha.setForeground(new Color(64,68,111));
            digSenha.setFont(fWorkField);

            // botão acessar
            acessar.setBounds(35, 240, 100, 34);   // horizontal/vertical/largura/altura
            acessar.setBorderPainted(false); // tirar a borda do botão
            Font fButton = new Font("Corbel",Font.BOLD,16);
            acessar.setFont(fButton);
            acessar.setBackground(new Color(207,207,207));
            acessar.setForeground(new Color(64,68,111));


            // botão cancelar
            cancelar.setBounds(160, 240, 100, 34);
            cancelar.setBorderPainted(false); // tirar a borda do botão
            cancelar.setFont(fButton);
            cancelar.setBackground(new Color(207,207,207));
            cancelar.setForeground(new Color(64,68,111));
            
            // Dicas de login e senha
            Font confLoginEsenha = new Font("Arial",Font.PLAIN,10);
            nomeSenha.setFont(confLoginEsenha);
            nomeSenha.setBounds(35, 305, 100, 34);
            nomeSenha.setForeground(Color.WHITE);
            nomeLogin.setBounds(35, 320, 200, 34);
            nomeLogin.setFont(confLoginEsenha);
            nomeLogin.setForeground(Color.WHITE);

            // Link registrar
            registrar.setFont(confLoginEsenha);
            registrar.setBounds(35, 270, 100, 34);
            registrar.setForeground(Color.WHITE);
            
            
            
        
        // adicionar componentes ao Panel
        painelPrincipal.add(tituloLoginPrincipal);
        painelPrincipal.add(login);
        painelPrincipal.add(senha);
        painelPrincipal.add(digLogin);
        painelPrincipal.add(digSenha);
        painelPrincipal.add(acessar);
        painelPrincipal.add(cancelar);
        painelPrincipal.add(nomeSenha);
        painelPrincipal.add(nomeLogin);
        painelPrincipal.add(registrar);
        
        // adcionar o componentes no JFRAME
        telaLogon.getContentPane().add(painelPrincipal);
        telaLogon.revalidate();
        telaLogon.repaint();
        
    }
    
    private void eventos()
    {
        // Estilização dos componentes
        
          // Estilização dos botões
          acessar.addMouseListener(new MouseAdapter(){
               
              @Override
              public void mouseEntered(MouseEvent me) // ao entrar com o mouse na area
              {
                  acessar.setBackground(new Color(174,174,174));
                  acessar.setForeground(Color.WHITE);                  
              }

              @Override
              public void mouseExited(MouseEvent me) // ao sair com o mouse da area
              {
                  acessar.setBackground(new Color(207,207,207));
                  acessar.setForeground(new Color(64,68,111));
              }         
          });
                  
          cancelar.addMouseListener(new MouseAdapter(){
               
              @Override
              public void mouseEntered(MouseEvent me) // ao entrar com o mouse na area
              {
                  cancelar.setBackground(new Color(174,174,174));
                  cancelar.setForeground(Color.WHITE);                  
              }

              @Override
              public void mouseExited(MouseEvent me) // ao sair com o mouse da area
              {
                  cancelar.setBackground(new Color(207,207,207));
                  cancelar.setForeground(new Color(64,68,111));
              }         
          });      
                  
          
          // Estilização das barras
         digLogin.addMouseListener(new MouseAdapter(){
         
              
             public void mouseEntered(MouseEvent me){
                 digLogin.setBackground(new Color(241,239,245));
                 digLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
             }
             
              
             public void mouseExited(MouseEvent me){
                 digLogin.setBackground(Color.WHITE);
             }
         
         
         });
                    
          
         digSenha.addMouseListener(new MouseAdapter(){
               
              @Override
              public void mouseEntered(MouseEvent me) // ao entrar com o mouse na area
              {
                  digSenha.setBackground(new Color(241,239,245));
                   
                                  
              }

              @Override
              public void mouseExited(MouseEvent me) // ao sair com o mouse da area
              {
                  digSenha.setBackground(Color.WHITE);
                   
              }         
              
          }); 
          
          
          
        // Processamento dos dados
        
            // Eventos dos botões acessar
            acessar.addActionListener(new ActionListener(){
                        
              @Override
              public void actionPerformed(ActionEvent ae) 
              {
                  String validaLogin = digLogin.getText();
                  String validaPass  = digSenha.getText();
                  if(digSenha.getText().equals("") || digLogin.getText().equals(""))
                  {
                  JOptionPane.showMessageDialog(null,"Não foi capturado nenhum dado de entrada!\nFavor digitar os dados.","Iniciar sessão",JOptionPane.INFORMATION_MESSAGE);
                 
                  }else{
                  GUILogin.validar(validaLogin,validaPass);  // validando em variável de classe
                  }
                  
              }
            
            });
            acessar.addKeyListener(new KeyListener(){
              @Override
              public void keyTyped(KeyEvent ke) {
                  acessar.setBackground(new Color(174,174,174));
                  acessar.setForeground(Color.WHITE);
              
              }

              @Override
              public void keyPressed(KeyEvent ke) {
                  String validaLogin = digLogin.getText();
                  String validaPass  = digSenha.getText();
                  GUILogin.validar(validaLogin,validaPass);  // validando em variável de classe
              }

              @Override
              public void keyReleased(KeyEvent ke) {
                  acessar.setBackground(new Color(174,174,174));
                  acessar.setForeground(Color.WHITE); 
              
              }
            
            
            
            
            });
          
            
            // Botão cancelar
            cancelar.addActionListener(new ActionListener(){
                        
              @Override
              public void actionPerformed(ActionEvent ae) 
              {
                  // opção de cancelar a tela
                   Object[] opcoes = {"Sim","Não"};
                   int escolha = JOptionPane.showOptionDialog(null, "Deseja encerrar sessão?", "Sair",0, JOptionPane.CLOSED_OPTION, null, opcoes, opcoes[0]);
                   if(opcoes[escolha].equals("Sim")){System.exit(0);}                    
              }
            
            });
            cancelar.addKeyListener(new KeyListener(){

              @Override
              public void keyTyped(KeyEvent e) {
                  
              }

              @Override
              public void keyPressed(KeyEvent e) {
                  // opção de cancelar a tela
                   Object[] opcoes = {"Sim","Não"};
                   int escolha = JOptionPane.showOptionDialog(null, "Deseja encerrar sessão?", "Sair",0, JOptionPane.CLOSED_OPTION, null, opcoes, opcoes[0]);
                   if(opcoes[escolha].equals("Sim")){System.exit(0);}
              }

              @Override
              public void keyReleased(KeyEvent e) {
                  
              }
            
            
            
            
            
            
            });
            
            // Link Registrar
            registrar.addMouseListener(new MouseListener(){
                
              @Override
              public void mouseClicked(MouseEvent me) {
                  Registro registro = new Registro();
                   
              }

              @Override
              public void mousePressed(MouseEvent me) {
                  
              }

              @Override
              public void mouseReleased(MouseEvent me) {
                  
              }

              @Override
              public void mouseEntered(MouseEvent me) {
                  // ao passar na label vira link e troca o cursos do mouse
                  registrar.setText("<html><u>Registrar-se</u>");
                  registrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
              }

              @Override
              public void mouseExited(MouseEvent me) {
                  //ao sair da label desativa o link e o cursor de link 
                  registrar.setText("Registrar-se");
                  registrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              }
            
                        
            
            });
            registrar.addKeyListener(new KeyListener(){

              @Override
              public void keyTyped(KeyEvent e) {
                  
              }

              @Override
              public void keyPressed(KeyEvent e) {
                  Registro registro = new Registro();
              }

              @Override
              public void keyReleased(KeyEvent e) {
                  
              }
            
            
            
            
            });
    }
    
    private static boolean validar(String validaLogin, String validaPass) 
    {
        // login: bruno@icon.interprise.com  pass: bruno2020
        if(validaLogin.equals("bruno@icon.interprise.com") && validaPass.equals("bruno2020"))
        {
            try{Thread.sleep(2010);}catch(InterruptedException u){}
            JOptionPane.showMessageDialog(null,"Altenticação avaliada com sucesso!\nCarregando...","Iniciar sessão",JOptionPane.INFORMATION_MESSAGE);
             return true;
        }else
        {
            try{Thread.sleep(1000);}catch(InterruptedException u){}
            JOptionPane.showMessageDialog(null,"Dados incorretos!","Iniciar sessão",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
    
    
    
    
    
    public GUILogin()
    {
        inicializarComponentes();
        eventos();
    }
}
