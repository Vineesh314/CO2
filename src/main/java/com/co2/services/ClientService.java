package com.co2.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.co2.exceptions.ClientNotFoundException;
import com.co2.models.Client;
import com.co2.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client save(Client newClient) {
		return clientRepository.save(newClient);
	}

	public Client findById(Long id) {
		return clientRepository.findById(id).get();
	}

	public Client saveOrUpdate(Client newClient, Long id) {
		return clientRepository.findById(id).map(x -> {
			x.setClientId(newClient.getClientId());
			x.setClientCode(newClient.getClientCode());
			x.setClientName(newClient.getClientName());
			return clientRepository.save(x);
		}).orElseGet(() -> {
			newClient.setClientId(id);
			return clientRepository.save(newClient);
		});
	}

	public Client patch(Map<String, String> update, Long id) {
		return clientRepository.findById(id).map(x -> {

			String clientName = update.get("clientName");
			if (!StringUtils.isEmpty(clientName)) {
				x.setClientName(clientName);

				// better create a custom method to update a value = :newValue where id = :id
				return clientRepository.save(x);
			} else {
				throw new ClientNotFoundException(id);
			}

		}).orElseGet(() -> {
			throw new ClientNotFoundException(id);
		});
	}

	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

}
