package in.rtms.main.dto;

import in.rtms.main.entities.RoleEntity;
import lombok.Data;

@Data
public class UserRequestDTO {
	private String username;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;
	private String password;

	private RoleEntity role;

}
