package co.com.ecommercecarvajal.platform.crosscutting.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Invoices;


@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Integer> {

}
