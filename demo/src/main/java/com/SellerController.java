package com;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

    private final SellerRepository repository;
    SellerController(SellerRepository repository){
        this.repository = repository;
    }

    @GetMapping("/sellers")
    List<Seller> all() {
        return repository.findAll();
    }

    @PostMapping("/sellers")
    Seller newSeller (@RequestBody Seller newSeller) {
        return repository.save(newSeller);
    }

    @GetMapping("/sellers/{id}")
    Seller one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new SellerNotFoundException(id));
    }
    @PutMapping("/buyers/{id}")
    Seller replaceSeller(@RequestBody Seller newSeller, @PathVariable Long id) {
        return repository.findById(id)
                .map(seller -> {
                    seller.setName(newSeller.getName());
                    return repository.save(seller);
                })
                .orElseGet(() -> {
                    Seller seller = new Seller(id);
                    return repository.save(seller);
                });
    }

    @DeleteMapping("/sellers/{id}")
    void deleteSeller(@PathVariable Long id){
        repository.deleteById(id);
    }










}
