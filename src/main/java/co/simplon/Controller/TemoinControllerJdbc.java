package co.simplon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ModelEntity.TemoinJdbc;
import co.simplon.Service.TemoinService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jdbc")
public class TemoinControllerJdbc {
	
	@Autowired
	TemoinService temoinService;
	
	@RequestMapping (value = "/temoins", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTemoin(){
		List<TemoinJdbc> listeTemoin = null;
		try {
			listeTemoin = temoinService.getAllTemoin();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(listeTemoin);
	}
	

}
