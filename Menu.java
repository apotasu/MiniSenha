import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu{
    PinoColorido[] pinos;
    
    public Menu(){
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JLabel mindGame = new JLabel("");
        contentPane.add(mindGame, gbc);
        JButton jogador1Button = new JButton("1 jogador");
        jogador1Button.setBackground(new Color(60,65,70));
        jogador1Button.setForeground(new Color(225, 225, 225));
        jogador1Button.addActionListener(event ->  new Config(false, Menu));

        contentPane.add(jogador1Button, gbc);
        
        JButton jogador2Button = new JButton("2 jogadores");
        jogador2Button.setBackground(new Color(60,65,70));
        jogador2Button.setForeground(new Color(225, 225, 225));
        jogador2Button.addActionListener(event ->  new Config(true, Menu));

        contentPane.add(jogador2Button, gbc);
        
        contentPane.setBackground(new Color(60, 65, 70));
        Menu.pack();
        Menu.setSize(520,360);
        Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);

        gbc.weighty = 1;
        
    }
}