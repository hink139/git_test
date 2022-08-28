package com.example.fides.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
	private String username;
	private String password;



	@Data
    public static class ForgotPasswordRequest {
		@Email
		private String email;
		private String userId;
		private String phoneNumber;
    }


	@Data
	public static class searchIdRequest{
		@NotEmpty
		private String username;
		private String email;
		private String phoneNumber;
	}
}
