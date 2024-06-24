import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu{
    PinoColorido[] pinos;
    private Config config;
    
    public Menu(){
        config = new Config();
        MainMenu();
    }
    
    public void MainMenu(){
        JFrame Menu = new JFrame("Menu");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Container contentPane = Menu.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        BufferedImage Titulo;
        try {
            Titulo = ImageIO.read(new File("title.png"));
            JLabel tituloLabel = new JLabel(new ImageIcon(Titulo));
            contentPane.add(tituloLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JLabel mindGame = new JLabel("");
        contentPane.add(mindGame, gbc);
        JButton jogador1Button = new JButton("Começar");
        jogador1Button.setBackground(Cor.CINZA.color);
        jogador1Button.setForeground(Cor.BRANCO.color);
        jogador1Button.addActionListener(event ->  Configuracoes(Menu));

        contentPane.add(jogador1Button, gbc);
        
        contentPane.setBackground(Cor.CINZA.color);
        Menu.pack();
        Menu.setSize(520,360);
        Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);

        gbc.weighty = 1;
        
    }
    public void Configuracoes(JFrame frame){
        frame.setName("Configurações");
        Container container = frame.getContentPane();
        container.removeAll();
        container.setLayout(new FlowLayout());
        

        JTextField quantidadePinos = new JTextField(10);
        JTextField numTentativas = new JTextField(10);
        JButton iniciar = new JButton("Iniciar");
        JButton modoTeste = new JButton("Modo teste");
        iniciar.addActionListener(event -> config.setNumTentativas(Integer.parseInt(numTentativas.getText())));
        iniciar.addActionListener(event -> config.setQuantidadePinos(Integer.parseInt(quantidadePinos.getText())));
        iniciar.addActionListener(event -> JogoPrincipal(frame,Integer.parseInt(numTentativas.getText())));

        modoTeste.addActionListener(event -> config.setModoTeste(true));

        container.add(quantidadePinos);
        container.add(numTentativas);
        container.add(iniciar);
        container.add(modoTeste);

        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void JogoPrincipal(JFrame frame, int e){
        config.gerarSenha(e);
        Container container = frame.getContentPane();
        container.removeAll();
        container.setLayout(new FlowLayout());
        
        Tentativa tentativa = new Tentativa(e);
        System.out.println(config.getNumTentativas());
        container.add(tentativa.gerarPista(e));

        JButton verificar = new JButton("Verificar");
        verificar.setBackground(Cor.CINZA.color);
        verificar.setForeground(Cor.BRANCO.color);
        verificar.addActionListener(event ->  deNovo(frame, e, tentativa.getTentativa()));
        //verificar.addActionListener(event -> );
        //verificar.addActionListener(event -> container.add(tentativa.verificarResultado(config.getSenha())));
        
        container.add(tentativa.gerarDica(e));
        container.add(verificar);
        container.setBackground(Cor.CINZA.color);
        
        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void deNovo(JFrame frame, int e, PinoColorido[] arrayPinos){
        Container container = frame.getContentPane();
        
        Tentativa tentativa = new Tentativa(e);
        
        container.add(tentativa.verificarResultado(arrayPinos));
        container.setBackground(Cor.CINZA.color);
        
        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}