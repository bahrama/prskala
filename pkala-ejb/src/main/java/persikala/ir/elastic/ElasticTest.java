package persikala.ir.elastic;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class ElasticTest
 */
@Stateless
public class ElasticTest implements ElasticTestLocal {

    /**
     * Default constructor. 
     */
    public ElasticTest() {
        // TODO Auto-generated constructor stub
    }
  @Override
  public void findElasticTest() {
  	Client client=ClientBuilder.newClient();
  	String targetResource="http://192.168.10.77:9200/alindx1/_doc/2";
  	Response response=client.target(targetResource)
  			.request(MediaType.APPLICATION_JSON).delete();
  	System.err.println(response.readEntity(String.class));
  			
  }
}
