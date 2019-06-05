package com.ford.fcsd.fordprotect.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ford.fcsd.fordprotect.json.CustomLocalDateDeserializer;
import com.ford.fcsd.fordprotect.json.CustomLocalDateSerializer;

public class FP2InvoiceDTO {
	
	@JsonProperty("invoice_id")
	private Integer id;
	
	@JsonProperty("invoice_description")
	private String description;
	
	@JsonProperty("invoice_date")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	private LocalDate date;
	
	public FP2InvoiceDTO() {
	}

	public FP2InvoiceDTO(Integer id, String description, LocalDate date) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FP2InvoiceDTO [id=" + id + ", description=" + description + ", date=" + date + "]";
	}
	
}