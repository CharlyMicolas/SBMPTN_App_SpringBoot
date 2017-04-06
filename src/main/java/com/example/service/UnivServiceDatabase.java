package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dao.UnivMapper;
import com.example.model.UnivModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UnivServiceDatabase implements UnivService {
	
	@Autowired
	private UnivMapper univMapper;
	
	@Override
	public UnivModel selectUniv(String kode_univ) {
		// TODO Auto-generated method stub
		log.info ("select univ");
		return univMapper.selectUniv (kode_univ);
	}

	@Override
	public List<UnivModel> selectAllUniv() {
		// TODO Auto-generated method stub
		log.info ("select all univ");
		return univMapper.selectAllUniv ();
	}

	@Override
	public void addUniv(UnivModel univ) {
		// TODO Auto-generated method stub
		log.info ("add univ");
		univMapper.addUniv (univ);
		
	}

	@Override
	public void deleteUniv(String kode_univ) {
		// TODO Auto-generated method stub
		log.info ("delete univ");
		univMapper.deleteUniv(kode_univ);
		
	}

	@Override
	public void updateUniv(UnivModel univ) {
		// TODO Auto-generated method stub
		log.info ("update univ");
		univMapper.updateUniv(univ);
		
	}

}
