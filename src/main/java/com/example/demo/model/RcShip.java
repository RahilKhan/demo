package com.example.demo.model;

import lombok.extern.slf4j.Slf4j;


/*Receiver in Command Pattern*/
@Slf4j
public class RcShip {
    public void sailForward() {
        log.info("Ship sail forward");
    }
    public void sailBackward() {
        log.info("Ship sail backward");
    }

    public void turnLeft() {
        log.info("Ship turning left");
    }
    public void turnRight() {
        log.info("Ship turning right");
    }

}
