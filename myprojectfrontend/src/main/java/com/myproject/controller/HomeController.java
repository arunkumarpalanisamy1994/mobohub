package com.myproject.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;
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
	@Autowired
	cartDAO c;

	@RequestMapping(value={"/","/home"})
	String indexPage(HttpSession session) {
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage(HttpSession session) {
		return "aboutus";
	}

	@RequestMapping("/contact")
	String contactPage(HttpSession session) {
		return "contact";
	}

	@RequestMapping("/signin")
	String signinPage(Model m,HttpSession session) {
		m.addAttribute("regmodel", new UserRegistration());
		return "signin";
	}

	@RequestMapping("/getuser")
	String getuser(@Valid @ModelAttribute("regmodel") UserRegistration r, BindingResult br, Model m,HttpSession session) {
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
	String Category(Model n,HttpSession session) {
		n.addAttribute("getCategory", new Category());
		n.addAttribute("cattable",k.showall());
		n.addAttribute("check",true);
		return "Category";
	}

	@RequestMapping("/addCategory")
	String addCategory(@Valid @ModelAttribute("getCategory") Category c, BindingResult br, Model n,HttpSession session) {
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
	String supplier(Model o,HttpSession session) {
		o.addAttribute("getsupplier", new supplier());
		o.addAttribute("suptable",l.showall());
		o.addAttribute("check",true);
		return "supplier";
	}

	@RequestMapping("/addsupplier")
	String addsupplier(@Valid @ModelAttribute("getsupplier") supplier x, BindingResult br, Model o,HttpSession session) {
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
	String product(Model p,HttpSession session) {
		p.addAttribute("getproduct", new product());
		p.addAttribute("protable",m.showall());
		p.addAttribute("check",true);
		return "product";
	}

	@RequestMapping("/addproduct")
	String addproduct(@Valid @ModelAttribute("getproduct") product y, BindingResult br, Model p,HttpSession session)throws Exception {
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
	String delcat(@PathVariable("cid") int id,HttpSession session)
	{
		k.deleteuser(id);
		return "redirect:/Category";
	}

	@RequestMapping("/Editcat")
	String Editcat(@RequestParam("catid")int id,Model n,HttpSession session)
	{
		n.addAttribute("getCategory",k.showone(id));
		n.addAttribute("cattable",k.showall());
		n.addAttribute("check",false);
		return "Category";
	}
	@RequestMapping("/delsup/{sid}")
	String delsup(@PathVariable("sid") int id,HttpSession session)
	{
		l.deleteuser(id);
		return "redirect:/supplier";
	}

	@RequestMapping("/Editsup")
	String Editsup(@RequestParam("supid")int id,Model o,HttpSession session)
	{
		o.addAttribute("getsupplier",l.showone(id));
		o.addAttribute("suptable",l.showall());
		o.addAttribute("check",false);
		return "supplier";
	}
	@RequestMapping("/delpro/{pid}")
	String delpro(@PathVariable("pid") int id,HttpSession session)
	{
		m.deleteuser(id);
		return "redirect:/product";
	}

	@RequestMapping("/Editpro")
	String Editpro(@RequestParam("proid")int id,Model p,HttpSession session)
	{
		p.addAttribute("getproduct", m.showone(id));
		p.addAttribute("protable", m.showall());
		p.addAttribute("check",false);
		return "product";
	}
	@RequestMapping("/updCategory")
	String updCategory(@Valid @ModelAttribute("getCategory") Category c, BindingResult br, Model n,HttpSession session) {
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
	String updsupplier(@Valid @ModelAttribute("getsupplier") supplier x, BindingResult br, Model o,HttpSession session) {
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
	String updproduct(@Valid @ModelAttribute("getproduct") product y, BindingResult br, Model p,HttpSession session) {
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
public String SignIncontroller(@RequestParam("email") String uname,@RequestParam("password") String pas,HttpSession session)
{
	System.out.println(uname);
	System.out.println(pas);
	List<UserRegistration> allUser=d.showall();
	boolean userExist=false;
	String username=null,userRole=null;
	boolean userloggedin=false;
	
/*	for(UserRegistration reg:allUser)
	{
		if(reg.getYourEmail().equals(uname)&&reg.getPassword().equals(pas))
		{
			userExist=true;
			username=reg.getName();
			userRole=reg.getRole();
			System.out.println(userRole+"0000000");
		}
	}*/
	
	UserRegistration usr=new UserRegistration();
	usr=d.singleuser(uname);
	
	if(usr.getPassword().equals(pas))
	{
		System.out.println(usr.getRole());
		System.out.println(usr.getYourEmail());
		userExist=true;
		username=usr.getName();
		userRole=usr.getRole();
		System.out.println(userRole+"0000000");
	}
	if(userExist)
	{
		
	session.setAttribute("username",username);
	System.out.println(username+"hehehe");
	session.setAttribute("userrole",userRole);
	System.out.println(userRole+"hehehe");
	session.setAttribute("userName",userloggedin);
	session.setAttribute("prototal", c.singleUserCart(username).size());
	return "redirect:/";
	}
	else
	{
		return "redirect:/signin";
	}
	
}
@RequestMapping("/logout")
public String logout(HttpSession session)
{
	session.invalidate();
	return "redirect:/";
}
@RequestMapping("/productlist")
String productlistpage(Model y,HttpSession session) 
{
	System.out.println(m.showall());
	y.addAttribute("promodel",new product());
	y.addAttribute("protable" ,m.showall());
	y.addAttribute("check", true);
	session.removeAttribute("prodtotal");
	session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
	return "productlist";
}

@RequestMapping("/hehe")
public String blah(@RequestParam("id") int prodid,Model y,HttpSession session)
{
	y.addAttribute("promodel",new product());
	y.addAttribute("protable" ,m.showone(prodid));
	return "singleproduct";
}


@RequestMapping("/addtocart/{id}/{uname}")
public String cartadd(@PathVariable("id") int prodid,@PathVariable("uname") String username,HttpSession session)
{
	product prod=new product();
	prod=m.showone(prodid);
	cart cart=new cart();
	cart.setCartid(username);
	cart.setPrice(prod.getPrice());
	cart.setProdid(prodid);
	cart.setProdname(prod.getName());
	cart.setQuantity(1);
	cart.setTotal(cart.getQuantity()*cart.getPrice());
	c.insertProductIntoCart(cart);
	return "redirect:/productlist";
}
@RequestMapping(value={"/addtocart/{getprodid}"})
public String insertProdttoCart(@PathVariable("getprodid") int ProdId,HttpSession session)
{
	try
	{
		product single=m.showone(ProdId);
			if(single.getId()==ProdId)
			{
				String username=(String) session.getAttribute("username");
				System.out.println(username);
				List<cart> singleuser=(c.singleUserCart(username));
				for(cart c:singleuser)
				{
					System.out.println(c.getCartid()+"     "+c.getProdname());
				}
					
				List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
				session.removeAttribute("prodtotal");

				if(singleprodfromcart.isEmpty())
				{
					cart cart=new cart();
					cart.setCartid((String)session.getAttribute("username"));
					cart.setProdid(single.getId());
					cart.setPrice((int)single.getPrice());
					cart.setQuantity(1);
					cart.setProdname(single.getName());
					cart.setTotal(cart.getQuantity()*cart.getPrice());
					c.insertProductIntoCart(cart);
					session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
				}
				else
				{
					singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()+1);
					singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
					c.updateproducttocart(singleprodfromcart.get(0));
					session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
				}
			}
		
	}
	catch(Exception e)
	{
		
	}
	
	return "redirect:/productlist";
}



@RequestMapping("/cart")
String cartPage(HttpSession session,Model m)
{
	
	String username=(String) session.getAttribute("UserLoggedIn");
	List<cart> singleuser=(c.singleUserCart(username));
	m.addAttribute("carobjstring", singleuser);
	return "cart";
}

@RequestMapping("/remove/{prodid}")
String removesup(@PathVariable("prodid")int id)
{
	if(c.deletecartproduct(id))
	{
		return "redirect:/cartpage";		
	}
	else
	{
		return "redirect:/cartpage";		
	}
}

@RequestMapping("/mycart")
public String cartpage(Model k,HttpSession session)
{
	int grandtotal=0;
	List<cart> temp=c.singleUserCart((String)session.getAttribute("username"));
	for(cart ca:temp)
	{
		grandtotal=grandtotal+(int)ca.getTotal();
	}
	k.addAttribute("protable",c.singleUserCart((String)session.getAttribute("username")) );
	k.addAttribute("total", grandtotal);
	
	return "viewcart";
}

@RequestMapping("/delcartprod/{pid}")
String delcartpro(@PathVariable("pid") int id,HttpSession session)
{
	c.deletecartproduct(id);
	session.removeAttribute("prodtotal");
	session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
	return "redirect:/mycart";
}
@RequestMapping("/inccart")
public String inccartprod(@RequestParam("getprodid") int ProdId,HttpSession session)
{
	try
	{
		product single=m.showone(ProdId);
			if(single.getId()==ProdId)
			{
				String username=(String) session.getAttribute("username");
				System.out.println(username);
				List<cart> singleuser=(c.singleUserCart(username));
				for(cart c:singleuser)
				{
					System.out.println(c.getCartid()+"     "+c.getProdname());
				}
					
				List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
				session.removeAttribute("prodtotal");
				if(singleprodfromcart.isEmpty())
				{
					cart cart=new cart();
					cart.setCartid((String)session.getAttribute("username"));
					cart.setProdid(single.getId());
					cart.setPrice((int)single.getPrice());
					cart.setQuantity(1);
					cart.setProdname(single.getName());
					cart.setTotal(cart.getQuantity()*cart.getPrice());
					c.insertProductIntoCart(cart);
					
					session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
				}
				else
				{
					singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()+1);
					singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
					c.updateproducttocart(singleprodfromcart.get(0));
					
					session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
					
				}
			}
		
	}
	catch(Exception e)
	{
		
	}
	
	return "redirect:/mycart";
}

	@RequestMapping("/redcart")
public String reducacart(@RequestParam("getprodid") int ProdId,HttpSession session)
{
	try
	{
		product single=m.showone(ProdId);
			if(single.getId()==ProdId)
			{
				String username=(String) session.getAttribute("username");
				System.out.println(username);
				List<cart> singleuser=(c.singleUserCart(username));
				for(cart c:singleuser)
				{
					System.out.println(c.getCartid()+"     "+c.getProdname());
				}
					
				List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
				
				
				if(!singleprodfromcart.isEmpty())
				{
					
					
					if(singleprodfromcart.get(0).getQuantity()>1)
					{
						singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()-1);
						singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
						c.updateproducttocart(singleprodfromcart.get(0));
						session.removeAttribute("prodtotal");
						session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("username")).size());
					}
					
				}
			}
		
	}
	catch(Exception e)
	{
		
	}
	
	return "redirect:/mycart";
}
	
	
	@RequestMapping("/checkout")
	public String checkout()
	{
		return "thanku";
	}

}

			
