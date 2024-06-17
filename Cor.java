import java.awt.Color;

public enum Cor {
    VERMELHO(new Color(255, 0,0)),
    VERDE(new Color(0, 255,0)),
    AZUL(new Color(0, 0,255)),
    AMARELO(new Color(242, 255,0)),
    ROXO(new Color(110, 0,150)),
    PRETO(new Color(0,0,0)),
    BRANCO(new Color(255,255,255)),
    CINZA(new Color(60,65,70));

    public final Color color;

    Cor(Color color) {
        this.color = color;
    }
}