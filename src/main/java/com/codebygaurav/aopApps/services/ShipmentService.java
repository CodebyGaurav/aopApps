package com.codebygaurav.aopApps.services;

public interface ShipmentService {

    String orderPackage(Long orderId);
    String trackPackage(Long orderId);

}
