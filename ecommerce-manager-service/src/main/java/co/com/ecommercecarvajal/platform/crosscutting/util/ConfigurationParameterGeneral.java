package co.com.ecommercecarvajal.platform.crosscutting.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationParameterGeneral {

    @Value("${general.invoice.iva}")
    private String iva;

	public Integer getIva() {
		return Integer.parseInt(iva);
	}
}
