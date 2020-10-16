package ir.persikala.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ir.persikala.consts.menu.Daste;

@Local
public interface MenuContentsServiceLocal {

	Map<Daste, List<String>> getMenuMap();

}
