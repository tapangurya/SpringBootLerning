package com.example.secondProject.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.secondProject.Berlin.Service.BerlinService;
import com.example.secondProject.BerlinDto.BerlinDto;

@Controller
@RequestMapping("/berlins")

public class BerlinControiller {
	@Autowired
	BerlinService berlinService;
	@Autowired
	ModelAndView mav;

	@GetMapping("/index")
	public String Index() {
		return "index.html";
	}
////////////////////////////////////////////////////////////////////
	@GetMapping("/cih")
	public String callinsertHtml() {
		return "insert.html";
	}

	
	@PostMapping("/insert")
	public ModelAndView insert(@ModelAttribute BerlinDto berlinDto) {
		String bd = berlinService.insert(berlinDto);
		mav.addObject("msg",bd);
		mav.setViewName("insert.html");
		return mav;
		
		
	}
	
	/////////////////////////////////////////////////////////
	@GetMapping("/fetchById")
	public String fetchById() {
		return "fetchbyid.html";
		
	}
	
	@PostMapping("/fid")
	public ModelAndView fetchById(@ModelAttribute BerlinDto bd) {
	   
	    BerlinDto berlinDto = berlinService.fetchByid(bd.getId());

	    if (berlinDto != null) {
	        mav.addObject("berlinData", berlinDto);  
	        mav.setViewName("result.html");
	    } 
	    else 
	    {
	        mav.addObject("errorMessage", "No data found: " + bd.getId());
	        mav.setViewName("fetchbyid.html");
	    }

	   
	    return mav;
	}

	
	
	/////////////////////////////////////////////// DELETE BY ID//////////////////////////////////
	@GetMapping("/deletebyid")
	public String DeleteById() {
		return "deletebyid.html";
		
	}
	
	
	
	@PostMapping("/did")
	public ModelAndView  deleteById(@ModelAttribute BerlinDto berlinDto) {
		String msg= berlinService.deleteById(berlinDto.getId())  ;
		
		mav.addObject("msg",msg);
		mav.setViewName("deletebyid.html");
		return mav;
	}
	////////////////////////////////////////////////
	
	
	
	
	@RequestMapping("/dall")
	public ModelAndView deleteAll() {
		String msg= berlinService.deleteAll();
		mav.addObject("msg",msg);
		mav.setViewName("index.html");
		return mav;
	}
	
	////////////////////////////////////////////////
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		List<BerlinDto> berlinDto = berlinService.findAll();

	    if (berlinDto != null) {
	        mav.addObject("berlinDatas", berlinDto);  // Pass single object, not a list
	    } else {
	        mav.addObject("errorMessage", "No data found" );
	    }

	    mav.setViewName("findall.html");
		return mav;
		
	}
	
	//////////////////////////////////////////////////////////Update//////////////////////////////////////////////////////
	@GetMapping("/find")
	public String fetch() {
		return "find.html";
		
	}
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute BerlinDto bd) {
		BerlinDto d =berlinService.update(bd.getId());
		if(d!=null) {
			mav.addObject("update",d);
		}
		else {
			 mav.addObject("errorMessage", "No data found for email: " );
		}
		mav.setViewName("update.html");
		
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView supdate (@ModelAttribute BerlinDto berlinDto) {
		String msg= berlinService.update(berlinDto);
		mav.addObject("msg",msg);
		mav.setViewName("fetchbyid.html");
		return mav;
		
	}
   
}
