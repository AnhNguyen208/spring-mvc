package com.quanlydoanhthu.paging;

public class Sorter {
	private String sortNameString;
	private String sortByString;
	
	public Sorter(String sortNameString, String sortByString) {
		this.sortNameString = sortNameString;
		this.sortByString = sortByString;
	}

	public String getSortNameString() {
		return sortNameString;
	}

	public void setSortNameString(String sortNameString) {
		this.sortNameString = sortNameString;
	}

	public String getSortByString() {
		return sortByString;
	}

	public void setSortByString(String sortByString) {
		this.sortByString = sortByString;
	}
	
}
