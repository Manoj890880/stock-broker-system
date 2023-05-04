package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Stock {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer com_Id;
	
	@NotNull(message = "Company name should not be null")
	private String com_Name;
	@NotNull(message = "stock_Quantity should not be null")
	private Integer stock_Quantity;
	@NotNull(message = "stock_Type should not be null")
	private String stock_Type;
	@NotNull(message = "per_stock_price should not be null")
	private Integer per_stock_price;
	@NotNull(message = "Total_stock_price should not be null")
	private Integer Total_stock_price;

}
