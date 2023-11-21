package com.alam.demo.web.rest;

import com.alam.demo.domain.dto.NhanVienDTO;
import com.alam.demo.service.NhanVienService;
import com.alam.demo.service.SanPhamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NhanVienResource {

    private final NhanVienService nhanVienService;
    private final SanPhamService sanPhamService;

    public NhanVienResource( NhanVienService nhanVienService, SanPhamService sanPhamService) {
        this.nhanVienService = nhanVienService;
        this.sanPhamService = sanPhamService;
    }

    @PostMapping("/nhan-vien")
    public ResponseEntity<NhanVienDTO> createEmployee(@RequestBody NhanVienDTO nhanVien) {
        return ResponseEntity.ok().body(nhanVienService.createNhanVien(nhanVien));
    }

    @GetMapping("/nhan-vien")
    public ResponseEntity<List<NhanVienDTO>> getNhanVien() {
        return ResponseEntity.ok().body(nhanVienService.getNhanVien());
    }

    @GetMapping("/nhan-vien-update")
    public ResponseEntity<List<NhanVienDTO>> getNhanVien_2() {
        return ResponseEntity.ok().body(nhanVienService.updateNhanVien(new NhanVienDTO()));
    }


}
