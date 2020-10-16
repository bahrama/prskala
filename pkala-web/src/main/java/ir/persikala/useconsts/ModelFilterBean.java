package ir.persikala.useconsts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ir.persikala.service.BrandFilterServiceLocal;

@Named
@RequestScoped
public class ModelFilterBean {

	public ModelFilterBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private BrandFilterServiceLocal modelFilterServiceLocal;

	public List<String> FilterBrand(String daste){
	  return modelFilterServiceLocal.getBrandFilterMap().get(daste);
	}
	
	
	
}
