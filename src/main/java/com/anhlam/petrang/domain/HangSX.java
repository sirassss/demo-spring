package com.anhlam.petrang.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity()
//@NamedEntityGraph(name = "getHSX", attributeNodes = { @NamedAttributeNode("nhanVien")})
@Table(name = "hangsx")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HangSX implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenhang")
    private String tenHang;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sodt")
    private String soDT;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "hangsxid", referencedColumnName = "id")
    @Fetch(FetchMode.SELECT)
    private List<NhanVien> nhanVien = new ArrayList<>();

    public HangSX(){}

    public HangSX(Long id, String tenHang) {
        this.id = id;
        this.tenHang = tenHang;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NhanVien> getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(List<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }
}
