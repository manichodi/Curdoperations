package com.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.controllers.EmpController;
import com.dto.EmpDto;
import com.service.EmpService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class EmpControllerTest {

	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	EmpController obj;

	@Mock
	private EmpService service;

	@Test
	public void saveemployeeTest() {

		EmpDto empDto = new EmpDto();
		empDto.setId(1);
		empDto.setEmpname("nag");
		empDto.setMail("nag@com.in");
		when(service.saveemployee(empDto)).thenReturn(empDto);
		obj.saveemployee(empDto);
	}
	public void getemployeeTest() {
		
		EmpDto empDto = new EmpDto();
		empDto.setId(2);
		empDto.setEmpname("mani");
		empDto.setMail("mani@gmail.com");
		when(service.getemployee(2)).thenReturn(empDto);
		obj.getemployee(2);
	}
	
	@Test
	public void getNamesTest() {
		when(service.getNames()).thenReturn(new ArrayList<String>());
		obj.getNames();
	}
	
	@Test
	public void getNameByIdTest() {
		when(service.getNameById(null)).thenReturn(new String("demo"));
		obj.getNameById(null);
	}
	
	@Test
	public void getMailsTest() {
		when(service.getMails()).thenReturn(new ArrayList<String>());
		obj.getMails();
	}
	
	@Test
	public void getMailByIdTest() {
		when(service.getMailById(2)).thenReturn(new String("test"));
		obj.getMailById(2);
	}
}
