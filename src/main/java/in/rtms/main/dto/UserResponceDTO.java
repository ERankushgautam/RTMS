package in.rtms.main.dto;

import in.rtms.main.entities.RoleEntity;
import lombok.Data;

@Data
public class UserResponceDTO {

	private String username;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;

	private RoleEntity role;
}
