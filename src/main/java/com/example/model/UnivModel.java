package com.example.model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnivModel {
	  
	 private String kode_univ;
	 private String nama_univ;
	 private String url_univ;
	 
	 private List<ProdiModel> prodis;
}
