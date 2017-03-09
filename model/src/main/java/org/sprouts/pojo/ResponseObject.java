package org.sprouts.pojo;
 
public final class ResponseObject {
	
	// Attributes -------------------------------------------------------------
	
    private boolean success;
    private String message;
    
    // Constructors -----------------------------------------------------------
    
    public ResponseObject(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public ResponseObject() {
		super();
	}
    
	// Getters/Setters --------------------------------------------------------
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}