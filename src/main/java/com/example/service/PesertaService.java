package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.model.PesertaModel;



public interface PesertaService {
	PesertaModel selectPeserta (String nomor);

    List<PesertaModel> selectAllPeserta ();
    
    void addPeserta (PesertaModel peserta);
    
    void deletePeserta (String nomor);
    
    void updatePeserta (PesertaModel peserta);

    int hitungUmur(Date tgl_lahir);
    
    

}
