package com.genieworks.ginterface.common.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Timestamp;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
    private Meta meta;
    private T body;

    @Data
    private class Meta {
        private String path;
        private Integer status;
        private String message;
        private String timestamp;
        private String trace;
    }
    @JsonIgnore
    public ApiResult(HttpStatus httpStatus, String message, T body) {
        this.meta = new Meta();
        this.meta.setStatus(httpStatus.value());
        this.meta.setMessage(message);
        this.meta.setTimestamp(new Timestamp(new Date().getTime()).toString());
        this.meta.setPath(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI());

        this.body = body;
    }
    @JsonIgnore
    public ApiResult(Exception e) {
        this.meta = new Meta();
        this.meta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.meta.setMessage(e.getMessage());
        this.meta.setTimestamp(new Timestamp(new Date().getTime()).toString());
        this.meta.setPath(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI());

        this.meta.setTrace(ExceptionUtils.getStackTrace(e));
    }

    @JsonIgnore
    public static <T> ResponseEntity<ApiResult<T>> getResponse(HttpStatus httpStatus) {
        return getResponse(httpStatus, "", null);
    }
    @JsonIgnore
    public static <T> ResponseEntity<ApiResult<T>> getResponse(HttpStatus httpStatus, String message) {
        return getResponse(httpStatus, message, null);
    }
    @JsonIgnore
    public static <T> ResponseEntity<ApiResult<T>> getResponse(HttpStatus httpStatus, T body) {
        return getResponse(httpStatus, "", body);
    }
    @JsonIgnore
    public static <T> ResponseEntity<ApiResult<T>> getResponse(HttpStatus httpStatus, String message, T body) {
        return new ResponseEntity<>(new ApiResult<>(httpStatus, message, body), httpStatus);
    }

    @JsonIgnore
    public static ResponseEntity<ApiResult<Void>> getResponse(Exception e) {
        return new ResponseEntity<>(new ApiResult<>(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
