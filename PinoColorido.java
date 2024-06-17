import java.awt.Color;

public class PinoColorido {
    private Cor color;

    public PinoColorido(){
        color = Cor.PRETO;
    }
    public void setProxCor(){
        switch (color) {
            case PRETO:
                color = Cor.AMARELO;
                break;
            case AMARELO:
                color = Cor.VERMELHO;
                break;
            case VERMELHO:
                color = Cor.AZUL;
                break;
            case AZUL:
                color = Cor.VERDE;
                break;
            case VERDE:
                color = Cor.ROXO;
                break;
            case ROXO:
                color = Cor.PRETO;
                break;
            default:
                color = Cor.PRETO;
        }
    }

    public Color getNextColor(){
        setProxCor();
        return this.color.color;
    }

    public Cor getCor(){
        return this.color;
    }

    //For testing purrpurses ;33
    public void setCor(Cor core){
        this.color = core;
    }

}