package fastech.model;

import java.util.List;

/**
 *
 * @author Jorge
 */
public class GlobalVars {
    private Integer fkCompany;
    private Machine machine;
    private List<Component> fkComponent;
    private List<Types> listTypes;

    public Integer getFkCompany() {
        return fkCompany;
    }

    public void setFkCompany(Integer fkCompany) {
        this.fkCompany = fkCompany;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<Component> getFkComponent() {
        return fkComponent;
    }

    public void setFkComponent(List<Component> fkComponent) {
        this.fkComponent = fkComponent;
    } 

    public List<Types> getListTypes() {
        return listTypes;
    }

    public void setListTypes(List<Types> listTypes) {
        this.listTypes = listTypes;
    }


}
