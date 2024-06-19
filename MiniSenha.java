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

public class MiniSenha {
    private Config config;
    private PinoColorido[] senha;
    private PinoColorido[] pinos;
    private boolean modoTeste;
    private int QuantidadePinos;
    private int count;
    private int tentativas;
    private JButton deNovo;
    private JLabel numTentativas;
    private JPanel panelPinos;
    private Container retryPane;

    public MiniSenha(JFrame frame, boolean teste, int quantidade, int tentativas) {
        this.modoTeste = teste;
        this.QuantidadePinos = quantidade;
        this.senha = new PinoColorido[quantidade];
        this.config = new Config(true, frame);
        this.count = tentativas;
        this.tentativas = count;
        if (config.getNumJogadores()) {
            gerarSenha();
            JogoPrincipal(frame);
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
                TentarDeNovo(frame);
                return;
            }
        }
        resultado.ResultadoVitoria();
    }

    public void TentarDeNovo(JFrame frame){
        count--;
        retryPane = frame.getContentPane();
        frame.setTitle("Mini Senha");
        
        panelPinos = new JPanel();
        panelPinos.setLayout(new GridLayout(2,3));
        panelPinos.setBackground(Cor.CINZA.color);

        retryPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        retryPane.setBackground(new Color(60, 65, 70));
        for (int i = 0; i < QuantidadePinos; i++) {
            boolean achou = false;
            if (pinos[i].getCor() == senha[i].getCor()) {
                JLabel pinoAcerto = new JLabel("●");
                pinoAcerto.setBackground(Cor.CINZA.color);
                pinoAcerto.setForeground(Cor.PRETO.color);
                panelPinos.add(pinoAcerto);
                achou = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (pinos[i].getCor() == senha[j].getCor()) {
                        JLabel pinoAcerto = new JLabel("●");
                        pinoAcerto.setBackground(Cor.CINZA.color);
                        pinoAcerto.setForeground(Cor.BRANCO.color);
                        panelPinos.add(pinoAcerto);
                        achou = true;
                        break;
                    }
                }
            }
            if (!achou){
                JLabel pinoAcerto = new JLabel("●");
                pinoAcerto.setBackground(new Color(60, 65, 70));
                panelPinos.add(pinoAcerto);
            }
        }
        deNovo = new JButton("De novo?");
        deNovo.addActionListener(event -> JogoPrincipal(frame));
        numTentativas = new JLabel("Tentativas restantes: " + count);
        retryPane.add(panelPinos);
        retryPane.add(numTentativas);
        retryPane.add(deNovo);
        
        frame.pack();
        frame.setVisible(true);
    }

    public void JogoPrincipal(JFrame frame){
        pinos = new PinoColorido[6];
        JPanel contentPane = new JPanel();
        JPanel dicaPanel = new JPanel();
        Container container = frame.getContentPane();
        
        
        if(count == tentativas){
            container.removeAll();
            dicaPanel.setLayout(new GridLayout(2,3));
            for (int i = 0; i < QuantidadePinos; i++) {
                PinoColorido pino = new PinoColorido();
                pinos[i] = pino;
                JLabel dot = new JLabel("●");
                dicaPanel.add(dot);
            }
        }else{
            if (count == tentativas-1){
                //se removeAll(), ele atualiza a dica, mas tambem atualiza as cores, se não, ele não atualiza nenhum dos dois
                container.removeAll();
                
                /*container.remove(dicaPanel);
                container.remove(deNovo);
                container.remove(numTentativas);
                */
            }
            
            //container.add(dicaPanel);   
            container.remove(deNovo);
            container.remove(numTentativas);
            //container.add(aux);
            container.add(panelPinos);
         }

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
            

            if (count < tentativas){
                contentPane.add(panelPinos);
                dicaPanel.setVisible(false);
            }
            
            contentPane.add(dicaPanel);
            contentPane.add(Verificar);
            container.add(contentPane);
            frame.pack();
            frame.setVisible(true);

    }
}
