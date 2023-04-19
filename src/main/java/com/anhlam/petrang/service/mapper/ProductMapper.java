package com.anhlam.petrang.service.mapper;


import com.anhlam.petrang.domain.DTO.ProductDTO;
import com.anhlam.petrang.domain.SanPham;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link SanPham} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, SanPham> {}
