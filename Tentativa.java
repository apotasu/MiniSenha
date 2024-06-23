import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tentativa {
    private PinoColorido[] tentativa;
    private PinoDica[] dica;
    JButton button;

    public Tentativa(int tamanho) {
        tentativa = new PinoColorido[tamanho];
        dica = new PinoDica[tamanho];

        for (int i = 0; i < tamanho; i++) {
            tentativa[i] = new PinoColorido();
            dica[i] = new PinoDica();
        }
    }

    public PinoColorido[] getTentativa() {
        return tentativa;
    }
    public PinoDica[] getDica() {
        return dica;
    }
    public JPanel gerarPista(int numTentativas){
        JPanel panelPinos = new JPanel();
        panelPinos.setLayout(new FlowLayout());
        for (int i = 0; i < numTentativas ; i++) {
            PinoColorido pino = new PinoColorido();
            tentativa[i] = pino;
            JButton button = new JButton("⬤");
            button.addActionListener(event -> button.setForeground(pino.getNextColor()));
            button.setBackground(Cor.CINZA.color);
            panelPinos.add(button);
        }
        return panelPinos;
    }
    public Container gerarDica(int numTentativas){
        JPanel panelPinos = new JPanel();
        panelPinos.setLayout(new GridLayout(2,2));
        Container container = new Container();
        container.setLayout(new FlowLayout());
        for (int i = 0; i < numTentativas ; i++) {
            PinoDica pino = new PinoDica();
            dica[i] = pino;
            button = new JButton("●");
            button.setEnabled(false);
            button.setBackground(Cor.CINZA.color);
            panelPinos.add(button);
        }
        container.add(panelPinos);
        return container;
    }
    public JPanel verificarResultado(PinoColorido[] senha) {
        // Verificar se o jogador acertou a senha
        JPanel panelPinos = new JPanel();
        panelPinos.setLayout(new GridLayout());

        for (int i = 0; i < tentativa.length; i++) {
            boolean achou = false;
            if (tentativa[i].getColor() == senha[i].getColor()) {
                JLabel pinoAcerto = new JLabel("●");
                button.setBackground(Cor.CINZA.color);
                button.setForeground(Cor.PRETO.color);
                panelPinos.add(pinoAcerto);
                achou = true;
            } else {
                for (int j = 0; j < i; j++) {
                    if (tentativa[i].getColor() == senha[j].getColor()) {
                        JLabel pinoAcerto = new JLabel("●");
                        button.setBackground(Cor.CINZA.color);
                        button.setForeground(Cor.BRANCO.color);
                        panelPinos.add(pinoAcerto);
                        achou = true;
                        break;
                    }
                }
            }
            if (!achou){
                JLabel pinoAcerto = new JLabel("●");
                panelPinos.add(pinoAcerto);
            }
        }
        return panelPinos;
    }
}