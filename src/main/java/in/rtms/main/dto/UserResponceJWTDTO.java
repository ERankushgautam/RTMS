package in.rtms.main.dto;

import in.rtms.main.entities.RoleEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponceJWTDTO {
	
	private String token;
	private String username;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;

	private RoleEntity role;
}
