/**
 * 
 */
package com.example.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LSA
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesertaModel {
	
	 private String nomor;
	 private String nama;
	 private Date tgl_lahir;
	 private String kode_prodi;
	 
	 private UnivModel univ;
	 private ProdiModel prodi;
	    
}
