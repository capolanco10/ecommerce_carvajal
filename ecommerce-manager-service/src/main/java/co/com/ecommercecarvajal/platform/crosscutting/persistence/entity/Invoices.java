/**
 * 
 */
package co.com.ecommercecarvajal.platform.crosscutting.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.ecommercecarvajal.platform.crosscutting.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * @author carcorpo
 *
 */	
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "invoices", schema = "public")
public class Invoices implements Serializable{

	private static final long serialVersionUID = 4052186856571123809L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	
    @Column(name = "id_customer")
    private Integer idCustomer;
    
    @JsonFormat(pattern = Constants.SIMPLE_DATE_TIME_FORMAT)
    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "total_invoice")
    private Double totalInvoice;

    @Column(name = "total_iva")
    private Double totalIva;
}
