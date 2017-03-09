package org.sprouts.backend.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegerId {
	
    @JsonProperty("id")
    private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}