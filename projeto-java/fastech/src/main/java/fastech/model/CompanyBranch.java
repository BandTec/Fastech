package fastech.model;

/**
 *
 * @author Jorge
 */
public class CompanyBranch {

    private Integer idCompanyBranch;
    private String name;
    private String city;
    private String zipCode;
    private String street;
    private Integer number;

    @Override
    public String toString() {
        return "CompanyBranch{"
                + "idCompanyBranch=" + idCompanyBranch
                + ", name=" + name
                + ", city=" + city
                + ", zipCode=" + zipCode
                + ", street=" + street
                + ", number=" + number
                + '}';
    }

    public Integer getIdCompanyBranch() {
        return idCompanyBranch;
    }

    public void setIdCompanyBranch(Integer idCompanyBranch) {
        this.idCompanyBranch = idCompanyBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
    

}
