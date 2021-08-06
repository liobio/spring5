package com.liobio.factory;

import com.liobio.bean.Airplane;

public class AirPlaneStaticFactory {

    //AirPlaneStaticFactory.getAirPlane()
    public static Airplane getAirPlane(String Captain) {
        System.out.println("AirPlaneStaticFactory is running");
        Airplane airplane = new Airplane();
        airplane.setCaptain(Captain);
        airplane.setEngine("太行");
        airplane.setAssistant_captain("zyc");
        airplane.setCarrying(300);
        airplane.setWing_length("145.23m");
        return airplane;
    }

}
