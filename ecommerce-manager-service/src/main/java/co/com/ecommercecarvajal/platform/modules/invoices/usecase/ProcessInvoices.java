package co.com.ecommercecarvajal.platform.modules.invoices.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailResponseDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.BadRequestException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessRuntimeBusinessException;
import co.com.ecommercecarvajal.platform.crosscutting.messages.CustomersMessages;
import co.com.ecommercecarvajal.platform.crosscutting.messages.ProductsMessages;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.UseCase;
import co.com.ecommercecarvajal.platform.crosscutting.translator.InvoiceDetailResponseDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.util.ConfigurationParameterGeneral;
import co.com.ecommercecarvajal.platform.modules.invoicedetail.dataproviders.InvoiceDetailDataProvider;
import co.com.ecommercecarvajal.platform.modules.invoices.dataproviders.InvoicesDataProvider;
import lombok.extern.log4j.Log4j2;

/**
 * Process Shift use case.
 */

@Log4j2
@UseCase
public class ProcessInvoices {

	@Autowired
	private InvoicesDataProvider invoicesDataProvider;
	
	@Autowired
	private InvoiceDetailDataProvider invoiceDetailDataProvider;
	
	@Autowired
	private ConfigurationParameterGeneral configurationParameterGeneral;
	
	@Autowired
	private InvoiceDetailResponseDTOTranslate invoiceDetailResponseDTOTranslate;

	public RequestDTO saveInvoices(InvoicesDTO invoicesDTO) throws EBusinessApplicationException {

		List<InvoiceDetailDTO> invoideDetailList = validateDetail(invoicesDTO.getInvoiceDetail());
		
		if(invoicesDTO.getIdCustomer() == null) {
			throw new BadRequestException(CustomersMessages.CUSTOMER_NOTNULL);
		}
		
		InvoiceDetailResponseDTO invoiceDetailResponseDTO = new InvoiceDetailResponseDTO();
		
		if(invoideDetailList != null) {
			
			Double total = invoideDetailList.stream()
					.map(InvoiceDetailDTO::getTotal)
					.collect(Collectors.summingDouble(Double::doubleValue));
			
			//save invoice
			InvoicesExtDTO invoicesExtDTO = invoicesDataProvider.saveInvoices(new InvoicesExtDTO
					(null, invoicesDTO.getIdCustomer(), invoicesDTO.getInvoiceDate(), total, calculateIVA(total)));
			
			//save detail invoce
			List<InvoiceDetailDTO> invoideDetailDTOList = invoideDetailList.stream()
				.map(invoiceDetail ->{
					invoiceDetail.setIdInvoice(invoicesExtDTO.getId());
					try {
						return invoiceDetailDataProvider.saveInvoiceDetail(invoiceDetail);
					} catch (EBusinessApplicationException e) {
						throw new EBusinessRuntimeBusinessException(ProductsMessages.PRODUCTS_ERROR_SAVE);
					}
				})
				.collect(Collectors.toCollection(ArrayList::new));
			
			invoiceDetailResponseDTO = invoiceDetailResponseDTOTranslate.translate(invoicesExtDTO);
			invoiceDetailResponseDTO.setInvoiceDetail(invoideDetailDTOList);
		}
		
		return new RequestDTO(ResponseConstant.SUCCESSFUL, invoiceDetailResponseDTO);
	}

	/**
	 * metodo que valida todos los detalles de la factura
	 * 
	 * @param invoiceDetailDTOs
	 * @return
	 */
	private List<InvoiceDetailDTO> validateDetail(List<InvoiceDetailDTO> invoiceDetailDTOs) {
		
		invoiceDetailDTOs.stream()
		.forEach(product -> {
			if (product.getIdProduct() == null) {
				throw new BadRequestException(ProductsMessages.PRODUCT_NOTNULL);
			}
		});

		return invoiceDetailDTOs.stream()
			.map(products -> {
				return new InvoiceDetailDTO(null, null, products.getIdProduct(), products.getAmount(), products.getSubtotal(), Double.valueOf(products.getAmount() * products.getSubtotal()));
			})
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Double calculateIVA(Double total) {
		
		Integer iva = configurationParameterGeneral.getIva();
		Double ivaTotal = 0.0;
		
		if(iva != null && iva > 0) {
			ivaTotal = ((total * iva) /100);
		}
		
		return ivaTotal;
	}
}

