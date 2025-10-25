package com.sellers.sellers_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellers.sellers_backend.dtos.SellerRequest;
import com.sellers.sellers_backend.dtos.SellerResponse;
import com.sellers.sellers_backend.services.SellerService;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> getSeller(@PathVariable Long id) {
        SellerResponse seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @GetMapping()
    public ResponseEntity<List<SellerResponse>> getSellers() {
        List<SellerResponse> sellers = sellerService.getAll();

        return ResponseEntity.ok(sellers);
    }

    @PostMapping()
    public ResponseEntity<SellerResponse> saveSeller(@RequestBody SellerRequest seller) {
        SellerResponse savedSeller = sellerService.save(seller);
        return ResponseEntity.ok(savedSeller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerResponse> updateSeller(@PathVariable Long id, @RequestBody SellerRequest sellerRequest) {
        SellerResponse updatedSeller = sellerService.update(id, sellerRequest);
        return ResponseEntity.ok(updatedSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
