package com.cafe.menu.controller;

import com.cafe.menu.dto.DtoProduct;
import com.cafe.menu.dto.ProductIU;
import com.cafe.menu.services.IProductService;

import com.cafe.menu.services.impl.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/menu")
public class ProductController {
    private final IProductService productService;
    private final FileService fileService;

    public ProductController(IProductService productService, FileService fileService) {
        this.productService = productService;

        this.fileService = fileService;
    }

    @GetMapping("/product/{id}")
    public DtoProduct getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DtoProduct> createProduct(
            @RequestPart("product") String productJson,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductIU productIU = objectMapper.readValue(productJson, ProductIU.class);

            // Ürünü oluştururken imageFile parametresini de gönderiyoruz
            DtoProduct dtoProduct = productService.createProduct(productIU, imageFile);

            return new ResponseEntity<>(dtoProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public boolean  deleteProductById(@PathVariable(name = "id") Long id) {
        return productService.deleteProductById(id);
    }

    @PutMapping("/update/{id}")
    public DtoProduct updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductIU productIU) {
        return productService.updateProduct(id, productIU);
    }


    @GetMapping("/products")
    public List<DtoProduct> getAllProducts() {
        return productService.getAllProducts();
    }

}
