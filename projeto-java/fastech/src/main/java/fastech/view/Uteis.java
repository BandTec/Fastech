package fastech.view;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Jose Lucas
 */
public class Uteis {

    public void insertIcon(JFrame form) {
        try {
            form.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/img/icon.png"));
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
