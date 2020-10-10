package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "cinema")
	public class Cinema  {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cinemaid")
		private Integer cinemaId;
		@Column(name = "name")
		private String name;
		@Column (name = "address")
		private String address;
		public Integer getCinemaId() {
			return cinemaId;
		}
		public void setCinemaId(Integer cinemaId) {
			this.cinemaId = cinemaId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Cinema [cinemaId=" + cinemaId + ", name=" + name + ", address=" + address + "]";
		}
		
		public Cinema(String name, String address) {
			this.name= name;
			this.address= address;
			
		}
		
		public Cinema() {
			
		}

}
