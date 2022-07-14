package br.com.letscode.letsgoal.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fieldName;
    private String message;

//    public FieldMessage() {
//    }

//    public FieldMessage(String fieldName, String message) {
//        this.fieldName = fieldName;
//        this.message = message;
//    }
//
//    public String getFieldName() {
//        return fieldName;
//    }
//
//    public void setFieldName(String fieldName) {
//        this.fieldName = fieldName;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
}
