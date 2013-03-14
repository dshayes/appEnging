package mainstuff;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(name = "lookup")
public class AndoirdEndpoint {
	@ApiMethod(name = "battleLog.get")
	public void something(){
		
	}
}
