package com.example.coach.models;

import junit.framework.TestCase;

public class ProfileTest extends TestCase {

    private Profile profile=new Profile(67,165,35,0);
    private float img=(float)32.2;
    private String message="Trop gros";

    public void testGetImg() {
        assertEquals(img,profile.getImg(),(float)0.1);
    }

    public void testGetIndication() {
        assertEquals(message,profile.getIndication());
    }

}