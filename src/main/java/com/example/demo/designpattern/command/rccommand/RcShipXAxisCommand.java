package com.example.demo.designpattern.command.rccommand;

import com.example.demo.designpattern.command.Command;
import com.example.demo.model.RcShip;

/**
 * Concrete implementation of command interface
 */
public class RcShipXAxisCommand implements Command {

    RcShip rcShip;

    public RcShipXAxisCommand(RcShip rcShip) {
        this.rcShip = rcShip;
    }

    @Override
    public void execute() {
        rcShip.sailForward();
    }

    @Override
    public void unExecute() {
        rcShip.sailBackward();
    }

}
