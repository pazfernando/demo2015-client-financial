package ec.com.softwareevolutivo.demos.client.info.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ec.com.softwareevolutivo.demos.client.info.FinancialService;

@Path("/financial")
public class FinancialServiceImpl implements FinancialService {
	public static final Map<String, Map<String, Object>> data = new LinkedHashMap<>();

	static {
		Map<String, Object> info = new LinkedHashMap<>();
		info.put("DINERS", 578.54);
		info.put("VISA BOLIVARIANO", 2000.00);
		info.put("BIESS", 68752.25);
		data.put("1715303004", info);
	}

	@Path("/{identification}")
	@GET
	@Produces({ "application/json" })
	@Override
	public Map<String, Object> liabilities(
			@PathParam("identification") String identification) {
		if (data.containsKey(identification)) {
			return data.get(identification);
		}
		return null;
	}
}
