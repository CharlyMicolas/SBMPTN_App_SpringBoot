package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PesertaMapper;
import com.example.model.PesertaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PesertaServiceDatabase implements PesertaService
{
	@Autowired
	private PesertaMapper pesertaMapper;

	@Override
	public PesertaModel selectPeserta(String nomor) {
		// TODO Auto-generated method stub
		log.info ("select peserta");
        return pesertaMapper.selectPeserta (nomor);
	}

	@Override
	public List<PesertaModel> selectAllPeserta() {
		// TODO Auto-generated method stub
		log.info ("select all peserta");
		return pesertaMapper.selectAllPeserta ();
	}

	@Override
	public void addPeserta(PesertaModel peserta) {
		// TODO Auto-generated method stub
		log.info ("add peserta");
		 pesertaMapper.addPeserta (peserta);
		
	}

	@Override
	public void deletePeserta(String nomor) {
		// TODO Auto-generated method stub
		log.info ("delete peserta");
		pesertaMapper.deletePeserta(nomor);
		
	}

	@Override
	public void updatePeserta(PesertaModel peserta) {
		// TODO Auto-generated method stub
		log.info ("update peserta");
		pesertaMapper.updatePeserta(peserta);
		
	}


}
