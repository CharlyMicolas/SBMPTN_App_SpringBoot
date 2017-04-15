package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

	@Override
	public int hitungUmur(Date tgl_lahir) {
		// TODO Auto-generated method stub
		Date now = new Date();
		long diff = now.getTime() - tgl_lahir.getTime();
		int umur = (int)(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))/365;
		return umur;
	}

	
	
	
	


	


}
