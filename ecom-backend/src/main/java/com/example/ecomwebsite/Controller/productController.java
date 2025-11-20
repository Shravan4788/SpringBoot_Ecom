package com.example.ecomwebsite.Controller;


import com.example.ecomwebsite.Service.ProductService;
import com.example.ecomwebsite.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class productController {
    @Autowired
    private ProductService service;

    @GetMapping ("/products")
    public ResponseEntity<List<Product>> getProducts(){

        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return new ResponseEntity<>(service.getproductByID(id),HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, MultipartFile imageFile){

        try{
            Product product1= service.addProduct(product,imageFile);
            return new  ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getimagebyId(@PathVariable int id){
        Product product= service.getproductByID(id);
        byte [] imageFile=product.getImage_data();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);

    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product, MultipartFile imageFile){
        Product product1= null;
        try {
            product1 = service.Updateproducts(id,product,imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(product1!=null){
          return new  ResponseEntity<>("Updated",HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_REQUEST);
       }
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
       Product product=service.getproductByID(id);
       if(product!=null) {
           service.deleteProduct(id);
           return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
       }
       else
           return new ResponseEntity<>("Product Not Found",HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchproduct(@RequestParam String keyword){
        System.out.println("Searching "+ keyword);
        List<Product> products=service.searchproduct(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
