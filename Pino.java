public class Pino {
    protected Cor color;
    public Pino(){
        setColor(Cor.CINZA);
    }
    public Cor getColor(){
        return this.color;
    }

    //For testing purrpurses ;33
    public void setColor(Cor core){
        this.color = core;
    }
}
