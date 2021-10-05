package model;

public class Drivers {
    private String name;
    private String NIC;
    private String liceneNo;
    private String address;
    private Integer contact;

    public Drivers() {
    }

    public Drivers(String name, String NIC, String liceneNo, String address, Integer contact) {
        this.name = name;
        this.NIC = NIC;
        this.liceneNo = liceneNo;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLiceneNo() {
        return liceneNo;
    }

    public void setLiceneNo(String liceneNo) {
        this.liceneNo = liceneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name;
    }
}
