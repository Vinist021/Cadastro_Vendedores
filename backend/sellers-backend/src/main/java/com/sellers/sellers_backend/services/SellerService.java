package com.sellers.sellers_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellers.sellers_backend.dtos.SellerRequest;
import com.sellers.sellers_backend.dtos.SellerResponse;
import com.sellers.sellers_backend.models.Seller;
import com.sellers.sellers_backend.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse getById(Long id) {
        return sellerRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Seller with id " + id + " not found")).toDTO();
    }

    public List<SellerResponse> getAll() {
        return sellerRepository.findAll()
                        .stream()
                        .map(s -> s.toDTO())
                        .toList();
    }

    public SellerResponse save(SellerRequest sellerRequest) {
        Seller seller = sellerRepository.save(sellerRequest.toEntity());
        return seller.toDTO();
    }

    public SellerResponse update(Long id, SellerRequest sellerRequest) {
        Seller updatedSeller = sellerRepository.getReferenceById(id);

        updatedSeller.setName(sellerRequest.getName());
        updatedSeller.setSalary(sellerRequest.getSalary());
        updatedSeller.setBonus(sellerRequest.getBonus());
        updatedSeller.setGender(sellerRequest.getGender());

        return sellerRepository.save(updatedSeller).toDTO();
    }

    public void deleteById(Long id) {
        Seller seller = sellerRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Seller not found with this id: " + id));
                        
        sellerRepository.delete(seller);
    }
}
