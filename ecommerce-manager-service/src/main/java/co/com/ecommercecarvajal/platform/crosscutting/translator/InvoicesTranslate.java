package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Invoices;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("invoices")
public class InvoicesTranslate implements Translator<InvoicesExtDTO, Invoices> {

    @Override
    public Invoices translate(InvoicesExtDTO invoicesExtDTO) {

        return Invoices.builder()
        		.id(invoicesExtDTO.getId())
                .idCustomer(invoicesExtDTO.getIdCustomer())
                .invoiceDate(invoicesExtDTO.getInvoiceDate())
                .totalInvoice(invoicesExtDTO.getTotalInvoice())
                .totalIva(invoicesExtDTO.getTotalIva()).build();
    }

}
