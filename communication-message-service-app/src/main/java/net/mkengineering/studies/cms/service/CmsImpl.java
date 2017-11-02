package net.mkengineering.studies.cms.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.mkengineering.studies.cms.Message;
import net.mkengineering.studies.cms.api.CmsApi;

@RestController
public class CmsImpl implements CmsApi{

	Map<String, LinkedList<Message>> messages = new HashMap<>();
	
	@Override
	public ResponseEntity<Boolean> sendCommand(@PathVariable String vin, @RequestBody Message message) {
		LinkedList ll;
		if(messages.containsKey(vin)) {
			ll = messages.get(vin);
		} else {
			ll = new LinkedList<Message>();
		}
		ll.add(message);
		messages.put(vin, ll);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<Message>> getPendingMessage(@PathVariable String vin) {
		return new ResponseEntity<List<Message>>(messages.get(vin), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Message> popNextMessage(@PathVariable String vin) {
		LinkedList ll = messages.get(vin);
		if(ll.size() > 0) {
			Message m = (Message)ll.removeFirst();
			return new ResponseEntity<Message>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
		}
			
		
	}

}
