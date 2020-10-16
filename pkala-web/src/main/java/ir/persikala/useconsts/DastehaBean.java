package ir.persikala.useconsts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ir.persikala.consts.menu.*;
import ir.persikala.service.MenuContentsServiceLocal;

@Named
@RequestScoped
public class DastehaBean {

	public DastehaBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private MenuContentsServiceLocal menuContentsServiceLocal;
	
	public List<Daste> dasteha(){
		return Arrays.asList(Daste.values());
	}

	
	public Map<Daste, List<String>> findMenu(){
		return menuContentsServiceLocal.getMenuMap();
	}
	
	
}
