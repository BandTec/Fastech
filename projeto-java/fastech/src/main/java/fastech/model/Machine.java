package fastech.model;

/**
 *
 * @author Jorge
 */
public class Machine {

    private Integer idMachine;
    private String name;
    private String status;
    private Integer fkCompanyBranch;

    @Override
    public String toString() {
        return "Machine{"
                + "idMachine=" + idMachine
                + ", name=" + name
                + ", status=" + status
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFkCompanyBranch() {
        return fkCompanyBranch;
    }

    public void setFkCompanyBranch(Integer fkCompanyBranch) {
        this.fkCompanyBranch = fkCompanyBranch;
    }

}
