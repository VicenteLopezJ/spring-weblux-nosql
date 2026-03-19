package ap1.junior.vicente.service;

import ap1.junior.vicente.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> findById(String id);

    Mono<Product> save(Product product);

    Mono<Product> update(Product product);

    Mono<Product> delete(String id);

}