/**
 * 
 */
package co.com.ecommercecarvajal.platform.crosscutting.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "products", schema = "public")
public class Products implements Serializable{

	private static final long serialVersionUID = 4052186856571123809L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	
    @Column(name = "code")
    private String code;
    
    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "description")
    private String description;
}
