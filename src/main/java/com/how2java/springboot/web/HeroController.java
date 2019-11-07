package com.how2java.springboot.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.pojo.Hero;
import com.how2java.springboot.service.HeroService;
 
@RestController
public class HeroController {
	@Autowired HeroService heroService;
	
	/*postman*/
	 @GetMapping("/heroes")
	    public List<Hero> list() throws Exception {
	    	
	        List<Hero> cs=heroService.list();
	      
	        System.out.println(cs.size());
	        System.out.println("list success");

	        return cs;
	    }
    
    @GetMapping("/hero/{id}")
    public Hero get(@PathVariable("id") int id) throws Exception {
    	
    	Hero h=heroService.get(id);
    	
        return h;
    }
    
    @PostMapping("/hero")
    public String add(@RequestBody Hero h) throws Exception {
        heroService.add(h);
        return "success";
    }
    @DeleteMapping("/hero/{id}")
    public String delete(Hero h) throws Exception {
    	
        heroService.delete(h.getId());
        
        return "success";
    }
    @PutMapping("/hero/{id}")
    public String update(@RequestBody Hero h) throws Exception {
        heroService.update(h);
        
        return "success"+h.getName();
    }
    

    @RequestMapping(value="/listHero", method=RequestMethod.GET)
    public ModelAndView listHero(){
        ModelAndView mv = new ModelAndView("listHero");
        List<Hero> cs=heroService.list();
        mv.addObject("cs", cs);
        return mv;
    }
      
}

