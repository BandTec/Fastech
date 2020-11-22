package fastech.model;

/**
 *
 * @author Jorge
 */
public class Machine {

    private Integer idMachine;
    private String name;
    private Integer fkCompanyBranch;

    @Override
    public String toString() {
        return "Machine{"
                + "idMachine=" + idMachine
                + ", name=" + name
                + ", fkCompanyBranch=" + fkCompanyBranch
                + '}';
    }

    public Integer getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFkCompanyBranch() {
        return fkCompanyBranch;
    }

    public void setFkCompanyBranch(Integer fkCompanyBranch) {
        this.fkCompanyBranch = fkCompanyBranch;
    }

}
