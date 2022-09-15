package com.nagarro.demo.requests;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AmountRange implements Serializable{
	
	@JsonProperty("from_amount")
	private Integer fromAmount;
	
	@JsonProperty("to_amount")
	private Integer toAmount;

}
