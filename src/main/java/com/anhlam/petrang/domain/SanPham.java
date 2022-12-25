package com.anhlam.petrang.domain;

import com.anhlam.petrang.domain.DTO.ProductDTO;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "productDTO",
                entities = {
                        @EntityResult(
                                entityClass = SanPham.class,
                                fields = {
                                        @FieldResult(name = "id", column = "mahang"),
                                        @FieldResult(name = "hangSXID", column = "mahangSX"),
                                        @FieldResult(name = "tenSP", column = "tenSP"),
                                        @FieldResult(name = "soLuong", column = "soLuong"),
                                        @FieldResult(name = "mauSac", column = "mauSac"),
                                        @FieldResult(name = "giaBan", column = "giaBan"),
                                        @FieldResult(name = "donViTinh", column = "donViTinh"),
                                        @FieldResult(name = "moTa", column = "moTa"),
                                }
                        )
                }
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "getSP",
                query = "select id as mahang, hangsxid as mahangSX, tenSP, soLuong, mauSac, giaBan, donViTinh, moTa from SanPham",
                resultSetMapping = "productDTO"
        )
)
@NamedEntityGraph(name = "SanPham.hangSX",
        attributeNodes = {
                @NamedAttributeNode(value = "tenSP"),
                @NamedAttributeNode(value = "hangSX", subgraph = "getHSX")
        },
        subgraphs = @NamedSubgraph(name = "getHSX", type = HangSX.class, attributeNodes = @NamedAttributeNode("tenHang")),
        subclassSubgraphs = @NamedSubgraph(name = "getHSX", type = HangSX.class, attributeNodes = @NamedAttributeNode("tenHang"))
)
@Table(name = "sanpham")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hangsxid", updatable = false, insertable = false)
    private Long hangSXID;

    @Column(name = "tensp")
    private String tenSP;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "mausac")
    private String mauSac;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "donvitinh")
    private String donViTinh;

    @Column(name = "mota")
    private String moTa;

    @ManyToOne(targetEntity = HangSX.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "hangsxid")
    private HangSX hangSX;

    public SanPham() {

    }

    public SanPham(Long id, String tenSP) {
        this.id = id;
        this.tenSP = tenSP;
    }

    public SanPham(Long id, String tenSP, HangSX hangSX) {
        this.id = id;
        this.tenSP = tenSP;
        this.hangSX = hangSX;
    }


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
