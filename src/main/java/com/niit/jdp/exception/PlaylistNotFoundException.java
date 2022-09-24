/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.exception;

public class PlaylistNotFoundException extends Exception {

    final String message;

    public PlaylistNotFoundException(String str) {
        message = str;
    }

    @Override
    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }
}
