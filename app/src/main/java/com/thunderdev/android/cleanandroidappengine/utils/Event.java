package com.thunderdev.android.cleanandroidappengine.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Audrik ! on 09/10/2016.
 */

public class Event {

    @StringDef({EVENT_TYPE_ERROR, EVENT_TYPE_SUCCESS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {}
    public static final String EVENT_TYPE_SUCCESS = "SUCCESS";
    public static final String EVENT_TYPE_ERROR = "ERROR";

    private String mEventType;
    private String mMessage;

    public Event(@EventType String eventType, String message) {
        this.mEventType = eventType;
        this.mMessage = message;
    }

    public String getEventType() {
        return mEventType;
    }

    public String getMessage() {
        return mMessage;
    }
}
