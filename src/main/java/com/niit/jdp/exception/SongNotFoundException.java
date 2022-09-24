/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.exception;

public class SongNotFoundException extends Exception {
    String message;

    public SongNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }
}
