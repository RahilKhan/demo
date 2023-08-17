/**
 * 
 */
package com.example.demo.designpattern.command.lightcommand;

import com.example.demo.designpattern.command.Command;

/**
 * @author Rahil_Khan
 * 
 */
public class SimpleRemoteControl {

	Command slot;
	
	public SimpleRemoteControl(){}
	
	public void setCommand(Command command) {
		this.slot = command;
	}
	
	public void exectue() {
		slot.execute();
	}
}
