import javax.swing.*;
import java.awt.*;

public class Dica {
    private JPanel panelPinos;
    private Container retryPane;
    private MiniSenha miniSenha;
    private int count;
    
    public Dica(JFrame frame , PinoColorido[] pinos, PinoColorido[] senha, int tentativas) {
        count = tentativas;
        TentarDeNovo(frame,pinos,senha, tentativas);
    }

    

    public JPanel DicaPinos(JFrame frame, PinoColorido[] pinos, PinoColorido[] senha){
        retryPane = frame.getContentPane();
        frame.setTitle("Mini Senha");
        
        panelPinos = new JPanel();
        panelPinos.setLayout(new GridLayout(2,3));
        panelPinos.setBackground(Cor.CINZA.color);

        retryPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        retryPane.setBackground(new Color(60, 65, 70));
        for (int i = 0; i < senha.length; i++) {
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
            if (!achou || pinos[i]==null){
                JLabel pinoAcerto = new JLabel("●");
                panelPinos.add(pinoAcerto);
            }
        }
        return panelPinos;
}

    public void TentarDeNovo(JFrame frame, PinoColorido[] pinos, PinoColorido[] senha, int count){
        count--;
        //miniSenha = new MiniSenha(frame, false, count, count);
        //JLabel deNovo = new JLabel("Tentar de novo");
        Container retryContainer = frame.getContentPane();
        JButton retryButton = new JButton("De novo?");
        //retryButton.addActionListener(event -> miniSenha.JogoPrincipal(frame, this.count));
        retryContainer.add(DicaPinos(frame, pinos, senha));
        retryContainer.add(retryButton);
        //retryContainer.add(deNovo);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelPinos(){
        return panelPinos;
}
}