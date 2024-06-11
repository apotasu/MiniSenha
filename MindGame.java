public class MindGame {
    private Config config;
    private Pino[] senha;

    public MindGame(Config config) {
        this.config = config;
        this.senha = new Pino[6];
        for (int i = 0; i < config.getTamanhoSenha(); i++) {
            this.senha[i] = new Pino(config.getNumeroCores());
        }
    }
}
