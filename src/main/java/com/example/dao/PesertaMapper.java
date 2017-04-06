package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.PesertaModel;

@Mapper
public interface PesertaMapper {

	PesertaModel selectPeserta(String nomor);

	List<PesertaModel> selectAllPeserta();

	void addPeserta(PesertaModel peserta);

	void deletePeserta(String nomor);

	void updatePeserta(PesertaModel peserta);

}
