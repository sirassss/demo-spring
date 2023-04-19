package com.anhlam.petrang.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nhanvien")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Document(indexName = "employee")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tennv")
    private String tenNV;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sodt")
    private String soDT;

    @Column(name = "email")
    private String email;

    @Column(name = "tenphong")
    private String tenPhong;

    @Column(name = "hangsxid")
    private Long hangSXID;

    public NhanVien() {
    }

    public NhanVien(Long id, String tenNV, Boolean gioiTinh, String diaChi, String soDT, String email, String tenPhong, Long hangSXID) {
        this.id = id;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.tenPhong = tenPhong;
        this.hangSXID = hangSXID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Long getHangSXID() {
        return hangSXID;
    }

    public void setHangSXID(Long hangSXID) {
        this.hangSXID = hangSXID;
    }
}
