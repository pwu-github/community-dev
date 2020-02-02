package com.wp.community.enums;

import org.omg.CORBA.PRIVATE_MEMBER;

public enum NotificationStatusEnum {
    UNREAD(1),READ(2);
    private int status;

    NotificationStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
