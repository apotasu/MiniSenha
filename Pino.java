import java.awt.Color;

public class Pino {

    private Cor cor;
    private Color color;

    public Pino(){
        color = new Color(0,0,0);
        cor = Cor.AMARELO;
    }
    public Color setProxCor(){
        switch (cor) {
            case PRETO:
                return color = new Color(242, 255,0);
            case AMARELO:
                return color = new Color(255, 0,0);
            case VERMELHO:
                return color = new Color(0, 0,255);
            case AZUL:
                return color = new Color(0, 255,0);
            case VERDE:
                return color = new Color(110, 0,150);
            case ROXO:
                return color = new Color(255, 0,0);
            default:
                return color = new Color(255, 0,0);
               
        }
    }
    public Color getCor(){
        return this.color;
    }
}
