package com.techelevator.ssg.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.cart.OrderItem;
import com.techelevator.ssg.model.cart.OrderItemDAO;
import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.order.Order;
import com.techelevator.ssg.model.order.OrderDAO;
import com.techelevator.ssg.model.store.DollarAmount;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller
public class HomeController {

	@Autowired
	private ForumDao forumDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private OrderItemDAO orderItemDao;

	@RequestMapping("/home")
	public String displayHomePage() {
		return "homePage";
	}

	@RequestMapping("/weightCalculator")
	public String inputWeightPage() {
		return "weightCalculator";
	}

	@RequestMapping("/alienWeight")
	public String showWeightResults(@RequestParam int earthWeight, @RequestParam BigDecimal planetaryGs, ModelMap map) {
		map.put("earthWeight", earthWeight);
		map.put("plaentaryGs", planetaryGs);
		return "alienWeight";
	}

	@RequestMapping("/ageInput")
	public String inputAgePage() {
		return "ageInput";
	}

	@RequestMapping("/alienAge")
	public String showAgeResults(@RequestParam int earthAge, @RequestParam double ageMultiplier, ModelMap map) {
		map.put("earthAge", earthAge);
		map.put("ageMultiplier", ageMultiplier);
		return "alienAge";
	}

	@RequestMapping("/travelCalculator")
	public String inputTravel() {
		return "travelCalculator";
	}

	@RequestMapping("/alienTravel")
	public String showTravelResults(@RequestParam int startingAge, @RequestParam long distanceFromEarth,
			@RequestParam int modeOfTravel, ModelMap map) {
		map.put("startingAge", startingAge);
		map.put("distanceFromEarth", distanceFromEarth);
		map.put("modeOfTravel", modeOfTravel);
		return "alienTravel";
	}

	@RequestMapping(path = "/spaceForum", method = RequestMethod.GET)
	public String displaySpaceForum(ModelMap map) {
		List<ForumPost> posts = forumDao.getAllPosts();
		map.put("posts", posts);
		return "spaceForum";
	}

	@RequestMapping(path = "/postToForum", method = RequestMethod.GET)
	public String enterPostToSpaceForum() {
		return "postToForum";
	}

	@RequestMapping(path = "/postToForum", method = RequestMethod.POST)
	public String postToSpaceForum(ForumPost post) {
		forumDao.save(post);
		return "redirect:spaceForum";
	}

	@RequestMapping(path = "/spaceStore", method = RequestMethod.GET)
	public String displaySpaceStore(ModelMap map, HttpSession session) {
		if (session.getAttribute("orderId") == null) {
			session.setAttribute("orderId", orderDao.getNextId());
		}
		List<Product> products = productDao.getAllProducts();
		map.put("products", products);
		return "spaceStore";
	}

	@RequestMapping("/productDetail")
	public String displayProductDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String productIdParam = request.getParameter("productId");
			Long productId = Long.parseLong(productIdParam);
			request.setAttribute("product", productDao.getProductById(productId));
			return "productDetail";
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/productDetail", method = RequestMethod.POST)
	public String sendToCart(ModelMap map, @RequestParam long productId, @RequestParam int quantity, HttpSession session) {
		Map <Product, Integer> addToCart= new HashMap<>();
		
		if (session.getAttribute("shoppingCart") != null) {
			addToCart= (Map<Product, Integer>) session.getAttribute("shoppingCart");
		if(addToCart.get(productDao.getProductById(productId)) == null ) {
			addToCart.put(productDao.getProductById(productId), quantity);
		} else {
		int inCart= addToCart.get(productDao.getProductById(productId));
		addToCart.put(productDao.getProductById(productId), quantity +inCart);
		}}
		else {
		addToCart.put(productDao.getProductById(productId), quantity);
		}
		session.setAttribute("shoppingCart", addToCart);
		
		
		if (session.getAttribute("total") == null) {
			session.setAttribute("total", productDao.getProductById(productId).getPrice().multiply(quantity) );
		} else {
			session.setAttribute("total", ((DollarAmount)session.getAttribute("total")).plus(productDao.getProductById(productId).getPrice().multiply(quantity)));
		}
		return "redirect:/spaceCart";
	}

	@RequestMapping(path = "/spaceCart", method = RequestMethod.GET)
	public String displayCart(ModelMap map, HttpSession session) {
		map.put("items", session.getAttribute("shoppingCart"));
		return "spaceCart";
	}
	
	@RequestMapping(path = "/emptyCart", method = RequestMethod.GET)
	public String emptyCart(HttpSession session) {
		session.invalidate();
		return "redirect:/spaceStore";
	}
	
	@RequestMapping(path = "/checkout", method = RequestMethod.GET)
	public String goToCheckout(ModelMap map, HttpSession session) {
		map.put("items", session.getAttribute("shoppingCart"));
		return "checkout";
	}
	
	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public String finalizeOrder(ModelMap map, HttpSession session,  @RequestParam String customerName, @RequestParam String address1,
			@RequestParam String address2, @RequestParam String city,@RequestParam String state, @RequestParam String zipCode) {
		Order  newWorldOrder = new Order();
		newWorldOrder.setCustomerName(customerName);
		newWorldOrder.setStreetAddress1(address1);
		newWorldOrder.setStreetAddress2(address2);
		newWorldOrder.setCity(city);
		newWorldOrder.setState(state);
		newWorldOrder.setZipcode(zipCode);
		long orderId =orderDao.buy(newWorldOrder);
		@SuppressWarnings("unchecked")
		Map <Product, Integer> theCart=(Map<Product, Integer>) session.getAttribute("shoppingCart");
		for(Product product : theCart.keySet()) {
			OrderItem item= new OrderItem();
			item.setOrderId(orderId);
			item.setProductId(product.getId());
			item.setQuantity(theCart.get(product));
			orderItemDao.save(item);
		}
		session.invalidate();
		return "redirect:/orderConfirmation";
	}
@RequestMapping ("/orderConfirmation")
public String orderConfirmationDone() {
	return "orderConfirmation";
}
}