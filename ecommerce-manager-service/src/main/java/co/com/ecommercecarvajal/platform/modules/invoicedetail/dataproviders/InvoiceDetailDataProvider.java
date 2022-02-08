package co.com.ecommercecarvajal.platform.modules.invoicedetail.dataproviders;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface InvoiceDetailDataProvider {
	
	InvoiceDetailDTO saveInvoiceDetail(InvoiceDetailDTO invoices) throws EBusinessApplicationException;

}
