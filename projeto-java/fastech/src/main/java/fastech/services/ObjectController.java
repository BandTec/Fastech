
package fastech.services;

import fastech.controller.Controller;

/**
 *
 * @author igor
 */
public class ObjectController {
    private static Controller controller = new Controller();
    
    private ObjectController() {
        
    }
    
    public static Controller getController() {
        return controller;
    }
}
