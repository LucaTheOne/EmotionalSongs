
package emotionalsongs;

import java.awt.Graphics;

/**
 *@hidden
 * @author Megaport
 */
public abstract class Window implements RunnableAndClosable{
    
    public void changeWindow(Window finestraCorrente,Window finestraSuccessiva){
        finestraCorrente.closeWindow();
        finestraSuccessiva.runWindow();
    }

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

