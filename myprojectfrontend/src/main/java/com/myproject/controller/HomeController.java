package com.myproject.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.DAO.*;
import com.myproject.model.*;
@Entity
@Controller
public class HomeController {
	@Autowired
	UserRegistrationDAO d;
	@Autowired
	CategoryDAO k;
	@Autowired
	supplierDAO l;
	@Autowired
	productDAO m;

	@RequestMapping(value={"/","/home"})
	String indexPage() {
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage() {
		return "aboutus";
	}

	@RequestMapping("/contact")
	String contactPage() {
		return "contact";
	}

	@RequestMapping("/signin")
	String signinPage(Model m) {
		m.addAttribute("regmodel", new UserRegistration());
		return "signin";
	}

	@RequestMapping("/getuser")
	String getuser(@Valid @ModelAttribute("regmodel") UserRegistration r, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("regmodel", r);
			return "signin";
		} else {
			if (d.insertuser(r))
				return "signin";
			else {
				m.addAttribute("regmodel", r);
				return "signin";
			}
		}
	}

	@RequestMapping("/Category")
	String Category(Model n) {
		n.addAttribute("getCategory", new Category());
		n.addAttribute("cattable",k.showall());
		n.addAttribute("check",true);
		return "Category";
	}

	@RequestMapping("/addCategory")
	String addCategory(@Valid @ModelAttribute("getCategory") Category c, BindingResult br, Model n) {
		if (br.hasErrors()) {
			n.addAttribute("getCategory", c);
			return "Category";
		} else {
			if (k.insertuser(c)) {
				n.addAttribute("getCategory",c);
				return "redirect:/Category";
			} else {
				n.addAttribute("getCategory",c);
				n.addAttribute("cattable",k.showall());
				return "Category";
			}
		}
	}

	@RequestMapping("/supplier")
	String supplier(Model o) {
		o.addAttribute("getsupplier", new supplier());
		o.addAttribute("suptable",l.showall());
		o.addAttribute("check",true);
		return "supplier";
	}

	@RequestMapping("/addsupplier")
	String addsupplier(@Valid @ModelAttribute("getsupplier") supplier x, BindingResult br, Model o) {
		if (br.hasErrors()) {
			o.addAttribute("getsupplier",x);
			return "supplier";
		} else {
			if (l.insertuser(x)) {
				o.addAttribute("getsupplier",x);
				return "redirect:/supplier";
			} else {
				o.addAttribute("getsupplier",x);
				o.addAttribute("suptable",l.showall());
				return "supplier";
			}
		}
	}

	@RequestMapping("/product")
	String product(Model p) {
		p.addAttribute("getproduct", new product());
		p.addAttribute("protable",m.showall());
		p.addAttribute("check",true);
		return "product";
	}

	@RequestMapping("/addproduct")
	String addproduct(@Valid @ModelAttribute("getproduct") product y, BindingResult br, Model p)throws Exception {
		if (br.hasErrors()) {
			p.addAttribute("getproduct",y);
			return "product";
		} else {
			if (m.insertuser(y)) {
				p.addAttribute("getproduct",y);
				String filePath="D:\\project\\myprojectfrontend\\src\\main\\webapp\\resources\\productImages\\";
				filePath=filePath+y.getId()+""+".jpg";
				File f=new File(filePath);
				MultipartFile imagefile=y.getProductImage();
				if(!f.exists())
				{
					byte[] imageBytes=imagefile.getBytes();
					FileOutputStream fileOutputStream=new FileOutputStream(f);
					BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
					bufferedOutputStream.write(imageBytes);
					bufferedOutputStream.close();
					fileOutputStream.close();
				}
				
				return "redirect:/product";
			} else {
				p.addAttribute("getproduct",y);
				p.addAttribute("protable",m.showall());
				return "product";
			}
		}
	}
	
	@RequestMapping("/delcat/{cid}")
	String delcat(@PathVariable("cid") int id)
	{
		k.deleteuser(id);
		return "redirect:/Category";
	}

	@RequestMapping("/Editcat")
	String Editcat(@RequestParam("catid")int id,Model n)
	{
		n.addAttribute("getCategory",k.showone(id));
		n.addAttribute("cattable",k.showall());
		n.addAttribute("check",false);
		return "Category";
	}
	@RequestMapping("/delsup/{sid}")
	String delsup(@PathVariable("sid") int id)
	{
		l.deleteuser(id);
		return "redirect:/supplier";
	}

	@RequestMapping("/Editsup")
	String Editsup(@RequestParam("supid")int id,Model o)
	{
		o.addAttribute("getsupplier",l.showone(id));
		o.addAttribute("suptable",l.showall());
		o.addAttribute("check",false);
		return "supplier";
	}
	@RequestMapping("/delpro/{pid}")
	String delpro(@PathVariable("pid") int id)
	{
		m.deleteuser(id);
		return "redirect:/product";
	}

	@RequestMapping("/Editpro")
	String Editpro(@RequestParam("proid")int id,Model p)
	{
		p.addAttribute("getproduct", m.showone(id));
		p.addAttribute("protable", m.showall());
		p.addAttribute("check",false);
		return "product";
	}
	@RequestMapping("/updCategory")
	String updCategory(@Valid @ModelAttribute("getCategory") Category c, BindingResult br, Model n) {
		if (br.hasErrors()) {
			n.addAttribute("getCategory", c);
			return "Category";
		} else {
			if (k.updateuser(c)) {
				n.addAttribute("getCategory",c);
				return "redirect:/Category";
			} else {
				n.addAttribute("getCategory",c);
				n.addAttribute("cattable",k.showall());
				return "Category";
			}
		}

}
	@RequestMapping("/updsupplier")
	String updsupplier(@Valid @ModelAttribute("getsupplier") supplier x, BindingResult br, Model o) {
		if (br.hasErrors()) {
			o.addAttribute("getsupplier",x);
			return "supplier";
		} else {
			if (l.updateuser(x)) {
				o.addAttribute("getsupplier",x);
				return "redirect:/supplier";
			} else {
				o.addAttribute("getsupplier",x);
				o.addAttribute("suptable",l.showall());
				return "supplier";
			}
		}
}
	@RequestMapping("/updproduct")
	String updproduct(@Valid @ModelAttribute("getproduct") product y, BindingResult br, Model p) {
		if (br.hasErrors()) {
			p.addAttribute("getproduct",y);
			return "product";
		} else {
			if (m.updateuser(y)) {
				p.addAttribute("getproduct",y);
				return "redirect:/product";
			} else {
				p.addAttribute("getproduct",y);
				p.addAttribute("protable",m.showall());
				return "product";
			}
		}
	}
@RequestMapping(value={"/SignIn"},method=RequestMethod.GET)
public String SignIncontroller(@RequestParam("email") String uname,@RequestParam("password") String pas)
{
	System.out.println(uname);
	System.out.println(pas);
	List<UserRegistration> allUser=d.showall();
	boolean userExist=false;
	for(UserRegistration reg:allUser)
	{
		if(reg.getYourEmail().equals(uname)&&reg.getPassword().equals(pas))
		{
			userExist=true;
		}
	}
	if(userExist)
	{
	System.out.println("welcome Mr./Mrs. "+uname);
	return "index";
	}
	else
	{
		return "redirect:/signin";
	}

	
}

}