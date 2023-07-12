package com.example.demo.designpattern.command.rccommand;

import com.example.demo.designpattern.command.Command;
import com.example.demo.model.RcShip;

/**
 * Concrete implementation of command interface
 */
public class RcShipYAxisCommand implements Command {

    RcShip rcShip;

    public RcShipYAxisCommand(RcShip rcShip){
        this.rcShip = rcShip;
    }

    @Override
    public void execute() {
        rcShip.turnLeft();
    }

    @Override
    public void unExecute() {
        rcShip.turnRight();
    }
}
