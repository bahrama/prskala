package persikala.ir.test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import persikala.ir.elastic.ElasticTestLocal;

@Named
@SessionScoped
public class ElasticBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ElasticTestLocal elasticTestLocal;

	public ElasticBean() {
		
	}
	
	public void findElasticTest() {
		elasticTestLocal.findElasticTest();
	}
	


}
