package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoiceDetailResponseDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("invoiceDetailResponseDTO")
public class InvoiceDetailResponseDTOTranslate implements Translator<InvoicesExtDTO, InvoiceDetailResponseDTO> {

    @Override
    public InvoiceDetailResponseDTO translate(InvoicesExtDTO entity) {

        return InvoiceDetailResponseDTO.builder()
        		.id(entity.getId())
                .idCustomer(entity.getIdCustomer())
                .invoiceDate(entity.getInvoiceDate())
                .totalInvoice(entity.getTotalInvoice())
                .totalIva(entity.getTotalIva()).build();
    }

}
