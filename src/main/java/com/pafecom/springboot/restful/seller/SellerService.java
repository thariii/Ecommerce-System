package com.pafecom.springboot.restful.seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class SellerService {

	private  SellerRepository sellerRepository;

    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> findById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller save(Seller stock) {
        return sellerRepository.save(stock);
    }

    public void deleteById(Long id) {
    	sellerRepository.deleteById(id);
    }
}
