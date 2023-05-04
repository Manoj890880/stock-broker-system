package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Customer_Id;
	
	@NotNull
	private String Customer_Name;
	@NotNull
	private String Customer_Password;
	@NotNull
    private String Customer_Contact;
	@NotNull
    private String Customer_Email;
	
	private Integer Wallet;
	

}
