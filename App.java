import java.io.IOException;

import javax.swing.SwingUtilities;

public class App {
    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Menu jogo = new Menu();
                try {
                    jogo.MainMenu();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    });
}
}