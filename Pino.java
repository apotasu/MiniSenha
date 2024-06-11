import java.awt.Color;

public class Pino {

    private Cor cor;
    private Color color;

    public Pino(){
        color = new Color(0,0,0);
        cor = Cor.AMARELO;
    }
    public void setProxCor(){
        switch (cor) {
            case PRETO:
                color = new Color(242, 255,0);
                cor = Cor.AMARELO;
                break;
            case AMARELO:
                color = new Color(255, 0,0);
                cor = Cor.VERMELHO;
                break;
            case VERMELHO:
                color = new Color(0, 0,255);
                cor = Cor.AZUL;
                break;
            case AZUL:
                color = new Color(0, 255,0);
                cor = Cor.VERDE;
                break;
            case VERDE:
                color = new Color(110, 0,150);
                cor = Cor.ROXO;
                break;
            case ROXO:
                color = new Color(255, 0,0);
                cor = Cor.VERMELHO;
                break;
            default:
                color = new Color(255, 0,0);
                cor = Cor.VERMELHO;               
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getCor(){
        return this.color;
    }

    public Color getNextColor(){
        setProxCor();
        return this.color;
    }
}
