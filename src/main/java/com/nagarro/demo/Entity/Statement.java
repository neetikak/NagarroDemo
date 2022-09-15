package com.nagarro.demo.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@Table(name = "STATEMENT")
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4265346898551876010L;
	@Id
	Integer ID;
	@JsonProperty("accountID")
	Integer account_id;
	@JsonProperty("datefield")
	String datefield;
	@JsonProperty("name")
	String amount;

}
