package com.masai.model;

import java.time.LocalDate;

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
public class BuyStock {
	private Integer Customer_Id;
	private Integer com_Id;
	private LocalDate Buy_Date;
	private Integer Buy_Qty;
	private Integer Buy_Amount;
}
