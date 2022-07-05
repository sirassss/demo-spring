package com.anhlam.petrang.domain.DTO;

import com.anhlam.petrang.domain.HangSX;

import java.math.BigDecimal;

public class ProductDTO {

    private Long id;

    private Long hangSXID;

    private String tenSP;

    private Integer soLuong;

    private String mauSac;

    private BigDecimal giaBan;

    private String donViTinh;

    private String moTa;

    private HangSX hangSX;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHangSXID() {
        return hangSXID;
    }

    public void setHangSXID(Long hangSXID) {
        this.hangSXID = hangSXID;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public HangSX getHangSX() {
        return hangSX;
    }

    public void setHangSX(HangSX hangSX) {
        this.hangSX = hangSX;
    }
}
