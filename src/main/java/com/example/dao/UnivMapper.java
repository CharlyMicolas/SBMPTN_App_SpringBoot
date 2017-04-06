package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.UnivModel;

@Mapper
public interface UnivMapper {

	UnivModel selectUniv(String kode_univ);

	List<UnivModel> selectAllUniv();

	void addUniv(UnivModel univ);

	void deleteUniv(String kode_univ);

	void updateUniv(UnivModel univ);

}
