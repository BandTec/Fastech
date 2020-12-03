package fastech.services;

import fastech.model.GlobalVars;

/**
 *
 * @author Igor
 */
public class ObjectGlobalVars {
    private static GlobalVars globalVars = new GlobalVars();
    
    private ObjectGlobalVars() {
        
    }
    
    public static GlobalVars getGlobalVars() {
        return globalVars;
    }
}
