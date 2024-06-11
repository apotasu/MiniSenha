import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu{
    private JFrame Menu;
    private JFrame Config;
    private JFrame Jogo;
    private JTextField Senha;
    private JTextField Tentativa;
    
    public void ConfigMenu() throws IOException{
        Config = new JFrame("Configurações");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        Config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container configPane = Config.getContentPane();
        configPane.setLayout(new GridBagLayout());
        configPane.setBackground(new Color(60, 65, 70));
        
        BufferedImage myPicture = ImageIO.read(new File("titleTentativa.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        configPane.add(picLabel,gbc);
        Tentativa = new JTextField(2);
        Tentativa.setForeground(new Color(225, 225, 225));
        Tentativa.setBackground(new Color(60, 65, 70));
        configPane.add(Tentativa,gbc);

        
        JButton ConfigOk = new JButton("Começar");
        ConfigOk.addActionListener(event -> JogoPrincipal());
        ConfigOk.setForeground(new Color(225, 225, 225));
        ConfigOk.setBackground(new Color(60, 65, 70));
        configPane.add(ConfigOk,gbc);

        Config.pack();
        Config.setSize(520,360);
        Config.setLocationRelativeTo(null);
        Config.setVisible(true);
        gbc.weighty = 1;
    }

    public void MainMenu() throws IOException{
        Menu = new JFrame("Menu");

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        Container contentPane = Menu.getContentPane();
        contentPane.setLayout((new GridBagLayout()));
        BufferedImage myPicture = ImageIO.read(new File("title.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        contentPane.add(picLabel);

        JLabel mindGame = new JLabel("");
        contentPane.add(mindGame,gbc);
        JButton jogador1Button = new JButton("Jogador 1");
        jogador1Button.setBackground(new Color(60,65,70));
        jogador1Button.setForeground(new Color(225, 225, 225));
        jogador1Button.addActionListener(event -> {
            try {
                ConfigMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contentPane.add(jogador1Button,gbc);

        JButton jogador2Button = new JButton("Jogador 2");
        jogador2Button.setBackground(new Color(60,65,70));
        jogador2Button.setForeground(new Color(225, 225, 225));
        jogador2Button.addActionListener(event -> {
            try {
                ConfigMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contentPane.add(jogador2Button,gbc);

        contentPane.setBackground(new Color(60, 65, 70));
        Menu.pack();
        Menu.setSize(520,360);
        Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);

        gbc.weighty = 1;
        
    }
    public void JogoPrincipal(){
        Pino pino = new Pino();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(60, 65, 70));

        JPanel panel = new JPanel(new GridLayout(7, 1));
        for (int i = 0; i<=5; i++){
            JButton button = new JButton("⬤");
            button.addActionListener(event -> button.setForeground(pino.setProxCor()));
            button.setBackground(new Color(60, 65, 70));
            panel.add(button);
        }
        JButton Verificar = new JButton("Chutar!");
        Verificar.addActionListener(event -> ResultadoVitoria());
        Verificar.setBackground(new Color(150,150,150));

        panel.add(Verificar);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void ResultadoVitoria(){
        JFrame resultFrame = new JFrame("Vitoria!");
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel resultPane = new JPanel(new FlowLayout());
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("Trofeu.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            resultPane.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultPane.setBackground(new Color(60, 65, 70));
        resultFrame.add(resultPane);
        resultFrame.pack();
        resultFrame.setSize(520,360);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }

    public void ResultadoDerrota(){
        JFrame resultFrame = new JFrame("Perdeu!");
        JLabel vitoriaLabel = new JLabel("Você Perdeu! \n Parabens!");
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vitoriaLabel.setHorizontalAlignment(JLabel.CENTER);
        resultFrame.add(vitoriaLabel);
        // Emoji triste
        resultFrame.pack();
        resultFrame.setSize(520,360);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }
}