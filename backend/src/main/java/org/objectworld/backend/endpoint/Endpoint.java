package org.objectworld.backend.endpoint;

import java.util.Map;
import java.util.Random;

import org.objectworld.backend.payload.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Tag(name = "테스트 API", description = "테스트 API 서비스입니다.")
@Slf4j
public class Endpoint {

	@Operation(summary = "테스트 Get API", description = "테스트용 GET API 입니다.")
	@GetMapping(path = "/get")
	public Payload get(@RequestHeader Map<String, Object> requestHeader) {
		log.info("[REQ]get api headers : {}", requestHeader);

		return Payload.builder().code("200").message("success").service("backend1 get").data("").build();
	}
	
	@Operation(summary = "테스트 Post API", description = "테스트용 Post API 입니다.")
	@PostMapping(path = "/post")
	public Payload pot(@RequestHeader Map<String, Object> requestHeader, @RequestBody String body) {
		log.info("[REQ]get api headers : {}, body : {}", requestHeader, body);

		return Payload.builder().code("200").message("success").service("backend1 get").data(body).build();
	}
	
	@Operation(summary = "테스트 Auth Get API", description = "테스트용 Auth GET API 입니다.")
	@GetMapping(path = "/auth/get")
	public Payload authGet(@RequestHeader Map<String, Object> requestHeader, @RequestBody String body) {
		log.info("[REQ]get api headers : {}, body : {}", requestHeader, body);

		return Payload.builder().code("200").message("success").service("backend1 auth").data(body).build();
	}
	
	@Operation(summary = "테스트 Root API", description = "테스트용 Root API 입니다.")
	@GetMapping(path = "/")
	public Payload root(@RequestHeader Map<String, Object> requestHeader, @RequestBody String body) {
		log.info("[REQ]root api headers : {}, body : {}", requestHeader, body);

		return Payload.builder().code("200").message("success").service("backend1 root").data(body).build();
	}

	@Operation(summary = "테스트 Delay API", description = "테스트용 Delay API 입니다.")
	@GetMapping(path = "/delay")
	public Payload delay(@RequestHeader Map<String, Object> requestHeader, @RequestBody String body) {
		log.info("[REQ]delay api headers : {}, body : {}", requestHeader, body);
		
		try {
			Random rand = new Random();
			if(rand.nextInt()%5==1) {
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			log.error("error: ",e);
		}

		log.info("[RES]delay api");
		return Payload.builder().code("200").message("success").service("backend1 delay").data(body).build();
	}

}