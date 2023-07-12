package com.example.demo.designpattern.command;

import com.example.demo.designpattern.command.rccommand.RcJoystickController;
import com.example.demo.designpattern.command.rccommand.RcShipXAxisCommand;
import com.example.demo.designpattern.command.rccommand.RcShipYAxisCommand;
import com.example.demo.model.RcShip;

public class RemoteControllerClient {

    public static void main(String... args) {
        RcShipXAxisCommand rcShipXAxisCommand = new RcShipXAxisCommand(new RcShip());
        RcShipYAxisCommand rcShipYAxisCommand = new RcShipYAxisCommand(new RcShip());

        RcJoystickController rcJoystickController = new RcJoystickController();
        rcJoystickController.setCommand(rcShipXAxisCommand);
        rcJoystickController.executeCommand();
        rcJoystickController.executeCommand();
        rcJoystickController.executeCommand();
        rcJoystickController.unexecuteCommand();

        rcJoystickController.setCommand(rcShipYAxisCommand);
        rcJoystickController.executeCommand();
        rcJoystickController.unexecuteCommand();
        rcJoystickController.unexecuteCommand();
    }

}
