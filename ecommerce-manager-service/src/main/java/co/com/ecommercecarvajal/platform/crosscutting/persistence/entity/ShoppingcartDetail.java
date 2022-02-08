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
@Table(name = "shoppingcart_detail", schema = "public")
public class ShoppingcartDetail implements Serializable{

	private static final long serialVersionUID = 4052186856571123809L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	
    @Column(name = "id_shoppingcart")
    private Integer idShoppingcart;
    
    @Column(name = "id_product")
    private Integer idProduct;
    
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "total")
    private Double total;
}
