/**
 * 
 */
package com.emula.restauranteweb.controllers;

import javax.faces.bean.ManagedBean;

/**
 * @author hugol
 *
 */
@ManagedBean(name = "welcomebean", eager = true)
public class WelcomeBean {
	public WelcomeBean() {
		System.out.println("WelcomeBean Instantiated");
	}

	public String getMessage() {
		return "I'm Alive";
	}

}
