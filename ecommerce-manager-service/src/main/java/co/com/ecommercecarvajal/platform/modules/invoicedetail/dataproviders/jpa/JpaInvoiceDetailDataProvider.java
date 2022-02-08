package co.com.ecommercecarvajal.platform.modules.invoicedetail.dataproviders.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.InvoiceDetailRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.InvoiceDetailDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.InvoiceDetailTranslate;
import co.com.ecommercecarvajal.platform.modules.invoicedetail.dataproviders.InvoiceDetailDataProvider;

@DataProvider
public class JpaInvoiceDetailDataProvider implements InvoiceDetailDataProvider {

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	@Autowired
	@Qualifier("invoiceDetail")
	private InvoiceDetailTranslate invoiceDetailTranslate;

	@Autowired
	@Qualifier("invoiceDetailDTO")
	private InvoiceDetailDTOTranslate invoiceDetailDTOTranslate;

	@Override
	public InvoiceDetailDTO saveInvoiceDetail(InvoiceDetailDTO entity) throws EBusinessApplicationException {
		return invoiceDetailDTOTranslate.translate(invoiceDetailRepository.save(invoiceDetailTranslate.translate(entity)));
	}

}
