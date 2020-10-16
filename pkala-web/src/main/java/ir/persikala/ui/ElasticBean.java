package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ir.persikala.dao.ProductIndexDaoLocal;
import ir.persikala.request.InsertProductRequest;
import ir.persikala.response.ProductDetail;

@Named
@SessionScoped
public class ElasticBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductIndexDaoLocal productIndexDaoLocal;

	public ElasticBean() {
		
	}
	
	public void findElasticTest() {
		for (ProductDetail productDetail : productIndexDaoLocal.findAllProductIndex(5,5)) {
		//System.err.println(productDetail.get_source().getColor().get(1));	
		}
		
	}
	
	public void test() {
		productIndexDaoLocal.findProductByModel("fdsf");
	}
	
	public void test2() {
		InsertProductRequest insertProductRequest=new InsertProductRequest();
		insertProductRequest.setBrand("LG");
		insertProductRequest.setContry("japon");
		insertProductRequest.getVijegi().put("ram", "3G");
		insertProductRequest.getVijegi().put("cpu", "i7");
		insertProductRequest.getColor().add("black");
		insertProductRequest.getColor().add("yellow");
		insertProductRequest.setDaste("digital");
		insertProductRequest.setDescription("good");
		insertProductRequest.setModel("omid model");
		insertProductRequest.setMojod(false);
		insertProductRequest.setName("mobile g1 lg");
		insertProductRequest.setNew_old(true);
		insertProductRequest.setNoe("alinoe");
		insertProductRequest.getOmde_tak().add("tak");
		insertProductRequest.getOmde_tak().add("tak");
		insertProductRequest.setPrice(1000000);
		insertProductRequest.setRelease_date("2020-12-12");
		insertProductRequest.setShoar("kheyli khobam");
		insertProductRequest.setTakhfif_darsad(23);
		productIndexDaoLocal.InsertProduct(insertProductRequest);
		
	}
	


}
