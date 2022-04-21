package com.marathon.reto.model.exception;

import org.springframework.http.HttpStatus;

public class MarathonGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public MarathonGenericException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public static class Builder {

		private HttpStatus status;
		private String message;

		public Builder withStatusNotFound() {
			this.status = HttpStatus.NOT_FOUND;
			return this;
		}

		public Builder withStatusUnauthorized() {
			this.status = HttpStatus.UNAUTHORIZED;
			return this;
		}

		public Builder withStatusInternalServerError() {
			this.status = HttpStatus.INTERNAL_SERVER_ERROR;
			return this;
		}

		public Builder withStatusBadRequest() {
			this.status = HttpStatus.BAD_REQUEST;
			return this;
		}

		public Builder withCustomHttpStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public Builder withCustomMessage(String message) {
			this.message = message;
			return this;
		}

		public MarathonGenericException build() {
			return new MarathonGenericException(status, message);
		}

	}

	public HttpStatus getStatus() {
		return status;
	}

}