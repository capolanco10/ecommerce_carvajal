package co.com.ecommercecarvajal.platform.crosscutting.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Shoppingcart;


@Repository
public interface ShoppingcartRepository extends JpaRepository<Shoppingcart, Integer> {
	
    @Query(value = "select * "
            + "from shoppingcart cdc "
            + "where cdc.id_customer = :idCustomer", nativeQuery = true)
    List<Shoppingcart> findAllByIdCustomer(@Param("idCustomer") Integer idCustomer);

}
