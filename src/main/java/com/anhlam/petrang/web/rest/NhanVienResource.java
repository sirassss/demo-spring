package com.anhlam.petrang.web.rest;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.service.NhanVienService;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NhanVienResource {

    private final NhanVienService nhanVienService;
    private final SanPhamService sanPhamService;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final RestTemplateBuilder restTemplateBuilder;

    public NhanVienResource(@Qualifier("nhanvien") NhanVienService nhanVienService, SanPhamService sanPhamService, SanPhamRepoCustom sanPhamRepoCustom, RestTemplateBuilder restTemplateBuilder) {
        this.nhanVienService = nhanVienService;
        this.sanPhamService = sanPhamService;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @PostMapping("/nhan-vien")
    public ResponseEntity<NhanVien> createEmployee(@RequestBody NhanVien nhanVien) {
        return ResponseEntity.ok().body(nhanVienService.createNhanVien(nhanVien));
    }

    @GetMapping("/nhan-vien")
    @RolesAllowed("USER")
    public ResponseEntity<List<NhanVien>> getNhanVien() {
        return ResponseEntity.ok().body(nhanVienService.getNhanVien());
    }

    @GetMapping("/nhan-vien-update")
    @RolesAllowed("USER")
    public ResponseEntity<List<NhanVien>> getNhanVien_2() {
        return ResponseEntity.ok().body(nhanVienService.updateNhanVien(new NhanVien()));
    }

    @GetMapping("/get-proc-nhan-vien")
    public ResponseEntity<List<NhanVien>> getProcNhanVien() {
        List<NhanVien> nv = nhanVienService.getProcNhanVien();
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/elastic-search-employee-by-name")
    private ResponseEntity<List<NhanVien>> getEmByName(@RequestParam String name) {
        List<NhanVien> sps = nhanVienService.searchEmployeeByName(name);
        return ResponseEntity.ok().body(sps);
    }

}
