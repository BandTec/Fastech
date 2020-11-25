package fastech.model;

/**
 *
 * @author Jorge
 */
public class Component {

    private Integer idComponent;
    private String name;
    private Integer fkMachine;

    @Override
    public String toString() {
        return "Component{"
                + "idComponent=" + idComponent
                + ", name=" + name
                + ", fkMachine=" + fkMachine
                + '}';
    }

    public Integer getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(Integer idComponent) {
        this.idComponent = idComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

    public void setFkMachine(Integer fkMachine) {
        this.fkMachine = fkMachine;
    }
    
    

}
