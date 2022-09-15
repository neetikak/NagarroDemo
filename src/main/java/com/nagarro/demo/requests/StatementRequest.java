package com.nagarro.demo.requests;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class StatementRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5785540395773865152L;

	@JsonProperty("account_id")
	@NonNull
	private Integer accountId;
	
	@JsonProperty("date_range")
	private DateRange dateRange;
	
	@JsonProperty("amount_range")
	private AmountRange amountRange;

}
