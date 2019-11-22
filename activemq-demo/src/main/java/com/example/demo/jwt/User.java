package com.example.demo.jwt;

import java.io.Serializable;

public class User implements Serializable{
	 private static final long serialVersionUID = 1L;

	    private Integer id;
	    private String userName;
	    private String name;
	    private String password;
	    
	    
		public User(Integer id, String userName, String name, String password) {
			super();
			this.id = id;
			this.userName = userName;
			this.name = name;
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", password=" + password + "]";
		}
	    
}
