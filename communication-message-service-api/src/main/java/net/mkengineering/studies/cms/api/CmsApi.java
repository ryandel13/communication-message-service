package net.mkengineering.studies.cms.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mkengineering.studies.cms.Message;

public interface CmsApi {
public final String CONTEXT = "message";
	
	@RequestMapping(value = CONTEXT + "/{vin}/", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Boolean> getAllCommands(@PathVariable("vin") String vin, @RequestBody Message message);
	
	@RequestMapping(value = CONTEXT + "/{vin}/pending", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Message>> getPendingMessage(@PathVariable("vin") String vin);
	
	@RequestMapping(value = CONTEXT + "/{vin}/pop", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Message> popNextMessage(@PathVariable("vin") String vin);
	
}
