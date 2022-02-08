package co.com.ecommercecarvajal.platform.crosscutting.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.ShoppingcartDetail;


@Repository
public interface ShoppingcartDetailRepository extends JpaRepository<ShoppingcartDetail, Integer> {

}
