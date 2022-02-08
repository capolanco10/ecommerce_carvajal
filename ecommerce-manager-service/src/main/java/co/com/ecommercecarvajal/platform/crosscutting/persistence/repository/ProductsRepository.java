package co.com.ecommercecarvajal.platform.crosscutting.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
