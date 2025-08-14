package com.example.Expenses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
	public class Users 
	{
		@Id
		private String number;
		private String username;
		private String password;
		private String mail;
		
		public Users() {
			super();
		}
		public Users(String number, String username, String password, String mail) {
			super();
			this.number = number;
			this.username = username;
			this.password = password;
			this.mail = mail;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		
		
			}
		



