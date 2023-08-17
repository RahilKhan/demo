/**
 * 
 */
package com.example.demo.javafeatures.inheritance;


/*The type AbstractA cannot be a superinterface of InterfaceA; a superinterface must be an interface*/
//public interface InterfaceA extends AbstractA{

public interface InterfaceA extends InterfaceB {
	String name = null;

	public void InfDisplayA();
	public void InfDisplayB();

	/* Private interface in a method should have a body */
	private void displayMovie() {

	}
}
