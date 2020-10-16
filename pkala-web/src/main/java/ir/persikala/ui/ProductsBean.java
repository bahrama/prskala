package ir.persikala.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.json.JSONObject;

import ir.persikala.consts.model.BrandHa;
import ir.persikala.request.InsertProductRequest;
import ir.persikala.response.ProductDetail;
import ir.persikala.service.ProductIndexServiceLocal;

@Named
@ViewScoped
public class ProductsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductsBean() {

	}

	@Inject
	private ProductIndexServiceLocal productIndexServiceLocal;

	private List<ProductDetail> productDetails = new ArrayList<>();
	private int pageNum;
	
	private String brand;
	private String contry;
	private String daste;
	private String description;
	private String model;
	private boolean mojod;
	private String name;
	private boolean new_old;
	private String noe;
	private int price;
	private String release_date;
	private String shoar;
	private float takhfif_darsad;
	private List<String> color=new ArrayList<>();
	private List<String> omde_tak=new ArrayList<>();
	private Map<String, Object> vijegi=new HashMap<>();
	private String vijegiIn;
	private int bazdid;
	private int forosh;
	
	private String pageBrand="";
	
	private String[] brandFilterList;

	public String getVijegiIn() {
		return vijegiIn;
	}

	public void setVijegiIn(String vijegiIn) {
		this.vijegiIn = vijegiIn;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getDaste() {
		return daste;
	}

	public void setDaste(String daste) {
		this.daste = daste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isMojod() {
		return mojod;
	}

	public void setMojod(boolean mojod) {
		this.mojod = mojod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNew_old() {
		return new_old;
	}

	public void setNew_old(boolean new_old) {
		this.new_old = new_old;
	}

	public String getNoe() {
		return noe;
	}

	public void setNoe(String noe) {
		this.noe = noe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getShoar() {
		return shoar;
	}

	public void setShoar(String shoar) {
		this.shoar = shoar;
	}

	public float getTakhfif_darsad() {
		return takhfif_darsad;
	}

	public void setTakhfif_darsad(float takhfif_darsad) {
		this.takhfif_darsad = takhfif_darsad;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<String> getOmde_tak() {
		return omde_tak;
	}

	public void setOmde_tak(List<String> omde_tak) {
		this.omde_tak = omde_tak;
	}



	public Map<String, Object> getVijegi() {
		return vijegi;
	}

	public void setVijegi(Map<String, Object> vijegi) {
		this.vijegi = vijegi;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}
	
	
	public int getBazdid() {
		return bazdid;
	}

	public void setBazdid(int bazdid) {
		this.bazdid = bazdid;
	}

	public int getForosh() {
		return forosh;
	}

	public void setForosh(int forosh) {
		this.forosh = forosh;
	}


	public String[] getBrandFilterList() {
		System.err.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		return brandFilterList;
	}

	public void setBrandFilterList(String[] brandFilterList) {
		this.brandFilterList = brandFilterList;
	}

	public String getPageBrand() {
		return pageBrand;
	}

	public void setPageBrand(String pageBrand) {
		this.pageBrand = pageBrand;
	}

	@PostConstruct
	public void startInit() {
		for (int i = 0; i < BrandHa.values().length; i++) {
			this.pageBrand+=BrandHa.values()[i].toString()+"-";
		}
		System.err.println(this.pageBrand);
		try {
	    String daste = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("daste");
	    findProductIndexByDasteMultiBrand("9", "0", "1",daste);
		}catch (Exception e) {
			System.err.println("doc is little");
		}
	}
	
	

	public List<ProductDetail> findAllProductIndex(String size, String from) {
		for (ProductDetail productDetail : productIndexServiceLocal.findAllProductIndex(Integer.parseInt(size),
				Integer.parseInt(from))) {
			System.err.println(productDetail.get_source().getName());
		}
		return productIndexServiceLocal.findAllProductIndex(Integer.parseInt(size), Integer.parseInt(from));
		// return productIndexServiceLocal.findAllProductIndex(11, 1);
	}

	public List<Integer> findAllProductIndexSize() {
		int a = productIndexServiceLocal.getPageSize() / 9;
		List<Integer> list = new ArrayList<>();
		if (a == 0) {
			//for (int i = 1; i <= a; i++) {
				list.add(1);
			//}
		} else {
			for (int i = 1; i <= a + 1; i++) {
				list.add(i);
			}
		}
		return list;
	}

	public void findAllProduct(String size, String from, String pageNum) {
		this.pageNum = Integer.parseInt(pageNum);
		this.productDetails.clear();
		this.productDetails
				.addAll(productIndexServiceLocal.findAllProductIndex(Integer.parseInt(size), Integer.parseInt(from)));
	}
	
	public Map<String, Object> changeJsonToMap() {
        JSONObject jObject = new JSONObject(this.vijegiIn);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            Object value = jObject.get(key); 
            vijegi.put(key, value);

        }
        return vijegi;
        
	}
	
	public void insertToProducts() {
		InsertProductRequest insertProductRequest=new InsertProductRequest();
		insertProductRequest.setBrand(this.brand);
		insertProductRequest.setContry(contry);
//		insertProductRequest.getVijegi().put("ram", "3G");
//		insertProductRequest.getVijegi().put("cpu", "i7");
		insertProductRequest.setVijegi(changeJsonToMap());
		insertProductRequest.getColor().addAll(color);
		insertProductRequest.setDaste(daste);
		insertProductRequest.setDescription(description);
		insertProductRequest.setModel(model);
		insertProductRequest.setMojod(mojod);
		insertProductRequest.setName(name);
		insertProductRequest.setNew_old(new_old);
		insertProductRequest.setNoe(noe);
		insertProductRequest.getOmde_tak().addAll(omde_tak);
		insertProductRequest.setPrice(price);
		insertProductRequest.setRelease_date(release_date);
		insertProductRequest.setShoar(shoar);
		insertProductRequest.setTakhfif_darsad(takhfif_darsad);
		insertProductRequest.setBazdid(bazdid);
		insertProductRequest.setForosh(forosh);
		productIndexServiceLocal.InsertProduct(insertProductRequest);
	}

	public void findProductIndexByDaste(String size, String from, String pageNum,String daste) {
		try {
		this.pageNum = Integer.parseInt(pageNum);
		this.productDetails.clear();
		this.productDetails
				.addAll(productIndexServiceLocal.findProductIndexByDaste(Integer.parseInt(size), Integer.parseInt(from),daste));
		}catch (Exception e) {
			System.err.println("product is empty");
		}
	}
	
    public void findProductIndexByBrand(ValueChangeEvent event){
//    	System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^"+this.brandFilterList[1]);
//		try {
//		this.productDetails.clear();
//		for (String brand : brandFilterList) {
//			this.productDetails
//			.addAll(productIndexServiceLocal.findProductIndexByBrand(100, 0,brand));
//		}
//    }catch (Exception e) {
//			System.err.println("product is empty");
//		}
    	//System.err.println(event.getSource().toString());
    	System.err.println("Salam");
    }
    
    public void itemSelected(AjaxBehaviorEvent event) {
    	System.err.println("AAAAAAAAAAAAAAJJJJJJJJAAAAAAAAAAAX");
    	this.productDetails.clear();
    	this.pageBrand="";
    	try {
    	for (int i = 0; i < event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("smc").length; i++) {
			System.err.println(event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("smc")[i]);
			this.pageBrand+=event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("smc")[i]+"-";
		}
    	}catch (Exception e) {
    		for (int i = 0; i < BrandHa.values().length; i++) {
    			this.pageBrand+=BrandHa.values()[i].toString()+"-";
    		}
		}
		try {
		    String daste = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("daste");
		    findProductIndexByDasteMultiBrand("9", "0", "1",daste);
			}catch (Exception e) {
				System.err.println("doc is little");
			}
    	
    }
    
public void test() {
	System.err.println("PPPPPPPPPPPPPP");

}


public void findProductIndexByDasteMultiBrand(String size, String from, String pageNum,String daste) {
	try {
	this.pageNum = Integer.parseInt(pageNum);
	this.productDetails.clear();
	this.productDetails
			.addAll(productIndexServiceLocal.findProductIndexByMultiBrandDaste(Integer.parseInt(size), Integer.parseInt(from),this.pageBrand,daste));
	}catch (Exception e) {
		System.err.println("product is empty");
	}
}

	
}
