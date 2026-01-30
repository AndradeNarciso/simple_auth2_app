package com.andrade.simple_auth2_app.enums;




public enum Role {
    ADMIN(1L),
    REGULAR(2L);

    private long id;

    Role(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    };
    public long getRole(){return this.id;}

}
