package com.omar.gestiondestock.repository;


import com.omar.gestiondestock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk,Integer> {
}
