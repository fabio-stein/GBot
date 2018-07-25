package com.fabiolux.gbot.api.enums;

public enum ORDER_CHANGE_REASON {
    /**
     * Simple create order
     */
    CREATED,
    /**
     * Item was created before time limit of last check, for example
     * if the time for check limit is 10 seconds and last executed check
     * was more than 10 secs ago, the creation time for the new order is unknown
     */
    CREATED_TIME_UNKNOWN,
    /**
     * A trade executed has completely finished all the order amount
     */
    TERMINATED_BY_TRADE,
    /**
     * If the update is inside the last check limits, then the order
     * was terminated manually
     */
    TERMINATED_MANUALLY,
    /**
     * Is inside last check limits and have not identified what trade
     * executed that have terminated the order
     */
    TERMINATED_UNKNOWN,
    /**
     * It is outside last check limits and the order is terminated
     */
    TERMINATED_TIME_UNKNOWN,
    /**
     * A trade with the same value, but with not enought amount to terminate
     * the order
     */
    VALUE_CHANGED_BY_TRADE,
    /**
     * Value has changed but not found a trade with same value
     */
    VALUE_CHANGED_UNKNOWN,
    /**
     * Outside last check limits, and value is different
     */
    VALUE_CHANGED_TIME_UNKNOWN
}
