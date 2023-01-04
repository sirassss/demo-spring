package com.anhlam.petrang.domain.DTO;

import com.anhlam.petrang.domain.HangSX;
import lombok.Data;

import java.math.BigDecimal;
@Data
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
}
