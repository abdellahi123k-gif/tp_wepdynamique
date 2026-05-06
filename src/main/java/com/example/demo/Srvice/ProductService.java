package com.example.demo.Srvice;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 1. إرجاع كل المنتجات
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. إنشاء منتج جديد
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // 3. ✅ جديد: البحث عن منتج بالـ ID
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // 4. ✅ جديد: تحديث منتج موجود
    public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
        // نبحث عن المنتج بالـ ID
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // نحدّث الحقول
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());

        // نحفظ التغييرات
        return productRepository.save(product);
    }

    // 5. ✅ جديد: حذف منتج
    public void deleteProduct(Long id) {
        // نتحقق من وجود المنتج أولاً
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}