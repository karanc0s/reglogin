package com.karan.reglogin.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

@Data
@Builder
@AllArgsConstructor
@NonNull
public class AppErrorResponse {
    private String message;
}
