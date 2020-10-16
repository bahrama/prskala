package ir.persikala.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ir.persikala.consts.menu.Daste;
import ir.persikala.consts.menu.Digital;
import ir.persikala.consts.model.MobileTablet;
import ir.persikala.consts.model.Tv;

/**
 * Session Bean implementation class ModelFilterService
 */
@Singleton
@Startup
public class BrandFilterService implements BrandFilterServiceLocal {

    /**
     * Default constructor. 
     */
    public BrandFilterService() {
        // TODO Auto-generated constructor stub
    }
    
    private Map<String, List<String>> brandFilterMap = new HashMap<>();

    @Override
	public Map<String, List<String>> getBrandFilterMap() {
		return brandFilterMap;
	}

	public void setModelFilterMap(Map<String, List<String>> modelFilterMap) {
		this.brandFilterMap = modelFilterMap;
	}
	
    @PostConstruct
    public void initBrandFilter() {
    	List<String> listMobile=new ArrayList<>();
    	for (MobileTablet moblTablet : MobileTablet.values()) {
    		listMobile.add(moblTablet.toString());	
		}
    	this.brandFilterMap.put(Digital.Mobile.getUnionName().replaceAll(" ","-"),listMobile);
    	List<String> listTv=new ArrayList<>();
    	for (Tv tv : Tv.values()) {
    		listTv.add(tv.toString());	
		}
    	this.brandFilterMap.put(Digital.Tv.getUnionName().replaceAll(" ","-"),listTv);
            
    }

}
