package com.example.service;

import java.util.List;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;



public interface ProdiService {
	ProdiModel selectProdi (String kode_prodi);
    List<ProdiModel> selectAllProdi ();
    void addProdi (ProdiModel prodi);
    void deleteProdi (String kode_prodi);
    void updateProdi (ProdiModel prodi);
	
    PesertaModel selectPesertaTermuda(String kode_prodi);
    PesertaModel selectPesertaTertua(String kode_prodi);
    

}
