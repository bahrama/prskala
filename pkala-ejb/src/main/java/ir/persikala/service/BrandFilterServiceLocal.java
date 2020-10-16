package ir.persikala.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ir.persikala.consts.menu.Daste;
import ir.persikala.consts.model.MobileTablet;

@Local
public interface BrandFilterServiceLocal {


	Map<String, List<String>> getBrandFilterMap();

}
