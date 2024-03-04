package com.alam.demo.domain.dto;

import lombok.*;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
//@Document(indexName = "user")
public class NhanVienDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

//    @Field(type = FieldType.Keyword)
    private Long id;
    private String tenNV;
    private String diaChi;
    private String soDT;
    private String email;


    public NhanVienDTO(NhanVienDTO nhanVienDTO) {
    }
}
