//package in.rtms.main.controller;
//
//import org.jp.dto.UserDtoReq;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import in.rtms.main.dto.UserResponceDTO;
//import in.rtms.main.entities.RoleEntity;
//
//public class RoleController {
//	
//	@PostMapping("/createRole")
//	public ResponseEntity<RoleEntity> saveRole(@RequestBody RoleEntity role) {
//		return new ResponseEntity<RoleEntity>(roleService.saveRole(role), HttpStatus.OK);
//
//	}
//
//}
