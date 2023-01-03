package com.anhlam.petrang.domain.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NhanVienDTO {

    private Long id;
    private String tenNV;
    private Boolean gioiTinh;
    private String diaChi;
    private String soDT;
    private String email;
    private String tenPhong;
}
