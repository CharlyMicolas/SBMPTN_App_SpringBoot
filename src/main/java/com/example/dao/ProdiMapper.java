package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.ProdiModel;

@Mapper
public interface ProdiMapper {

	ProdiModel selectProdi(String kode_prodi);

	List<ProdiModel> selectAllProdi();

	void addProdi(ProdiModel prodi);

	void deleteProdi(String kode_prodi);

	void updateProdi(ProdiModel prodi);

}
