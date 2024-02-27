package com.mx.test.spring.controller;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Trajectories")
public class Trajectories {   
	    // Constructor con parametros
	    public Trajectories(int id, int taxi_id, Timestamp date, double latitude, double longitude) {
	        this.id = id;
	        this.taxi_id = taxi_id;
	        this.date = date;
	        this.latitude = latitude;
	        this.longitude = longitude;
	    }
	    
	    
	    
	    public Timestamp getDate() {
			return date;
		}



		public void setDate(Timestamp date) {
			this.date = date;
		}



		// Constructor sin parametros
	    public Trajectories() {
	    }
	
		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false)
        private int id;
		
		@Column(nullable = false)
        private int taxi_id;
		
        @Column(nullable = false)
        private Timestamp date;
        
        @Column(nullable = false)
        private double latitude;
        
        @Column(nullable = false)
        private double longitude; 
        

        
        public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public int getTaxi_id() {
			return taxi_id;
		}
		public void setTaxi_id(int taxi_id) {
			this.taxi_id = taxi_id;
		}
		

		


		public double getLatitude() {
			return latitude;
		}


		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
}
