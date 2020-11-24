package fastech.view;

import fastech.controller.Controller;

/**
 *
 * @author Jorge 
 */
public class Views {
    public static void main(String[] args) {
        Controller c = new Controller();
        
        c.login("leila.sousa@bandtec.com.br", "12345");
        
        c.insertCpu();
    }
}
