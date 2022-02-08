package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.InvoiceDetail;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("invoiceDetail")
public class InvoiceDetailTranslate implements Translator<InvoiceDetailDTO, InvoiceDetail> {

    @Override
    public InvoiceDetail translate(InvoiceDetailDTO entity) {

        return InvoiceDetail.builder()
        		.id(entity.getId())
                .idInvoice(entity.getIdInvoice())
                .idProduct(entity.getIdProduct())
                .amount(entity.getAmount())
                .subtotal(entity.getSubtotal())
                .total(entity.getTotal()).build();
    }

}
