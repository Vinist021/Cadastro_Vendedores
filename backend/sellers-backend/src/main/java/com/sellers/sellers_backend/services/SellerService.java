package com.sellers.sellers_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellers.sellers_backend.models.Seller;
import com.sellers.sellers_backend.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller getById(Long id) {
        return sellerRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Seller with id " + id + " not found"));
    }

    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller update(Long id, Seller seller) {
        Seller updatedSeller = getById(id);

        updatedSeller.setName(seller.getName());
        updatedSeller.setSalary(seller.getSalary());
        updatedSeller.setBonus(seller.getBonus());
        updatedSeller.setGender(seller.getGender());

        return sellerRepository.save(updatedSeller);
    }

    public void deleteById(Long id) {
        Seller seller = getById(id);
        sellerRepository.delete(seller);
    }
}
