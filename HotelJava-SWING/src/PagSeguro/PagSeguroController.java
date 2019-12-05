package PagSeguro;

import java.math.BigDecimal;

import Hotel.Hospede;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.Shipping;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;

public class PagSeguroController {

	public static String EMAIL = "pdrgomes1998@gmail.com";
	public static String TOKEN = "";
	
	public String criarPagamento() throws PagSeguroServiceException {
		
		
		PaymentRequest request = new PaymentRequest();
		request.setReference("");
		request.setCurrency(Currency.BRL);
		request.setSender(getSender());
		request.setShipping(getShipping());
		request.addItem(getItem());
		request.setNotificationURL("");
		request.setRedirectURL("wwww.google.com.br");

		
		
		return request.register(getCredentials());
	}
	
	private static Sender getSender() {
		Hospede hosp = new Hospede();
		
		Sender sender = new Sender();
		
		sender.setName(hosp.getNome());
		sender.setEmail(hosp.getEmail());
		sender.setPhone(new Phone("51","98515545"));
		
		return sender;
		
	}
	
	private static Shipping getShipping() {
		
		Shipping shipping = new Shipping();
		
		shipping.setAddress(getAddress());
		shipping.setCost(new BigDecimal("9.00"));
		shipping.setType(ShippingType.PAC);
		
		return shipping;
		
	}
	
	
	private static Address getAddress() {
		
		Address address = new Address();
		
		address.setCity("Porto Alegre");
		address.setComplement("Atrás do Mercadão");
		address.setCountry("Brasil");
		address.setState("RS");
		address.setPostalCode("91787-000");
		address.setNumber("291");
		address.setDistrict("Hipica");
		
		return address;
	}
	
	private static Item getItem() {
		
		Item item = new Item();
		
		item.setId("001");
		item.setDescription("QUARTO 1");
		item.setQuantity(1);
		item.setAmount(new BigDecimal("10.00"));
		item.setShippingCost(new BigDecimal("10.000"));
		
		return item;
	}
	
	private static Credentials getCredentials() throws PagSeguroServiceException {
		return new AccountCredentials(EMAIL, TOKEN);
		
	}
}
