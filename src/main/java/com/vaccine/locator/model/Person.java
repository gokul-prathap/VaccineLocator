package com.vaccine.locator.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    private long aadhar_no;
    private String name;
    private int zipcode;
    private boolean vaccinated;

    public Person() {
        super();
    }

    public Person(long aadhar_no, String name, int zipcode, boolean vaccinated) {
        this.aadhar_no = aadhar_no;
        this.name = name;
        this.zipcode = zipcode;
        this.vaccinated = vaccinated;
    }

    public long getAadhar_no() {
        return aadhar_no;
    }

    public void setAadhar_no(long aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

}
