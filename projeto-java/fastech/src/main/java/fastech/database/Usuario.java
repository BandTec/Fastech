package fastech.database;

/**
 *
 * @author Jorge
 */
public class Usuario {

    private Integer idUser;
    private String nameUser;
    private String loginUser;
    private String passwordUser;
    private Integer fkEstablishmentUser;

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser
                + ", nameUser=" + nameUser
                + ", loginUser=" + loginUser
                + ", passwordUser=" + passwordUser
                + ", fkEstablishmentUser=" + fkEstablishmentUser
                + '}';
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public Integer getFkEstablishmentUser() {
        return fkEstablishmentUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public void setFkEstablishmentUser(Integer fkEstablishmentUser) {
        this.fkEstablishmentUser = fkEstablishmentUser;
    }

}
