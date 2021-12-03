package com.example.telephoneDir_INET2005;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeleRecord {

    @Id
    private int id;
    private String phone;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeleRecord() {

    }
}
