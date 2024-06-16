import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Resultados {
    private JFrame frame;
    public Resultados(JFrame frameOriginal){
        this.frame = frameOriginal;
    }

    public void ResultadoVitoria(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container resultPane = frame.getContentPane();
        resultPane.removeAll();
        resultPane.setLayout(new GridBagLayout());
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("Trofeu.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            resultPane.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultPane.setBackground(new Color(60, 65, 70));
        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    
    public void ResultadoDerrota(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container resultPane = frame.getContentPane();
        resultPane.removeAll();
        resultPane.setLayout(new GridBagLayout());
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("Derrota.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            resultPane.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }        
        resultPane.setBackground(new Color(60, 65, 70));
        frame.pack();
        frame.setSize(520,360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
