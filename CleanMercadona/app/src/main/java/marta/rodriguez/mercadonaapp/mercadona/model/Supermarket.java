package marta.rodriguez.mercadonaapp.mercadona.model;

/**
 * Created by marta.rodriguez on 28/05/14.
 */
public class Supermarket {

    private int id;
    private String town;
    private String address;
    private String cp;
    private String hours;
    private String comments;

    public Supermarket() {

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getGeocodingAddress() {
        return address + ", " + town + ", " + cp;
    }

}
