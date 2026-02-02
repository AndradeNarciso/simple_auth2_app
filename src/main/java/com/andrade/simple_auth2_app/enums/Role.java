package com.andrade.simple_auth2_app.enums;




public enum Role {
    ADMIN("ADMIN"),
    REGULAR("USER");

    private String value;

    Role(String value){
        this.value=value;
    }

    public String getValue() {
        return this.value;
    }

  


}
