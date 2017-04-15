package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.service.PesertaService;
import com.example.service.ProdiService;



@Controller
public class ProdiController {
	
	@Autowired
    ProdiService prodiDAO;
	
	@Autowired
	PesertaService pesertaDAO;
	
	@RequestMapping("/prodi")
    public String viewProdi (Model model, @RequestParam(value = "kode", required = true) String kode_prodi)
    {
        ProdiModel prodi = prodiDAO.selectProdi (kode_prodi);
        PesertaModel pesertaTertua = prodiDAO.selectPesertaTertua(kode_prodi);
        PesertaModel pesertaTermuda = prodiDAO.selectPesertaTermuda(kode_prodi);
        
        if (prodi != null) {
        	System.out.println(prodi.getNama_prodi());
        	
        	model.addAttribute ("prodi",prodi);
        	model.addAttribute("pesertaTertua",pesertaTertua);
        	int umur= pesertaDAO.hitungUmur(pesertaTertua.getTgl_lahir());
        	model.addAttribute("umurTua", umur);
        	model.addAttribute("pesertaTermuda",pesertaTermuda);
        	int umur2 = pesertaDAO.hitungUmur(pesertaTermuda.getTgl_lahir());
        	model.addAttribute("umurMuda", umur2);
            return "viewProdi";
        } else {
            model.addAttribute ("kode_prodi", kode_prodi);
            return "viewNotFoundProdi";
        }
        
    }


	@GetMapping("/prodi/insert/{kode_univ}")
	public String add(Model model, @PathVariable(value = "kode_univ") String kode_univ)
	{
		ProdiModel prodi = new ProdiModel(kode_univ, null, null, null, null);
		model.addAttribute ("prodi", prodi);
		return "formAddProdi";
	}
	 
	 
	@RequestMapping("/prodi/insert/submit")
	public String addSubmit (@ModelAttribute ProdiModel prodi)
	{
		prodiDAO.addProdi(prodi);
	    return "success";
	}
	
	@GetMapping("/prodi/update/{kode_prodi}")
	public String updateDosen (Model model, @PathVariable(value = "kode_prodi") String kode_prodi)
	{	
		ProdiModel prodi = prodiDAO.selectProdi(kode_prodi);
	    if (prodi != null) {
		    model.addAttribute ("prodi", prodi);
		    return "formUpdateProdi";
		}else{
			model.addAttribute ("kode_prodi", kode_prodi);
	        return "viewNotFoundProdi";
	    }
	}
	    
	@PostMapping("/prodi/update/submit")
	public String updateSubmit (@ModelAttribute ProdiModel prodi)
	{
		prodiDAO.updateProdi (prodi);
	    return "success";
	}
	
	@RequestMapping("/prodi/delete/{kode_prodi}")
	public String deleteProdi(Model model, @PathVariable(value = "kode_prodi") String kode_prodi)
	{	
		ProdiModel prodi = prodiDAO.selectProdi (kode_prodi);
		if (prodi != null) {
			prodiDAO.deleteProdi (kode_prodi);
	        return "delete";
	    } else {
	        model.addAttribute ("kode_prodi", kode_prodi);
	        return "viewNotFoundProdi";
	    }       
	}
	
	
		
	

}
