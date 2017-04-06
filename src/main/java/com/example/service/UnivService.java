package com.example.service;

import java.util.List;


import com.example.model.UnivModel;

public interface UnivService {
	
	UnivModel selectUniv (String kode_univ);
    List<UnivModel> selectAllUniv ();
    void addUniv (UnivModel univ);
    void deleteUniv (String kode_univ);
    void updateUniv (UnivModel univ);
}
