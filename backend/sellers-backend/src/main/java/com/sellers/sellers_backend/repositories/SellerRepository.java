package com.sellers.sellers_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellers.sellers_backend.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
