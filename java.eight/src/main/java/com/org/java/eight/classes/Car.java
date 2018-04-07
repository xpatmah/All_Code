package com.org.java.eight.classes;

import com.org.java.interfaces.eight.Engine;
import com.org.java.interfaces.eight.Vechicle;

public class Car implements Engine, Vechicle{

	public String makeandmodel() {
		return Vechicle.super.make();
	}
}
