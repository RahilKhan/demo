/**
 * 
 */
package com.example.demo.inheritance;


/*The type AbstractA cannot be a superinterface of InterfaceA; a superinterface must be an interface*/
//public interface InterfaceA extends AbstractA{

public interface InterfaceA extends InterfaceB { 	
	public void InfDisplayA();
	public void InfDisplayB();
}
