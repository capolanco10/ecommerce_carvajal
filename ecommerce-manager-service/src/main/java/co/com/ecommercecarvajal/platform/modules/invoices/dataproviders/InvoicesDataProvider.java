package co.com.ecommercecarvajal.platform.modules.invoices.dataproviders;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface InvoicesDataProvider {
	
	InvoicesExtDTO saveInvoices(InvoicesExtDTO invoices) throws EBusinessApplicationException;

}
