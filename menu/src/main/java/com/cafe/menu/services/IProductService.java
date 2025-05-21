package com.cafe.menu.services;

import com.cafe.menu.dto.DtoProduct;
import com.cafe.menu.dto.ProductIU;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {
      DtoProduct getProductById(Long id);
      List<DtoProduct> getAllProducts();
      DtoProduct createProduct(ProductIU productIU, MultipartFile imageFile);

      DtoProduct updateProduct(Long id, ProductIU productIU);
      boolean deleteProductById(Long id);


}
