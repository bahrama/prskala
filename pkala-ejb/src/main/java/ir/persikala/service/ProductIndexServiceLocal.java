package ir.persikala.service;

import java.util.List;

import javax.ejb.Local;

import ir.persikala.request.InsertProductRequest;
import ir.persikala.response.ProductDetail;

@Local
public interface ProductIndexServiceLocal {

	List<ProductDetail> findAllProductIndex(int size, int from);

	int findAllProductIndexSize();

	void InsertProduct(InsertProductRequest insertProductRequest);

	List<ProductDetail> findProductIndexByDaste(int size, int from, String daste) throws Exception;

	int getPageSize();

	List<ProductDetail> findProductIndexByBrand(int size, int from, String brand) throws Exception;

	List<ProductDetail> findProductIndexByMultiBrandDaste(int size, int from, String brand, String daste,
			boolean newOld, boolean mojod, String omdeTak) throws Exception;

}
