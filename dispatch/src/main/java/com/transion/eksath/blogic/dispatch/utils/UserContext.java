package com.transion.eksath.blogic.dispatch.utils;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
    public static final String CORRELATION_ID = "trnsyn-1sath-blogic-correlation-id"; //change it later according to the use
    public static final String AUTH_TOKEN = "trnsyn-1sath-blogic-auth-token";
    public static final String USER_ID = "trnsyn-1sath-blogic-user-id";
    public static final String ORG_ID = "trnsyn-1sath-blogic-org-id";
    public static final String STAKEHOLDER_ID = "trnsyn-1sath-blogic-stkhldr-id";

    private String correlationId = new String();
    private String authToken = new String();
    private String userId = new String();
    private String orgId = new String();
    private String stkhldrId = new String();

    public String getCorrelationId(){
        return correlationId;
    }

    public void setCorrelationId(String correlationId){
        this.correlationId = correlationId;
    }

    public String getAuthToken(){
        return authToken;
    }

    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getOrgId(){
        return orgId;
    }

    public void setOrgId(String orgId){
        this.orgId = orgId;
    }

    public String getStkHldrId(){
        return stkhldrId;
    }

    public void setStkHldrId(String stkhldrId){
        this.stkhldrId = stkhldrId;
    }

}

