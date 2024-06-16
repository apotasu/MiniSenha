import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MindGame {
    private Config config;
    private PinoColorido[] senha;
    private PinoColorido[] pinos;

    public MindGame(JFrame frame) {
        this.senha = new PinoColorido[6];
        //Pino[] senha = new Pino[6];
        for (int i = 0; i<=3 ; i++){
            PinoColorido pino = new PinoColorido();
            pino.setCor(Cor.AMARELO);
            senha[i]=pino;
        }
        JogoPrincipal(frame);
    }

    public void setSenha(PinoColorido[] senha) {
        this.senha = senha;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return this.config;
    }

    public PinoColorido[] getSenha() {
        return this.senha;
    }

    public void verificarResultado(PinoColorido[] pinos, JFrame frame) {
        Resultados resultado = new Resultados(frame);
        // Verificar se o jogador acertou a senha
        for (int i = 0; i <= 3; i++) {
            if (pinos[i].getCor() != senha[i].getCor()) {
                resultado.ResultadoDerrota();;
            }
        }
        resultado.ResultadoVitoria();
        
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
        Verificar.addActionListener(event -> verificarResultado(pinos, frame));
        //Verificar.addActionListener(event -> actionPerformed(event));
        Verificar.setBackground(new Color(150,150,150));

        contentPane.add(Verificar);
        //frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
    }
}