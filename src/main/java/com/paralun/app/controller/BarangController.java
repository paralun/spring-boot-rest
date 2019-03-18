package com.paralun.app.controller;

import com.paralun.app.model.Barang;
import com.paralun.app.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BarangController {

    @Autowired
    private BarangRepository repository;

    @GetMapping(value = "/barang")
    public List<Barang> getAll() {
        return repository.findAll();
    }

    @PostMapping(value = "/barang")
    public Barang tambahBarang(@RequestBody Barang barang) {
        return repository.save(barang);
    }

    @PutMapping(value = "/barang/{kode}")
    public ResponseEntity<Barang> updateBarang(@PathVariable(value = "kode") String kode, @RequestBody Barang barang) {
        Optional<Barang> dataBarang = repository.findById(kode);
        if(dataBarang.isPresent()) {
            Barang brg = dataBarang.get();
            brg.setNamaBarang(barang.getNamaBarang());
            brg.setKategori(barang.getKategori());
            brg.setStok(barang.getStok());
            brg.setHarga(barang.getHarga());

            Barang barang1 = repository.save(brg);

            return ResponseEntity.ok(barang1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/barang/{kode}")
    public String deleteBarang(@PathVariable(value = "kode") String kode) {
        Optional<Barang> barang = repository.findById(kode);
        String result ="";

        if(!barang.isPresent()) {
            result = "Kode " + kode + " tidak ditemukan!";
            return result;
        }

        result = "Kode " + kode + " berhasil dihapus!";
        repository.deleteById(kode);
        return result;
    }

    @GetMapping(value = "/barang/{kode}")
    public ResponseEntity<Barang> getBarangByKode(@PathVariable(value = "kode") String kode) {
        Optional<Barang> barang = repository.findById(kode);
        Barang brg = new Barang();

        if(!barang.isPresent()) {
            return ResponseEntity.notFound().build();
        }else {
            brg = barang.get();
            return ResponseEntity.ok().body(brg);
        }
    }
}
