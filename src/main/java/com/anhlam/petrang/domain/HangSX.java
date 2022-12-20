package com.anhlam.petrang.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hangsx")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "hangsxid", referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    private List<NhanVien> nhanVien = new ArrayList<>();


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
