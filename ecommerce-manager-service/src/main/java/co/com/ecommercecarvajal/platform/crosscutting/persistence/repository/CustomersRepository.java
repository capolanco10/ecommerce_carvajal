package co.com.ecommercecarvajal.platform.crosscutting.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Customers;


@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
