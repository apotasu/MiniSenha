import java.awt.Color;

public class Pino {

    private Cor cor;
    private Color color;

    public Pino(){
        color = new Color(0,0,0);
        cor = Cor.PRETO;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getCor(){
        return this.color;
    }


}
