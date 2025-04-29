package com.seymurahmadzada.cachingapp.controller;

import com.seymurahmadzada.cachingapp.model.entity.Product;
import com.seymurahmadzada.cachingapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/test")
    public String test() {
        Product product = new Product();
        product.setId(1L);
        product.setName("test1");
        product.setDescription("demo1");

        redisTemplate.opsForValue().set("seymur", product, 1,TimeUnit.MINUTES);
        return "test2";
    }

    @GetMapping("/get")
    public Object get() {

        Object seymur = redisTemplate.opsForValue().get("seymur");
        return seymur;
    }

}

