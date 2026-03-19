package ap1.junior.vicente.service.impl;

import ap1.junior.vicente.model.Product;
import ap1.junior.vicente.repository.ProductRepository;
import ap1.junior.vicente.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Listando todos los productos");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        log.info("Buscando producto por ID: " + id);
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Registrando producto: " + product.toString());
        product.setState("A");
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        log.info("Actualizando producto: " + product.toString());
        product.setState("A");
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> delete(String id) {
        log.info("Eliminando (lógico) producto ID: " + id);
        return productRepository.findById(id)
                .flatMap(product -> {
                    product.setState("I");
                    return productRepository.save(product);
                });
    }

}