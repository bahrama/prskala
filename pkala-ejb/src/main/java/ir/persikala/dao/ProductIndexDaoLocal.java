package ir.persikala.dao;

import java.util.List;

import javax.ejb.Local;

import ir.persikala.request.InsertProductRequest;
import ir.persikala.response.ProductDetail;

@Local
public interface ProductIndexDaoLocal {


	List<ProductDetail> findAllProductIndex(int size, int from);

	int findAllProductIndexSize();

	void findProductByModel(String model);

	void InsertProduct(InsertProductRequest insertProductRequest);


	List<ProductDetail> findProductIndexByDaste(int size, int from, String daste) throws Exception;

	int getPageSize();

	List<ProductDetail> findProductIndexByBrand(int size, int from, String brand) throws Exception;

	List<ProductDetail> findProductIndexByMultiBrand(int size, int from, String brand) throws Exception;

	List<ProductDetail> findProductIndexByMultiBrandDaste(int size, int from, String brand, String daste)
			throws Exception;

}
