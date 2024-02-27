package com.mx.test.spring.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Taxis")
public class Taxis {
	  // Constructor con parametros  
	  public Taxis(int id, String plate) {
	        this.id = id;
	        this.plate = plate;
	    }
	// Constructor sin parametros
	  public Taxis() {
	        
	    }
	  
		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false)
        private int id;
		@Column(nullable = false)
        private String plate;
		
        public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPlate() {
			return plate;
		}
		public void setPlate(String plate) {
			this.plate = plate;
		}
}