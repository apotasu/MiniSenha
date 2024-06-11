public class MindGame {
    private Config config;
    private Pino[] senha;

    public MindGame() {
        this.config = new Config(1);
        this.senha = new Pino[6];
    }

    public void setSenha(Pino[] senha) {
        this.senha = senha;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return this.config;
    }

    public Pino[] getSenha() {
        return this.senha;
    }

    public boolean verificarResultado(Pino[] pinos) {
        // Verificar se o jogador acertou a senha
        for (int i = 0; i < 6; i++) {
            if (pinos[i].getCor() != senha[i].getCor()) {
                return false;
            }
        }
        return true;
    }
}
