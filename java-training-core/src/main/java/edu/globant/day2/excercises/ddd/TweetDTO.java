package edu.globant.day2.excercises.ddd;

public class TweetDTO {

	private String userName;
	private Long idUser;
	private String message;
	
	public TweetDTO(String userName, Long idUser, String message) {
		this.userName = userName;
		this.idUser = idUser;
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public Long getIdUser() {
		return idUser;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
}
