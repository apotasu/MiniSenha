import java.util.Random;

public class Config {
    private int numTentativas;
    private int QuantidadePinos;
    private boolean modoTeste;
    private PinoColorido []senha;

    public Config(){
    }
    public int getNumTentativas(){
        return numTentativas;
    }
    public void setNumTentativas(int e){
        if (e<=0){
            throw new IllegalArgumentException();
        }
        //System.out.println(e);
        this.numTentativas = e; 
        System.out.println(this.numTentativas);
    }
    public int getQuantidadePinos(){
        return QuantidadePinos;
    }
    public void setQuantidadePinos(int e){
        if (e<=0){
            throw new IllegalArgumentException();
        } else {
        this.QuantidadePinos = e;
        }
    }
    public boolean getModoTeste(){
        return modoTeste;
    }
    public void setModoTeste(boolean e){
        this.modoTeste = e;
    }
    public void gerarSenha(int e) {
        Random random = new Random();
        senha = new PinoColorido[e];
        for (int i = 0; i < e; i++) {
            senha[i] = new PinoColorido();
            for (int j = 0; j <= random.nextInt(10); j++) {
                senha[i].setProxCor();
            }
        }
        System.out.println("Senha gerada:");
        for (int i = 0; i < e; i++) {
            System.out.println(senha[i].getColor());
        }
    }
    public PinoColorido[] getSenha(){
        return this.senha;
    }
}
