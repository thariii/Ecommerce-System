package com.pafecom.springboot.restful.seller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class SellerAPI {

	  private SellerService sellerService;

	    @GetMapping
	    public ResponseEntity<List<Seller>> findAll() {
	        return ResponseEntity.ok(sellerService.findAll());
	    }

	    @PostMapping
	    public ResponseEntity create(@Valid @RequestBody Seller seller) {
	        return ResponseEntity.ok(sellerService.save(seller));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Seller> findById(@PathVariable Long id) {
	        Optional<Seller> stock = sellerService.findById(id);
	        if (!stock.isPresent()) {
	            log.error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(stock.get());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Seller> update(@PathVariable Long id, @Valid @RequestBody Seller seller) {
	        if (!sellerService.findById(id).isPresent()) {
	            log.error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(sellerService.save(seller));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        if (!sellerService.findById(id).isPresent()) {
	            log.error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        sellerService.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
}
	

