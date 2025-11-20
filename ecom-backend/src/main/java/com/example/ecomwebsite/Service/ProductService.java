    package com.example.ecomwebsite.Service;

    import com.example.ecomwebsite.Repository.ProductRepository;
    import com.example.ecomwebsite.model.Product;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Repository;
    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.IOException;
    import java.util.List;
    @Service
    public class ProductService {
        @Autowired
        private ProductRepository repo;

        public List<Product> getProducts() {
            return repo.findAll();
        }

        public Product getproductByID(int id) {
            return repo.findById(id).orElse(new Product());
        }

        public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImage_data(imageFile.getBytes());
            return repo.save(product);
        }

        public Product Updateproducts(int id, Product product, MultipartFile imageFile) throws IOException {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImage_data(imageFile.getBytes());
            return  repo.save(product);
        }

        public void deleteProduct(int id) {
            repo.deleteById(id);

        }

        public List<Product> searchproduct(String keyword) {
           return repo.searchproduct(keyword);
        }
    }
