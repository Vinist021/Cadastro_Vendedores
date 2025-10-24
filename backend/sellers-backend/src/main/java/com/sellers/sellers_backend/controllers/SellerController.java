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

import com.sellers.sellers_backend.models.Seller;
import com.sellers.sellers_backend.services.SellerService;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable Long id) {
        Seller seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @GetMapping()
    public ResponseEntity<List<Seller>> getSellers() {
        List<Seller> sellers = sellerService.getAll();
        return ResponseEntity.ok(sellers);
    }

    @PostMapping()
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
        Seller savedSeller = sellerService.save(seller);
        return ResponseEntity.ok(savedSeller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        Seller updatedSeller = sellerService.update(id, seller);
        return ResponseEntity.ok(updatedSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
