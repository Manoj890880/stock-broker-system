package com.stockman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockReport {
	private String name;
    private Integer totalQuantity;
    private Integer soldQuantity;
    private Integer remainingQuantity;
}
