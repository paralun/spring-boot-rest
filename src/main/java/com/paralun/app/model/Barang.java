package com.paralun.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "barang")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Barang implements Serializable {

    @Id
    @Column(name = "kode")
    private String kode;
    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;
    @Column(name = "kategori")
    private String kategori;
    @Column(name = "stok")
    private Integer stok;
    @Column(name = "harga")
    private Long harga;
    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Column(name = "updatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Barang() {
    }

    public Barang(String kode, String namaBarang, String kategori, Integer stok, Long harga) {
        this.kode = kode;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
