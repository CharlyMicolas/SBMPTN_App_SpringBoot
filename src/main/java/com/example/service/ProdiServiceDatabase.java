package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dao.ProdiMapper;
import com.example.model.ProdiModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdiServiceDatabase implements ProdiService {

	@Autowired
	private ProdiMapper prodiMapper;
	
	@Override
	public ProdiModel selectProdi(String kode_prodi) {
		// TODO Auto-generated method stub
		log.info ("select prodi");
		return prodiMapper.selectProdi (kode_prodi);
	}

	@Override
	public List<ProdiModel> selectAllProdi() {
		// TODO Auto-generated method stub
		log.info ("select all prodi");
		return prodiMapper.selectAllProdi ();
	}

	@Override
	public void addProdi(ProdiModel prodi) {
		// TODO Auto-generated method stub
		log.info ("add peserta");
		prodiMapper.addProdi (prodi);
		
	}

	@Override
	public void deleteProdi(String kode_prodi) {
		// TODO Auto-generated method stub
		log.info ("delete peserta");
		prodiMapper.deleteProdi(kode_prodi);
		
	}

	@Override
	public void updateProdi(ProdiModel prodi) {
		// TODO Auto-generated method stub
		log.info ("update peserta");
		prodiMapper.updateProdi(prodi);
		
	}

}
