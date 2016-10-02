package services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

import entity.Client;

@Service("clients")
public class ClientQueryService implements IClientService {

	public Set<Client> getAllClents() {
		return Sets.newHashSet(//
				new Client("wms123", "wms123", "wms"), //
				new Client("oms123", "wms123", "oms"), //
				new Client("sku123", "sku123", "sku")//
		);
	}

}
