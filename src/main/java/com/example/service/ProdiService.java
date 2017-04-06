package com.example.service;

import java.util.List;

import com.example.model.ProdiModel;



public interface ProdiService {
	ProdiModel selectProdi (String kode_prodi);
    List<ProdiModel> selectAllProdi ();
    void addProdi (ProdiModel prodi);
    void deleteProdi (String kode_prodi);
    void updateProdi (ProdiModel prodi);
	

}
