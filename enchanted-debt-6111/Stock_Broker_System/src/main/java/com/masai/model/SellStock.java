package com.masai.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SellStock {
	
	private Integer Customer_Id;
	private Integer Com_Id;
	private LocalDate Sell_date;
	private Integer Sell_Qty;
	private Integer Sell_Amount;
	
	
	
}
