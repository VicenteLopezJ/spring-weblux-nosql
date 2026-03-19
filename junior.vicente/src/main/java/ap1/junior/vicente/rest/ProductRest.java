package ap1.junior.vicente.rest;

import ap1.junior.vicente.model.Product;
import ap1.junior.vicente.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/product")
public class ProductRest {

    private final ProductService productService;

    @Autowired
    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Product> save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update")
    public Mono<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PutMapping("/delete/{id}")
    public Mono<Product> delete(@PathVariable String id) {
        return productService.delete(id);
    }

}