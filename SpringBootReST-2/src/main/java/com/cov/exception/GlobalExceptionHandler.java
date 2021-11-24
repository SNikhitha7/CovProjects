
package com.cov.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	public ResponseEntity<String> aaa(InvalidEmployeeIdException invalidEmployeeIdException) {
		String errorResponse = invalidEmployeeIdException.getMessage();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> aaa(InvalidDepartmentIdException invalidDepartmentIdException) {
		String errorResponse = invalidDepartmentIdException.getMessage();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidEmployeeIdException.class)
	public ResponseEntity<ErrorResponse> invalidEmployeeIdhandler(
			InvalidDepartmentIdException InvalidEmployeeIdException) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = InvalidEmployeeIdException.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		logger.info("status :" + status);
		logger.info("message :" + message);
		return new ResponseEntity<>(errorResponse, status);

	}

	@ExceptionHandler(value = InvalidDepartmentIdException.class)
	public ResponseEntity<ErrorResponse> invalidDepartmentIdhandler(
			InvalidDepartmentIdException InvalidDepartmentIdException) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = InvalidDepartmentIdException.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		logger.info("status :" + status);
		logger.info("message :" + message);
		return new ResponseEntity<>(errorResponse, status);

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> otherHandler(Exception exception) {
		String message = exception.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
