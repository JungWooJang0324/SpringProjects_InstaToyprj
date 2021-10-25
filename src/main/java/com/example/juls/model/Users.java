package com.example.juls.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@SequenceGenerator(
		name="USER_SEQ_GEN",
		sequenceName = "USER_SEQ",
		initialValue=1,	//시작값
		allocationSize=1	//메모리를 통한 할당할 범위사이즈
		)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator="USER_SEQ_GEN")
	private int id;
	private String username;
	private String password;
	private String name;
	private String website;
	private String bio;
	private String email;
	private String phone;
	private String gender;
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
	
}
