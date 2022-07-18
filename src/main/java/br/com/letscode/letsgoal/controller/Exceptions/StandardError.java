package br.com.letscode.letsgoal.controller.Exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    public StandardError(Integer status, String msg, Long timeStapm) {
        this.status = status;
        this.msg = msg;
        this.timeStapm = timeStapm;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStapm() {
        return timeStapm;
    }

    public void setTimeStapm(Long timeStapm) {
        this.timeStapm = timeStapm;
    }

    private Integer status;
    private String msg;
    private Long timeStapm;


}
