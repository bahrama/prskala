package ir.persikala.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ir.persikala.dao.ProductIndexDaoLocal;
import ir.persikala.request.InsertProductRequest;
import ir.persikala.response.ProductDetail;

/**
 * Session Bean implementation class ProductIndexService
 */
@Stateless
public class ProductIndexService implements ProductIndexServiceLocal {

    /**
     * Default constructor. 
     */
    public ProductIndexService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ProductIndexDaoLocal productIndexDaoLocal;
    
    @Override
    public List<ProductDetail> findAllProductIndex(int size,int from) {
    	return productIndexDaoLocal.findAllProductIndex(size, from);
    }
    @Override
    public int findAllProductIndexSize() {
    	return productIndexDaoLocal.findAllProductIndexSize();
    }
    
    @Override
    public void InsertProduct(InsertProductRequest insertProductRequest) {
     productIndexDaoLocal.InsertProduct(insertProductRequest);
    }
    
    @Override
    public List<ProductDetail> findProductIndexByDaste(int size,int from,String daste) throws Exception {
    	return productIndexDaoLocal.findProductIndexByDaste(size, from, daste);
    }
    @Override
    public int getPageSize() {
	return productIndexDaoLocal.getPageSize();
                          }
    
    @Override
    public List<ProductDetail> findProductIndexByBrand(int size,int from,String brand) throws java.lang.Exception {
    return productIndexDaoLocal.findProductIndexByBrand(size, from, brand);
    }
    
    @Override
    public List<ProductDetail> findProductIndexByMultiBrandDaste(int size,int from,String brand,String daste) throws java.lang.Exception {
    	return productIndexDaoLocal.findProductIndexByMultiBrandDaste(size, from, brand, daste);
    }
    
    
    
    }

