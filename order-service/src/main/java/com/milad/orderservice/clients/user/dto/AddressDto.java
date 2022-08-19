package com.milad.orderservice.clients.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public  class AddressDto  {
	

	private String tittle;

	private String fullAddress;

	private String postalCode;

	private String city;

	@JsonProperty("personality")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private PersonalityDto personalityDto;
	
}










