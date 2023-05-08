package com.stockman.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {
	
	
	private String state;
	private String city;
	private String pincode;
//	@Enumerated(EnumType.STRING)
	private AddressType type;
	
	
	
	

}
