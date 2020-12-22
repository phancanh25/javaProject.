package group10.bookShop.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Random;

import group10.bookShop.entities.Cart;
import group10.bookShop.entities.Hoadon;
import group10.bookShop.entities.Kinhte;
import group10.bookShop.entities.Kynangsong;
import group10.bookShop.entities.Nuoidaycon;
import group10.bookShop.entities.Sach;
import group10.bookShop.entities.Sachgiaokhoa;
import group10.bookShop.entities.Sachngoaingu;
import group10.bookShop.entities.Thieunhi;
import group10.bookShop.entities.User;
import group10.bookShop.entities.Vanhocnuocngoai;
import group10.bookShop.entities.Vanhoctrongnuoc;
import group10.bookShop.service.cart.CartService;
import group10.bookShop.service.hoadon.HoadonService;
import group10.bookShop.service.kinhte.KinhteService;
import group10.bookShop.service.kynangsong.KynangsongService;
import group10.bookShop.service.nuoidaycon.NuoidayconService;
import group10.bookShop.service.sach.SachService;
import group10.bookShop.service.sachgiaokhoa.SachgiaokhoaService;
import group10.bookShop.service.sachngoaingu.SachngoainguService;
import group10.bookShop.service.thieunhi.ThieunhiService;
import group10.bookShop.service.user.UserService;
import group10.bookShop.service.vanhocnuocngoai.VanhocnuocngoaiService;
import group10.bookShop.service.vanhoctrongnuoc.VanhoctrongnuocService;

@Controller
public class SachController {
	
    private final String UPLOAD_DIR = "src/main/resources/static/image/";
	
	@Autowired(required = true)
	private SachService bookService;
	
	@Autowired(required = true)
	private KinhteService kinhteService;
	
	@Autowired(required = true)
	private KynangsongService kynangsongService;

	@Autowired(required = true)
	private NuoidayconService nuoidayconService;
	
	@Autowired(required = true)
	private SachgiaokhoaService sachgiaokhoaService;
	
	@Autowired(required = true)
	private SachngoainguService sachngoainguService;
	
	@Autowired(required = true)
	private ThieunhiService thieunhiService;
	
	@Autowired(required = true)
	private VanhocnuocngoaiService vanhocnuocngoaiService;
	
	@Autowired(required = true)
	private VanhoctrongnuocService vanhoctrongnuocService;
	
	@Autowired(required = true)
	private HoadonService hoadonService;
	
	@Autowired(required = true)
	private CartService cartService;
	
	@Autowired(required = true)
	private UserService userService;
	
	@GetMapping("/book")
	public String list(Model model) {
		try {
			model.addAttribute("books", bookService.findMasachDesc()); // controller gọi service yêu cầu dữ liệu.
			model.addAttribute("views", bookService.findLuocxemDesc()); // controller gọi service yêu cầu dữ liệu.
			model.addAttribute("bestSellers", bookService.findSoluongdabanDesc()); // controller gọi service yêu cầu dữ liệu.

			model.addAttribute("foreignLanguages", sachngoainguService.findAll()); // controller gọi service yêu cầu dữ liệu.
			model.addAttribute("domestics", vanhoctrongnuocService.findAll()); // controller gọi service yêu cầu dữ liệu.
			model.addAttribute("foreigns", vanhocnuocngoaiService.findAll());
			model.addAttribute("kids", thieunhiService.findAll());
			model.addAttribute("lifeSkills", kynangsongService.findAll());
			model.addAttribute("economics", kinhteService.findAll());
			model.addAttribute("cares", nuoidayconService.findAll());
			
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "index";
	}
	
	@GetMapping("/book/foreignLanguage")
	public String foreignLanguage(Model model) {
		try {
			model.addAttribute("foreignLanguages", sachngoainguService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/foreignLanguage";
	}
	
	
	@GetMapping("/book/domestic")
	public String domestic (Model model) {
		try {
			model.addAttribute("domestics", vanhoctrongnuocService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/domestic";
	}
	
	
	@GetMapping("/book/foreign")
	public String foreign(Model model) {
		try {
			model.addAttribute("foreigns", vanhocnuocngoaiService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/foreign";
	}
	
	@GetMapping("/book/kid")
	public String kid(Model model) {
		try {
			model.addAttribute("kids", thieunhiService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/kid";
	}
	
	@GetMapping("/book/lifeSkill")
	public String lifeSkill(Model model) {
		try {
			model.addAttribute("lifeSkills", kynangsongService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/lifeSkill";
	}
	
	@GetMapping("/book/rear")
	public String rear(Model model) {
		try {
			model.addAttribute("rears", nuoidayconService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/rear";
	}
	
	@GetMapping("/book/economic")
	public String economic(Model model) {
		try {
			model.addAttribute("economics", kinhteService.findAll());
		}catch(NullPointerException e) {
			model.addAttribute("errorMessage", e);
		}
		
		return "/theloai/economic";
	}
	
	@GetMapping("/book/search")
	public String search (@RequestParam("name") String name, Model model) {
		if(org.springframework.util.StringUtils.isEmpty(name)) {
			return "redirect:/book";
		}
//		System.out.println(contactService.search(name));
		model.addAttribute("results", bookService.search(name));
		return "search";
	}
	
	@GetMapping("/book/add")
	public String add(Model model) {
	    model.addAttribute("book", new Sach());  // khởi tạo mới 1 đối tượng và gửi lên form Mỗi thuộc tính của contact tương ứng với một input trong form.
	    return "addBook";
	}
	
	@GetMapping("/book/{masach}/detail")
	public String detail(@PathVariable("masach") Integer masach, Model model) {
		    Sach book = bookService.findById(masach);
		    String currentCategory = book.getTheloai();
		    
		    int currentViews = book.getLuocxem();
		    book.setLuocxem(currentViews += 1);
		    bookService.save(book);
		    
		    // random the loai khac 
//		    String[] theloai = {"kinhteService","nuoidayconService","kynangsongService","sachgiaokhoaService","sachngoainguService","thieunhiService","vanhocnuocngoaiService","vanhoctrongnuocService"};
//
//		    int idx = new Random().nextInt(theloai.length);
//			String random = (theloai[idx]);
			    
		    switch(currentCategory) {
		    case "kinhte" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", kinhteService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			    
		    case "nuoidaycon" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", nuoidayconService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			    
		    case "kynangsong" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", kynangsongService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			    
		    case "sachgiaokhoa" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", sachgiaokhoaService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;	
			    
		    case "sachngoaingu" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", sachngoainguService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			    
		    case "thieunhi" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", thieunhiService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			    
		    case "vanhocnuocngoai" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", vanhocnuocngoaiService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;
			
		    case "vanhoctrongnuoc" :
			 	model.addAttribute("book", bookService.findById(masach));
			 	model.addAttribute("relateBooks", vanhoctrongnuocService.findAll());
			 	model.addAttribute("views", bookService.findLuocxemDesc());
				model.addAttribute("carts", new Cart());

			    break;	
		    }

		    return "bookDetail";
	}
	
	@GetMapping("/book/{masach}/buyNow")
	public String buy(@PathVariable("masach") Integer masach, @ModelAttribute("carts") Cart carts, Model model) {
		
		Hoadon hoadon = new Hoadon();
		hoadon.setSoluong(carts.getSoluong());
		hoadon.setMadonhang(carts.getMadonhang());
		
		model.addAttribute("carts", carts);
	    model.addAttribute("book", bookService.findById(masach));  // khởi tạo mới 1 đối tượng và gửi lên form Mỗi thuộc tính của contact tương ứng với một input trong form.
	    model.addAttribute("bills", hoadon);
	    System.out.println(hoadon.getSoluong());
	    return "buyBook";
	}
	
	@PostMapping("/book/{masach}/printBill")
	public String save( Model model,@Valid @ModelAttribute("bills") Hoadon bills, BindingResult result, RedirectAttributes redirect,
			@PathVariable("masach") Integer masach) {  // @Valid Contact contact để kích hoạt cơ chế validation cho contact(trong entities ), lấy result làm biding
		
    	Sach ms = bookService.findById(masach);
	    if (result.hasErrors()) {
	    	model.addAttribute("book", ms);
	    	if (bills.getSoluong() > ms.getTonkho() ) {
			    model.addAttribute("outOfStockMessage", "Không đủ số lượng sản phẩm (còn lại " + ms.getTonkho() + " )");
		    }
	    	System.out.println("loi");
	    	return "buyBook";
	    	
	    }
	    
	   
	 // nhap thong tin tu sach qua hoadon
	    bills.setHinhanh(ms.getHinhanh());
	    bills.setTheloai(ms.getTheloai());
	    bills.setGiaca(ms.getGiaca());
	    bills.setTensach(ms.getTensach());
	    bills.setMasach(ms.getMasach());
	    ms.setSoluongdaban(bills.getSoluong());
	    ms.setTonkho(ms.getTonkho() - bills.getSoluong());
	    bills.setNgayxuatban(LocalDateTime.now());

	    hoadonService.save(bills);
	    bookService.save(ms);
    	model.addAttribute("book", ms );
    	model.addAttribute("bills", bills);
    	int soluong = bills.getSoluong();
    	double gia = bills.getGiaca();
    	double tong = gia * soluong;
    	model.addAttribute("tongcong", tong);
	    return "bill";
	}
	
	
	@GetMapping("/book/login")
	public String login(Model model) {
//	    model.addAttribute("user", new User());  // khởi tạo mới 1 đối tượng và gửi lên form Mỗi thuộc tính của contact tương ứng với một input trong form.
	    return "login";
	}
	
	@GetMapping("/book/register")
	public String register(Model model) {
	    model.addAttribute("user", new User());  // khởi tạo mới 1 đối tượng và gửi lên form Mỗi thuộc tính của contact tương ứng với một input trong form.
	    return "register";
	}
	
	@PostMapping("/user/save")
	public String userSave(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirect) {  // @Valid Contact contact để kích hoạt cơ chế validation cho contact(trong entities ), lấy result làm biding
		
	    if (result.hasErrors()){  
	    	if (!userService.search(user.getEmail()).isEmpty()) {
	    		model.addAttribute("emailMessage", "Email đã tồn tại");
	    		return "register";
		        
	    	}
	    	return "register";
	        
	    }
	    
	    
	    
	    userService.save(user);
	    return "redirect:/book/login";
	}
	
	@PostMapping("/user/login")
	public String userLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirect) {  // @Valid Contact contact để kích hoạt cơ chế validation cho contact(trong entities ), lấy result làm biding
		
//	    if (result.hasErrors()) {  	    	
//	    	return "login";        
//	    }
	    
		System.out.println(userService.search(user.getEmail()).isEmpty());
	    if(userService.search(user.getEmail()).isEmpty()) {
	    	model.addAttribute("wrongEmail", "Nhập sai email");
	    	return "login";
	    }  
	    if(!userService.search(user.getEmail()).isEmpty()) {
	    	model.addAttribute("wrongPassword", "Nhập sai mật khẩu");
	    	return "login";
	    }
	    
//	    if (user.getEmail() == "toicanh25@gmail.com" || user.getMatkhau() == "canhtraudien" && user.getEmail() == "long230796@gmail.com" && user.getEmail() == "hoang@gmail.com")
	    return "redirect:/book";
	}
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("message", "Đăng xuất thành công!!");
        return "logoutSuccessfulPage";
    }
//	@GetMapping("/")
//    public String homepage() {
//        return "index";
//    }
//	
//	@PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
//
//        // check if file is empty
//        if (file.isEmpty()) {
//            attributes.addFlashAttribute("message", "Please select a file to upload.");
//            return "redirect:/";
//        }
//
//        // normalize the file path
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // save the file on the local file system
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // return success response
//        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
//
//        return "redirect:/";
//    }
//	
	@PostMapping("/book/save")
	public String save(Model model, @Valid @ModelAttribute("book") Sach book, BindingResult result, RedirectAttributes redirect, @RequestParam("file") MultipartFile file) {  // @Valid Contact contact để kích hoạt cơ chế validation cho contact(trong entities ), lấy result làm biding
		
	    if (result.hasErrors() && file.isEmpty()) {
            model.addAttribute("fileError", "Please select a file to upload.");
	        return "addBook";
	    }
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    
	 // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            book.setHinhanh(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

	    book.setNgayxuatban(LocalDateTime.now());
	    
	    switch(book.getTheloai()) {
		    case "kinhte" :
		    	Kinhte kinhte = new Kinhte(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
			    kinhteService.save(kinhte);
			    bookService.save(book);
			    break;
			    
		    case "nuoidaycon" :
		    	Nuoidaycon nuoidaycon = new Nuoidaycon(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	nuoidayconService.save(nuoidaycon);
			    bookService.save(book);
			    break;
			    
		    case "kynangsong" :
		    	Kynangsong kynangsong = new Kynangsong(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	kynangsongService.save(kynangsong);
			    bookService.save(book);
			    break;
			    
		    case "sachgiaokhoa" :
		    	Sachgiaokhoa sachgiaokhoa= new Sachgiaokhoa(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	sachgiaokhoaService.save(sachgiaokhoa);
			    bookService.save(book);
			    break;
			    
		    case "sachngoaingu" :
		    	Sachngoaingu sachngoaingu = new Sachngoaingu(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	sachngoainguService.save(sachngoaingu );
			    bookService.save(book);
			    break;
			    
		    case "thieunhi" :
		    	Thieunhi thieunhi = new Thieunhi(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	thieunhiService.save(thieunhi);
			    bookService.save(book);
			    break;
			    
		    case "vanhocnuocngoai" :
		    	Vanhocnuocngoai vanhocnuocngoai = new Vanhocnuocngoai(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	vanhocnuocngoaiService.save(vanhocnuocngoai);
			    bookService.save(book);
			    break;
			
		    case "vanhoctrongnuoc" :
		    	Vanhoctrongnuoc vahoctrongnuoc = new Vanhoctrongnuoc(book.getMasach(), book.getTensach(), book.getTacgia(), book.getTheloai(), book.getGiaca(), book.getMota(),
		    			book.getHinhanh(), book.getTonkho(), book.getSoluongdaban(), book.getNgayxuatban());
		    	
		    	vanhoctrongnuocService.save(vahoctrongnuoc);
			    bookService.save(book);
			    break;
		    }
	    redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
	    return "redirect:/book";
	}
	
	@GetMapping("/book/{masach}/edit")
	public String edit(@PathVariable("masach") Integer masach, Model model) {
	    model.addAttribute("book", bookService.findById(masach));
	    Sach book = bookService.findById(masach);
	    int currentViews = book.getLuocxem();
	    book.setLuocxem(currentViews += 1);
	    bookService.save(book);
	    return "addBook";
	}
	
	@GetMapping("/book/{masach}/{theloai}/delete")
	public String delete(@PathVariable int  masach, @PathVariable String theloai, RedirectAttributes redirect) {
		
		 switch(theloai) {
		    case "kinhte" :
		    	bookService.delete(masach);
		  	    kinhteService.delete(masach);
			    break;
			    
		    case "nuoidaycon" :
		    	bookService.delete(masach);
		  	    nuoidayconService.delete(masach);
			    break;
			    
		    case "kynangsong" :
		    	bookService.delete(masach);
		  	    kynangsongService.delete(masach);
			    break;
			    
		    case "sachgiaokhoa" :
		    	bookService.delete(masach);
		  	    sachgiaokhoaService.delete(masach);
			    break;
			    
		    case "sachngoaingu" :
		    	bookService.delete(masach);
		  	    sachngoainguService.delete(masach);
			    break;
			    
		    case "thieunhi" :
		    	bookService.delete(masach);
		  	    thieunhiService.delete(masach);
			    break;
			    
		    case "vanhocnuocngoai" :
		    	bookService.delete(masach);
		  	    vanhocnuocngoaiService.delete(masach);
			    break;
			
		    case "vanhoctrongnuoc" :
		    	bookService.delete(masach);
		  	    vanhoctrongnuocService.delete(masach);
			    break;
		    }
//	    bookService.delete(masach);
//	    kinhteService.delete(masach);
	    redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
	    return "redirect:/book";
	}
}
	
