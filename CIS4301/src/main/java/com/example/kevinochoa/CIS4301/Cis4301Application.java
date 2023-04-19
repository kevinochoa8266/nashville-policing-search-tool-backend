package com.example.kevinochoa.CIS4301;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Cis4301Application{

	private static DAO<Subject> dao;

	public Cis4301Application(DAO<Subject> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Cis4301Application.class, args);

		List<Subject> subjects = dao.list();
		System.out.println(subjects.size());
	}

}
