package com.anhlam.petrang.domain.DTO;

import com.anhlam.petrang.domain.HangSX;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class HangSXDTO extends HangSX {

    @Transient
    @JsonSerialize
    private String giamDoc;

    public HangSXDTO() {}

    public HangSXDTO(Long id, String tenHang, String giamDoc) {
        super.setId(id);
        super.setTenHang(tenHang);
        this.giamDoc = giamDoc;
    }

    public String getGiamDoc() {
        return giamDoc;
    }

    public void setGiamDoc(String giamDoc) {
        this.giamDoc = giamDoc;
    }
}