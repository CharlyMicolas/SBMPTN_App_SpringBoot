package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.UnivModel;
import com.example.service.UnivService;


@Controller
public class UnivController {
	
	@Autowired
    UnivService univDAO;
	
	
	@RequestMapping("/univ")
	public String viewAll(Model model)
	{
	    List<UnivModel> univs = univDAO.selectAllUniv ();
	    model.addAttribute ("univs", univs);
	    return "viewAllUniv";
	}
	
	@RequestMapping("/univ/{kode_univ}")
	public String viewDetail(Model model, @PathVariable(value = "kode_univ") String kode_univ)
	{
		UnivModel univ = univDAO.selectUniv(kode_univ);
	    if (univ != null) {
	    	model.addAttribute ("univ", univ);
	            return "viewUniv";
	    }else{
	    	model.addAttribute ("kode_univ", kode_univ);
	            return "viewNotFoundUniv";
	    }
	}

}
