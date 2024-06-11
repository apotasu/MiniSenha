public class Config {
    private int numTentativas;
    private int numMaximoTentativas = 10;

    private int numJogadores;

    public Config(int numJogadores) {
        this.numJogadores = 1;
        this.numTentativas = 8;
    }

    public void setNumTentativas(int numTentativas) throws IllegalArgumentException{
        if(numTentativas < 1 || numTentativas > numMaximoTentativas) {
            throw new IllegalArgumentException("Número de tentativas inválido");
        }
        this.numTentativas = numTentativas;
    }
}
