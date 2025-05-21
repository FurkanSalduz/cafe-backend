package com.cafe.menu.services.impl;

import com.cafe.menu.dto.DtoProduct;
import com.cafe.menu.dto.ProductIU;
import com.cafe.menu.entities.Category;
import com.cafe.menu.entities.Product;
import com.cafe.menu.mapper.AppMapper;
import com.cafe.menu.repository.CategoryRepository;
import com.cafe.menu.repository.ProductRepository;
import com.cafe.menu.services.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

   private final ProductRepository productRepository;
   private final CategoryRepository categoryRepository;
   private final AppMapper mapper;
    private final FileService fileService; // AWS S3 servisini ekliyoruz

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, AppMapper appMapper, FileService fileService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        mapper = appMapper;
        this.fileService = fileService;

    }

    @Override
    public DtoProduct getProductById(Long id) {
        Optional<Product> optinal = productRepository.findById(id);
        if (optinal.isPresent()) {
            Product product = optinal.get();
          return mapper.ProductToDtoProduct(product);
        }

        return null;
    }

    @Override
    public List<DtoProduct> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            // Ürün yoksa uygun bir response döndürebilirsiniz.
            return null;
        }
        List<DtoProduct> dtoProducts = new ArrayList<>();
        for (Product product : products) {
            dtoProducts.add(mapper.ProductToDtoProduct(product));
        }
        return dtoProducts;
    }



    @Override
    public DtoProduct createProduct(ProductIU productIU, MultipartFile imageFile) {
        Long categoryId = productIU.getCategoryId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        Product product = new Product();
        product.setName(productIU.getName());
        product.setDescription(productIU.getDescription());
        product.setPrice(productIU.getPrice());
        product.setCategory(category);

        // Eğer bir resim yüklendiyse, S3'e yükleyip URL'yi kaydediyoruz.
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = fileService.uploadFile(imageFile);
            product.setImageUrl(imageUrl);
        }

        Product savedProduct = productRepository.save(product);
        return mapper.ProductToDtoProduct(savedProduct);
    }



    @Override
    public DtoProduct updateProduct(Long id, ProductIU productIU) {
        Optional<Product> optinal = productRepository.findById(id);
        if (optinal.isPresent()) {
            Product product = optinal.get();
            mapper.updateProductFromProductIU(productIU, product);
            Product saveProduct = productRepository.save(product);
            return mapper.ProductToDtoProduct(saveProduct);
        }

        return null;
    }

    @Override
    public boolean deleteProductById(Long id) {
        Optional<Product> deleteProduct = productRepository.findById(id);
        if (deleteProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
