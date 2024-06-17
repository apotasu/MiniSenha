import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Config {
    private int numTentativas;
    private int numMaximoTentativas = 10;
    private boolean numJogadores;

    public Config(boolean jogador, JFrame frame) {
        this.numJogadores = jogador;
        //??
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        Container configPane = frame.getContentPane();
        configPane.removeAll();
        configPane.setLayout(new GridBagLayout());
        configPane.setBackground(new Color(60, 65, 70));
        
        

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("titleTentativa.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        configPane.add(picLabel,gbc);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JTextField Tentativas = new JTextField(10);
        Tentativas.setForeground(new Color(225, 225, 225));
        Tentativas.setBackground(new Color(60, 65, 70));
        configPane.add(Tentativas,gbc);

        BufferedImage QuantPinosImg;
        try {
            QuantPinosImg = ImageIO.read(new File("QuantidadePinos.png"));
            JLabel picLabel = new JLabel(new ImageIcon(QuantPinosImg));
            configPane.add(picLabel,gbc);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JTextField QuantPinos = new JTextField(2);
        QuantPinos.setForeground(new Color(225, 225, 225));
        QuantPinos.setBackground(new Color(60, 65, 70));
        configPane.add(QuantPinos, gbc);
        
        JButton ConfigOk = new JButton("Começar Jogo");
        ConfigOk.addActionListener(event -> new MiniSenha(frame, false, Integer.parseInt(QuantPinos.getText()), Integer.parseInt(Tentativas.getText())));
        ConfigOk.setForeground(new Color(225, 225, 225));
        ConfigOk.setBackground(new Color(60, 65, 70));
        configPane.add(ConfigOk,gbc);
        
        JButton TesteButton = new JButton("Modo Teste");
        TesteButton.addActionListener(event -> new MiniSenha(frame, true, Integer.parseInt(QuantPinos.getText()), Integer.parseInt(Tentativas.getText())));
        TesteButton.setForeground(new Color(225, 225, 225));
        TesteButton.setBackground(new Color(60, 65, 70));
        configPane.add(TesteButton,gbc);

        if (jogador == true){
            int count = 0;
            PinoColorido[] pino = new PinoColorido[Integer.parseInt(QuantPinos.getText())];
            JLabel senhaLabel = new JLabel("Digite a senha:");
            senhaLabel.setForeground(new Color(225, 225, 225));
            senhaLabel.setBackground(new Color(60, 65, 70));
            configPane.add(senhaLabel,gbc);

            JButton azul = new JButton("AZUL");
            azul.addActionListener(event -> pino[count].setCor(Cor.AZUL));
        }

        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gbc.weighty = 1;
    }

    public void setNumTentativas(int numTentativas) throws IllegalArgumentException{
        if(numTentativas < 1 || numTentativas > numMaximoTentativas) {
            throw new IllegalArgumentException("Número de tentativas inválido");
            
        }
        this.numTentativas = numTentativas;
    }

    public boolean getNumJogadores() {
        return this.numJogadores;
    }
}
