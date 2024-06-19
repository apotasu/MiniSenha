import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Random;

public class MiniSenha  {
    private Config config;
    private PinoColorido[] senha;
    private PinoColorido[] pinos;
    private boolean modoTeste;
    private int QuantidadePinos;
    private int count;
    private int tentativas;
    private Dica dica;

    public MiniSenha(JFrame frame, boolean teste, int quantidade, int tentativas) {
        this.modoTeste = teste;
        this.QuantidadePinos = quantidade;
        this.senha = new PinoColorido[quantidade];
        this.config = new Config(true, frame);
        this.count = tentativas;
        this.tentativas = count;
        if (config.getNumJogadores()) {
            gerarSenha();
            JogoPrincipal(frame, count);
        }
    }

    private void gerarSenha() {
        Random random = new Random();
        for (int i = 0; i < QuantidadePinos; i++) {
            this.senha[i] = new PinoColorido();
            for (int j = 0; j <= random.nextInt(10); j++) {
                this.senha[i].setProxCor();
            }
        }
        System.out.println("Senha gerada:");
        for (int i = 0; i < QuantidadePinos; i++) {
            System.out.println(this.senha[i].getCor());
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
        for (int i = 0; i < QuantidadePinos; i++) {
            if (pinos[i].getCor() != senha[i].getCor()) {
                if (count == 0) {
                    resultado.ResultadoDerrota();
                    return;
                }
                dica = new Dica(frame, pinos, senha, tentativas);
                return;
            }
        }
        resultado.ResultadoVitoria();
    }

    public void JogoPrincipal(JFrame frame, int count){
        pinos = new PinoColorido[count];
        JPanel contentPane = new JPanel();
        Container container = frame.getContentPane();
        container.removeAll();

        contentPane.setLayout(new FlowLayout());
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        if (modoTeste) {
            JFrame modotesteJFrame = new JFrame("Resultado");
            Container senhaPane = modotesteJFrame.getContentPane();
            senhaPane.setLayout(new FlowLayout());
            JLabel senhaLabel = new JLabel("A senha é:" + getSenha()[0].getCor());
            senhaPane.add(senhaLabel);
            for (int i = 1; i < QuantidadePinos; i++) {
                JLabel senhaRestante = new JLabel("" + getSenha()[i].getCor());
                senhaPane.add(senhaRestante);
            }
            modotesteJFrame.pack();
            modotesteJFrame.setVisible(true);
        }
        
        for (int i = 0; i < QuantidadePinos; i++) {
            PinoColorido pino = new PinoColorido();
            pinos[i] = pino;
            JButton button = new JButton("⬤");
            button.addActionListener(event -> button.setForeground(pino.getNextColor()));
            button.setBackground(new Color(60, 65, 70));
            contentPane.add(button);
        }
        
            JButton Verificar = new JButton("Chutar!");
            Verificar.addActionListener(event -> verificarResultado(pinos, frame));
            Verificar.setBackground(new Color(150, 150, 150));
            //contentPane.add(dica.DicaPinos(frame, pinos, senha));
            contentPane.add(Verificar);
            container.add(contentPane);
            frame.pack();
            frame.setVisible(true);

    }
}
