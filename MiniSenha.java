import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;


public class MiniSenha {
    private Config config;
    private PinoColorido[] senha;
    private PinoColorido[] pinos;
    private boolean modoTeste;
    private int QuantidadePinos;

    public MiniSenha(JFrame frame, boolean teste, int quantidade) {
        this.modoTeste = teste;
        this.QuantidadePinos = quantidade;
        this.senha = new PinoColorido[quantidade];
        this.config = new Config(1, frame);

        if(config.getNumJogadores() == 1)
            gerarSenha();
        JogoPrincipal(frame);
    }

    private void gerarSenha() {
        Random random = new Random();
        for (int i = 0; i <= 3; i++) {
            this.senha[i] = new PinoColorido();
            for(int j = 0; j <= random.nextInt(10); j++){
                this.senha[i].setProxCor();
            }
        }
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
        boolean acertou = true;
        for (int i = 0; i < QuantidadePinos; i++) {
            if (pinos[i].getCor() != senha[i].getCor()) {
                acertou = false;
                break;
            }
        }
        if(acertou){
            resultado.ResultadoVitoria();
        } else {
            resultado.ResultadoDerrota();
        }
        
    }

    public void JogoPrincipal(JFrame frame){
        pinos = new PinoColorido[6];
        Container contentPane = frame.getContentPane();

        contentPane.removeAll();
        contentPane.setLayout(new GridLayout(5, 1));
        for (int i = 0; i<QuantidadePinos; i++){
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