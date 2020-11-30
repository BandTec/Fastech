package fastech.model;

/**
 *
 * @author Jorge
 */
public class Collaborator {

    private Integer idCollaborator;
    private String name;
    private String cpf;
    private String login;
    private String password;
    private String office;
    private Integer fkCompanyBranch;

    @Override
    public String toString() {
        return "Collaborator{"
                + "idCollaborator=" + idCollaborator
                + ", name=" + name
                + ", cpf=" + cpf
                + ", login=" + login
                + ", password=" + password
                + ", office=" + office
                + ", fkCompanyBranch=" + fkCompanyBranch
                + '}';
    }

    public Integer getIdCollaborator() {
        return idCollaborator;
    }

    public void setIdCollaborator(Integer idCollaborator) {
        this.idCollaborator = idCollaborator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getFkCompanyBranch() {
        return fkCompanyBranch;
    }

    public void setFkCompanyBranch(Integer fkCompanyBranch) {
        this.fkCompanyBranch = fkCompanyBranch;
    }

}
