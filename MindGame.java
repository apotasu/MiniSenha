import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MindGame {
    private Config config;
    private Pino[] senha;
    private PinoColorido[] pinos;

    public MindGame(JFrame frame) {
        //this.senha = new Pino[6];
        JogoPrincipal(frame);
    }

    public void setSenha(Pino[] senha) {
        this.senha = senha;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return this.config;
    }

    public Pino[] getSenha() {
        return this.senha;
    }

    public boolean verificarResultado(Pino[] pinos) {
        // Verificar se o jogador acertou a senha
        for (int i = 0; i < 6; i++) {
            if (pinos[i].getCor() != senha[i].getCor()) {
                return false;
            }
        }
        return true;
    }

    public void JogoPrincipal(JFrame frame){
        pinos = new PinoColorido[6];
        Container contentPane = frame.getContentPane();

        contentPane.removeAll();
        contentPane.setLayout(new GridLayout(5, 1));
        for (int i = 0; i<=3; i++){
            PinoColorido pino = new PinoColorido();
            pinos[i] = pino;
            JButton button = new JButton("⬤");
            button.addActionListener(event -> button.setForeground(pino.getNextColor()));
            button.setBackground(new Color(60, 65, 70));
            contentPane.add(button);
        }
        JButton Verificar = new JButton("Chutar!");
        Verificar.addActionListener(event -> new Resultados());
        //Verificar.addActionListener(event -> actionPerformed(event));
        Verificar.setBackground(new Color(150,150,150));

        contentPane.add(Verificar);
        //frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

}