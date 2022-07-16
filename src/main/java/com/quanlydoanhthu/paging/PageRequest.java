package com.quanlydoanhthu.paging;

public class PageRequest implements Pageble{
	private Integer pageInteger;
	private Integer maxPageItemInteger;
	private Sorter sorter;
	
	public PageRequest (Integer page, Integer maxPageItem, Sorter sorter) {
		this.pageInteger = page;
		this.maxPageItemInteger = maxPageItem;
		this.sorter = sorter;
	}

	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		
		return this.pageInteger;
	}

	@Override
	public Integer getOffset() {
		if(this.pageInteger != null && this.maxPageItemInteger != null) {
			return (this.pageInteger - 1) * this.maxPageItemInteger;			
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		
		return maxPageItemInteger;
	}
	
}
