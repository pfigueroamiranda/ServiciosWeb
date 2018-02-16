package com.seit.silaba.utilities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andy410 on 08/01/2016.
 */
public class SilabaAnswerWS<T> implements Serializable
{

    private String status;
    private List<T> listResponse;
    private SilabaError  error;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getListResponse() {
        return listResponse;
    }

    public void setListResponse(List<T> listResponse) {
        this.listResponse = listResponse;
    }

    public SilabaError getError() {
        return error;
    }

    public void setError(SilabaError error) {
        this.error = error;
    }
}

