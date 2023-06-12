package com.example.demo.generics;

/**
 * @author Rahil_Khan 
 * Generic class examples
 * Any variable T,E,G can be used to denote generic variable
 * Type Parameters
 *  The type parameters naming conventions are important to learn generics thoroughly. 
 *  The common type parameters are as follows:
 *   T - Type
 *   E - Element
 *   K - Key   
 *   N - Number 
 *   V - Value
 */
public class GenericClass<Y> {

	Y objG;

	public GenericClass(Y objG) {
		this.objG = objG;
	}

	public Y respond() {
		return this.objG;
	}

}
