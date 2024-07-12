package com.linktic.reservas.utilities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseService {

	private String message;
	private Object data;
	private String messageError;
	private Status status;
}
