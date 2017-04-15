package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.PesertaModel;
import com.example.service.PesertaService;


@Controller
public class PesertaController {
	
	
	@Autowired
    PesertaService pesertaDAO;
	
	@RequestMapping("/")
    public String index ()
    {
        return "index";
    }
	
	@PostMapping("/pengumuman/submit")
	public String updateSubmit (Model model, @ModelAttribute PesertaModel peserta)
	{
		PesertaModel pesertaLulus = pesertaDAO.selectPeserta(peserta.getNomor());
		
   	 	if (pesertaLulus != null) {
   	 	int umur= pesertaDAO.hitungUmur(pesertaLulus.getTgl_lahir());
   	 		if(pesertaLulus.getKode_prodi() != null){
   	 			
	   	 		model.addAttribute ("pesertaLulus", pesertaLulus);
	   	 		model.addAttribute ("umur", umur);
		        return "viewLulus";
   	 		}
   	 		
            else{
	        	model.addAttribute ("pesertaLulus", pesertaLulus);
	        	model.addAttribute ("umur", umur);
	            return "viewGagal";
            }
        }
        else{
        	model.addAttribute ("nomor", peserta.getNomor());
        	return "viewNotFoundPeserta";
        }
   	 }
	
	@RequestMapping("/peserta")
    public String viewPeserta (Model model, @RequestParam(value = "nomor", required = true) String nomor)
    {
        PesertaModel peserta = pesertaDAO.selectPeserta (nomor);
        
        if (peserta != null) {
        	int umur= pesertaDAO.hitungUmur(peserta.getTgl_lahir());
            model.addAttribute ("peserta",peserta);
            model.addAttribute ("umur", umur);
            return "viewPeserta";
        } else {
            model.addAttribute ("nomor", nomor);
            return "viewNotFoundPeserta";
        }
        
    }

}
