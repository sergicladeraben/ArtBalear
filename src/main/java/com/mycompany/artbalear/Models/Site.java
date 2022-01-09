package com.mycompany.artbalear.Models;

public class Site {

    private String register;
    private String name;
    private String municipi;
    private String address;
    private String email;
    private int telephone;
    private String type;
    private String modalities;
    private String gestor;
    private String serveis;

    public Site(String register, String name, String municipi, String address, String email, int telephone, String type, String modalities, String gestor, String serveis) {
        this.register = register;
        this.name = name;
        this.municipi = municipi;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.type = type;
        this.modalities = modalities;
        this.gestor = gestor;
        this.serveis = serveis;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModalities() {
        return modalities;
    }

    public void setModalities(String modalities) {
        this.modalities = modalities;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getServeis() {
        return serveis;
    }

    public void setServeis(String serveis) {
        this.serveis = serveis;
    }

    @Override
    public String toString() {
        return "Site{" + "register=" + register + ", name=" + name + ", municipi=" + municipi + ", address=" + address + ", email=" + email + ", telephone=" + telephone + ", type=" + type + ", modalities=" + modalities + ", gestor=" + gestor + ", serveis=" + serveis + '}';
    }

}
