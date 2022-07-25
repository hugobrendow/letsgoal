package br.com.letscode.letsgoal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BadErrorClass {
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING
            , pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
            , timezone = "GMT")
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
