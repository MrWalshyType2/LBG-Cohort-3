package com.qa.lbg_examples.collections.maps;

import java.util.Objects;

public abstract class MenuItem {
	
	private String title;
	
	public MenuItem(String title) {
		this.title = title;
	}
	
	public abstract void execute(String[] args);

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		return Objects.equals(title, other.title);
	}
	
}