package com.paralun.app.repository;

import com.paralun.app.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, String> {

}
