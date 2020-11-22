package fastech.model;

/**
 *
 * @author Jorge
 */
public class Test {

    private Integer idTest;
    private String dtMoment;
    private Integer value;
    private Integer component_idComponent;
    private Integer Component_fkMachine;

    @Override
    public String toString() {
        return "Test{" + "idTest=" + idTest
                + ", dtMoment=" + dtMoment
                + ", value=" + value
                + ", component_idComponent=" + component_idComponent
                + ", Component_fkMachine=" + Component_fkMachine
                + '}';
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getDtMoment() {
        return dtMoment;
    }

    public void setDtMoment(String dtMoment) {
        this.dtMoment = dtMoment;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getComponent_idComponent() {
        return component_idComponent;
    }

    public void setComponent_idComponent(Integer component_idComponent) {
        this.component_idComponent = component_idComponent;
    }

    public Integer getComponent_fkMachine() {
        return Component_fkMachine;
    }

    public void setComponent_fkMachine(Integer Component_fkMachine) {
        this.Component_fkMachine = Component_fkMachine;
    }

}
