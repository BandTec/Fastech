package fastech.model;

/**
 *
 * @author Jorge
 */
public class GlobalVars {
    private Integer fkCompany;
    private Integer fkMachine;
    private Integer fkComponent;

    public GlobalVars(Integer fkCompany, Integer fkMachine, Integer fkComponent) {
        this.fkCompany = fkCompany;
        this.fkMachine = fkMachine;
        this.fkComponent = fkComponent;
    }

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

    public Integer getFkComponent() {
        return fkComponent;
    }

    public void setFkComponent(Integer fkComponent) {
        this.fkComponent = fkComponent;
    }
    
    
}
