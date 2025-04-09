package com.moetez.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomChien", types = { Chien.class })
public interface ChienProjection {
	public String getNom();
}
