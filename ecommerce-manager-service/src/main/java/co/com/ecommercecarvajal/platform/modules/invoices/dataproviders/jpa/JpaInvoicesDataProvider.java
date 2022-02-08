package co.com.ecommercecarvajal.platform.modules.invoices.dataproviders.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.InvoicesRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.InvoicesExtTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.InvoicesTranslate;
import co.com.ecommercecarvajal.platform.modules.invoices.dataproviders.InvoicesDataProvider;

@DataProvider
public class JpaInvoicesDataProvider implements InvoicesDataProvider {

	@Autowired
	private InvoicesRepository invoicesRepository;

	@Autowired
	@Qualifier("invoices")
	private InvoicesTranslate invoicesTranslate;

	@Autowired
	@Qualifier("invoicesExt")
	private InvoicesExtTranslate invoicesExtTranslate;

	@Override
	public InvoicesExtDTO saveInvoices(InvoicesExtDTO entity) throws EBusinessApplicationException {
		return invoicesExtTranslate.translate(invoicesRepository.save(invoicesTranslate.translate(entity)));
	}

}
