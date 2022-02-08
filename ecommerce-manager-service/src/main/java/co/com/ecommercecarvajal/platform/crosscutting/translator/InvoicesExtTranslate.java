package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Invoices;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("invoicesExt")
public class InvoicesExtTranslate implements Translator<Invoices, InvoicesExtDTO> {

    @Override
    public InvoicesExtDTO translate(Invoices invoices) {

        return InvoicesExtDTO.builder()
        		.id(invoices.getId())
                .idCustomer(invoices.getIdCustomer())
                .invoiceDate(invoices.getInvoiceDate())
                .totalInvoice(invoices.getTotalInvoice())
                .totalIva(invoices.getTotalIva()).build();
    }

}
