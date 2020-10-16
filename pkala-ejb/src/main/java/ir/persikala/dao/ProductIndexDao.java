package ir.persikala.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ir.persikala.request.FindAllProductsRequest;
import ir.persikala.request.FindFromOneFieldProductsRequest;
import ir.persikala.request.InsertProductRequest;
import ir.persikala.request.Match;
import ir.persikala.request.Query2;
import ir.persikala.request.dasteBrand.Bool;
import ir.persikala.request.dasteBrand.DasteBrandFilterRequest;
import ir.persikala.request.dasteBrand.Filter;
import ir.persikala.request.dasteBrand.Must;
import ir.persikala.request.multiMatch.brand.MultiBrandFilter;
import ir.persikala.request.multiMatch.brand.Multi_match;
import ir.persikala.request.searchMach.FindMatchRequestDaste;
import ir.persikala.request.searchMach.Match_phrase3;
import ir.persikala.request.searchMach.Query3;
import ir.persikala.request.searchMach.brand.BrandFilterRequest;
import ir.persikala.request.searchMach.brand.Match_phrase;
import ir.persikala.request.searchMach.brand.Query;
import ir.persikala.response.FindAllProductResponse;
import ir.persikala.response.ProductDetail;

/**
 * Session Bean implementation class ProductIndexDao
 */
@Stateless
public class ProductIndexDao implements ProductIndexDaoLocal {

    /**
     * Default constructor. 
     */
    public ProductIndexDao() {
        // TODO Auto-generated constructor stub
    }
    
    //curl -XPOST "http://192.168.10.77:9200/product_index/_search" -H 'Content-Type: application/json' -d'{  "query": {    "match_all": {}  },  "size": 2,  "from": 1}'
    
  private int pageSize;
  
  
    
    @Override
    public int getPageSize() {
	return pageSize;
                          }


	@Override
    public List<ProductDetail> findAllProductIndex(int size,int from) {
    	Client client=ClientBuilder.newClient();
    	FindAllProductsRequest request=new FindAllProductsRequest();
    	request.setFrom(from);
    	request.setSize(size);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<FindAllProductsRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	//System.err.println(response.readEntity(String.class));
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
//    	System.err.println(findAllProductResponse.getTimed_out());
//    	System.err.println(findAllProductResponse.getHits().getTotal().getValue());
        return findAllProductResponse.getHits().getHits();
    }
    
    @Override
    public int findAllProductIndexSize() {
    	Client client=ClientBuilder.newClient();
    	FindAllProductsRequest request=new FindAllProductsRequest();
    	request.setFrom(1);
    	request.setSize(5);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<FindAllProductsRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	//System.err.println(response.readEntity(String.class));
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
//    	System.err.println(findAllProductResponse.getTimed_out());
//    	System.err.println(findAllProductResponse.getHits().getTotal().getValue());
        return (int) findAllProductResponse.getHits().getTotal().getValue();
    }
    @Override
    public void findProductByModel(String model) {
    	Client client=ClientBuilder.newClient();
    	FindFromOneFieldProductsRequest request=new FindFromOneFieldProductsRequest();
    	Match match=new Match();
    	match.setModel(model);
    	Query2 query2=new Query2();
    	query2.setMatch(match);
    	request.setQuery(query2);
    	//curl -XGET "http://192.168.10.77:9200/product_index/_search" -H 'Content-Type: application/json' -d'{  "query": {    "match": {      "model": " galaxy "    }  }  , "size": 6}'
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<FindFromOneFieldProductsRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
    }
    
    //curl -XPOST "http://192.168.10.77:9200/product_index/_doc" -H 'Content-Type: application/json' -d'{  "name":"SAMSUNG2",  "brand":"SAMSUNG",  "release_date":"2019-09-10",  "new_old":true,  "takhfif_darsad":21.0,  "description":"Make life good. SAMSUNG electronics, appliances and mobile devices feature reza technology and sleek SAMSUNG is good"  ,  "daste":"mobile",  "noe":"digital",  "omde_tak":["tak"],  "price":2001000,  "shoar":"SAMSUNG KHOBE",  "color":["red","green","yellow","black"],  "model":"galaxy",  "vijegi":[{"vijegiMobile":"ssss"},{"vijegi2":"dadasda"}],  "mojod":true,  "contry":"iran"}'
    @Override
    public void InsertProduct(InsertProductRequest insertProductRequest) {
    	InsertProductRequest request=new InsertProductRequest();
    	request=insertProductRequest;
    	Client client=ClientBuilder.newClient();
    	String targetResource="http://192.168.10.77:9200/product_index/_doc";
    	Entity<InsertProductRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
        System.err.println(json);
    }
    
    @Override
    public List<ProductDetail> findProductIndexByDaste(int size,int from,String daste) throws java.lang.Exception {
    	try {
    	Client client=ClientBuilder.newClient();
    	FindMatchRequestDaste request=new FindMatchRequestDaste();
    	request.setFrom(from);
    	request.setSize(size);
    	Query3 query3=new Query3();
    	Match_phrase3 match_phrase3=new Match_phrase3();
    	match_phrase3.setDaste(daste);
    	query3.setMatch_phrase(match_phrase3);
    	request.setQuery(query3);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<FindMatchRequestDaste> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	//System.err.println(response.readEntity(String.class));
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
//    	System.err.println(findAllProductResponse.getTimed_out());
//    	System.err.println(findAllProductResponse.getHits().getTotal().getValue());
    	this.pageSize=(int)findAllProductResponse.getHits().getTotal().getValue();
        return findAllProductResponse.getHits().getHits();
    	}catch(Exception e) {
    		this.pageSize=1;
    		throw new Exception();
    	}
    }
    
    
    @Override
    public List<ProductDetail> findProductIndexByBrand(int size,int from,String brand) throws java.lang.Exception {
    	try {
    	Client client=ClientBuilder.newClient();
    	BrandFilterRequest request=new BrandFilterRequest();
    	request.setFrom(from);
    	request.setSize(size);
    	Query query=new Query();
    	Match_phrase match_phrase=new Match_phrase();
    	match_phrase.setBrand(brand);
    	query.setMatch_phrase(match_phrase);
    	request.setQuery(query);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<BrandFilterRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
    	this.pageSize=(int)findAllProductResponse.getHits().getTotal().getValue();
        return findAllProductResponse.getHits().getHits();
    	}catch(Exception e) {
    		this.pageSize=1;
    		throw new Exception();
    	}
    }
    
    @Override
    public List<ProductDetail> findProductIndexByMultiBrand(int size,int from,String brand) throws java.lang.Exception {
    	try {
    	Client client=ClientBuilder.newClient();
    	MultiBrandFilter request=new MultiBrandFilter();
    	request.setFrom(from);
    	request.setSize(size);
    	ir.persikala.request.multiMatch.brand.Query query=new ir.persikala.request.multiMatch.brand.Query();
    	Multi_match multi_match=new Multi_match();
    	multi_match.setQuery(brand);
    	multi_match.getFields().add("brand");
    	query.setMulti_match(multi_match);
    	request.setQuery(query);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<MultiBrandFilter> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
    	this.pageSize=(int)findAllProductResponse.getHits().getTotal().getValue();
        return findAllProductResponse.getHits().getHits();
    	}catch(Exception e) {
    		this.pageSize=1;
    		throw new Exception();
    	}
    }

    @Override
    public List<ProductDetail> findProductIndexByMultiBrandDaste(int size,int from,String brand,String daste) throws java.lang.Exception {
    	try {
    	Client client=ClientBuilder.newClient();
    	DasteBrandFilterRequest request=new DasteBrandFilterRequest();
    	request.setFrom(from);
    	request.setSize(size);
        ir.persikala.request.dasteBrand.Query query=new ir.persikala.request.dasteBrand.Query();
        Bool bool=new Bool();
        Filter filter=new Filter();
        Must must=new Must();
        ir.persikala.request.dasteBrand.Multi_match multi_match=new ir.persikala.request.dasteBrand.Multi_match();
        multi_match.setQuery(brand);
        multi_match.getFields().add("brand");
        must.setMulti_match(multi_match);
        ir.persikala.request.dasteBrand.Match match=new ir.persikala.request.dasteBrand.Match();
        match.setDaste(daste);
        filter.setMatch(match);
        bool.getFilter().add(filter);
        bool.getMust().add(must);
        query.setBool(bool);
        request.setQuery(query);
    	String targetResource="http://192.168.10.77:9200/product_index/_search";
    	Entity<DasteBrandFilterRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
    	Jsonb jsonb=JsonbBuilder.create();
    	FindAllProductResponse findAllProductResponse=new FindAllProductResponse();
    	findAllProductResponse=jsonb.fromJson(json, FindAllProductResponse.class);
    	this.pageSize=(int)findAllProductResponse.getHits().getTotal().getValue();
        return findAllProductResponse.getHits().getHits();
    	}catch(Exception e) {
    		this.pageSize=1;
    		throw new Exception();
    	}
    }
}
