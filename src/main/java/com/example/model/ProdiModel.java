package com.example.model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiModel {  
	 private String kode_univ;
	 private String kode_prodi;
	 private String nama_prodi;
	 
	 private UnivModel univ;
	 private List<PesertaModel> paraPeserta;
	
}
