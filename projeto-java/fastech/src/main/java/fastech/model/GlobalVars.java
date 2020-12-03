package fastech.model;

import java.util.List;

/**
 *
 * @author Jorge
 */
public class GlobalVars {
    private Integer fkCompany;
    private Integer fkMachine;
    private List<Component> fkComponent;    

    public Integer getFkCompany() {
        return fkCompany;
    }

    public void setFkCompany(Integer fkCompany) {
        this.fkCompany = fkCompany;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

    public void setFkMachine(Integer fkMachine) {
        this.fkMachine = fkMachine;
    }

    public List<Component> getFkComponent() {
        return fkComponent;
    }

    public void setFkComponent(List<Component> fkComponent) {
        this.fkComponent = fkComponent;
    } 

  

}
