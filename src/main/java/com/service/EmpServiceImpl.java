package com.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dto.EmpDto;
import com.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	
	EmpRepo emprepo;
	
	public EmpDto saveemployee(EmpDto empdto) {
		EmpDto x=emprepo.save(empdto);
		return x;
	}

	
	public EmpDto getemployee(Integer id) {
		EmpDto empdto = new EmpDto();
		Optional<EmpDto> obj =emprepo.findById(id);
		if(obj.isPresent()) {
			empdto=obj.get();	
	}
	return empdto;		
}


	
	public void updateemployee(EmpDto empdtoInput, Integer id) {
		Optional<EmpDto> obj = emprepo.findById(id);
		EmpDto empdto = obj.get();
		empdto.setId(empdtoInput.getId());
		empdto.setEmpname(empdtoInput.getEmpname());
		empdto.setMail(empdtoInput.getMail());
		emprepo.save(empdto);
	}


	
	public void deleteemployee(Integer id) {
		emprepo.deleteById(id);
		
	}

	public String getNameById(Integer id) {
		
		return emprepo.getNameById(id);
	}

	public List<String> getNames() {
		return emprepo.getNames();
	}
	
	public String getMailById(Integer id) {
		return emprepo.getMailById(id);
	}

	public List<String> getMails() {
		return emprepo.getMails();
		
	}
	
	

}
