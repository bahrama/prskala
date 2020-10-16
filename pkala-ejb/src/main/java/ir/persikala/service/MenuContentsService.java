package ir.persikala.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ir.persikala.consts.menu.Cloth;
import ir.persikala.consts.menu.Container;
import ir.persikala.consts.menu.CulturalProducts;
import ir.persikala.consts.menu.Daste;
import ir.persikala.consts.menu.Digital;
import ir.persikala.consts.menu.Electrical;
import ir.persikala.consts.menu.Handicrafts;
import ir.persikala.consts.menu.Health;
import ir.persikala.consts.menu.Zinati;

/**
 * Session Bean implementation class MenuContentsService
 */
@Singleton
@Startup
public class MenuContentsService implements MenuContentsServiceLocal {

	/**
	 * Default constructor.
	 */
	public MenuContentsService() {
		// TODO Auto-generated constructor stub
	}

	private Map<Daste, List<String>> menuMap = new HashMap<>();

	
	
	@Override
	public Map<Daste, List<String>> getMenuMap() {
		return menuMap;
	}




	public void setMenuMap(Map<Daste, List<String>> menuMap) {
		this.menuMap = menuMap;
	}




	@PostConstruct
	public void fillMenuMap() {
		for (Daste daste : Arrays.asList(Daste.values())) {
			if (daste.equals(Daste.Cloth)) {
				List<String> listCloth = new ArrayList<>();
				for (Cloth cloth : Arrays.asList(Cloth.values())) {
					listCloth.add(cloth.getUnionName());
				}
				menuMap.put(Daste.Cloth, listCloth);

			}
			if (daste.equals(Daste.Container)) {
				List<String> listCloth = new ArrayList<>();
				for (Container container : Arrays.asList(Container.values())) {
					listCloth.add(container.getUnionName());
				}
				menuMap.put(Daste.Container, listCloth);

			}
			
			if (daste.equals(Daste.CulturalProducts)) {
				List<String> listCloth = new ArrayList<>();
				for (CulturalProducts culturalProducts : Arrays.asList(CulturalProducts.values())) {
					listCloth.add(culturalProducts.getUnionName());
				}
				menuMap.put(Daste.CulturalProducts, listCloth);

			}
			
			if (daste.equals(Daste.Digital)) {
				List<String> listCloth = new ArrayList<>();
				for (Digital digital : Arrays.asList(Digital.values())) {
					listCloth.add(digital.getUnionName());
				}
				menuMap.put(Daste.Digital, listCloth);

			}
			
			if (daste.equals(Daste.Electrical)) {
				List<String> listCloth = new ArrayList<>();
				for (Electrical electrical : Arrays.asList(Electrical.values())) {
					listCloth.add(electrical.getUnionName());
				}
				menuMap.put(Daste.Electrical, listCloth);

			}
			
			if (daste.equals(Daste.Handicrafts)) {
				List<String> listCloth = new ArrayList<>();
				for (Handicrafts handicrafts : Arrays.asList(Handicrafts.values())) {
					listCloth.add(handicrafts.getUnionName());
				}
				menuMap.put(Daste.Handicrafts, listCloth);

			}
			
			if (daste.equals(Daste.Health)) {
				List<String> listCloth = new ArrayList<>();
				for (Health health : Arrays.asList(Health.values())) {
					listCloth.add(health.getUnionName());
				}
				menuMap.put(Daste.Health, listCloth);

			}
			
			if (daste.equals(Daste.Zinati)) {
				List<String> listCloth = new ArrayList<>();
				for (Zinati zinati : Arrays.asList(Zinati.values())) {
					listCloth.add(zinati.getUnionName());
				}
				menuMap.put(Daste.Zinati, listCloth);

			}
			
             
		}

	}

}
