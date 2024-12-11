package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer empID;

@Column(nullable=false)
private String isim;

@Column(nullable=false)
private String soyad;

@Column(nullable=false)
private String gorev;

@Column(nullable=false)
private String yas;

public Integer getEmpID() {
    return empID;
}

public void setEmpID(Integer empID) {
    this.empID = empID;
}

public String getIsim() {
    return isim;
}

public void setIsim(String isim) {
    this.isim = isim;
}

public String getSoyad() {
    return soyad;
}

public void setSoyad(String soyad) {
    this.soyad = soyad;
}

public String getGorev() {
    return gorev;
}

public void setGorev(String gorev) {
    this.gorev = gorev;
}

public String getYas() {
    return yas;
}

public void setYas(String yas) {
    this.yas = yas;
}
}
