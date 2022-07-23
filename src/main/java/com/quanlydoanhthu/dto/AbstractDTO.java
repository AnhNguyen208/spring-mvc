package com.quanlydoanhthu.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO<T> {
	private Long id;
	private Date createdDateTimestamp;
	private Date modifiedDateTimestamp;
	private String createByString;
	private String modifiedByString;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Integer page;
	private Integer limit;
	private Integer totalPage;
	private Integer totalItem;
	private String sortNameString;
	private String sortByString;
	private String alertString;
	private String messageString;
	private String typeString;
	
	public Date getCreatedDateTimestamp() {
		return createdDateTimestamp;
	}

	public void setCreatedDateTimestamp(Date createdDateTimestamp) {
		this.createdDateTimestamp = createdDateTimestamp;
	}

	public Date getModifiedDateTimestamp() {
		return modifiedDateTimestamp;
	}

	public void setModifiedDateTimestamp(Date modifiedDateTimestamp) {
		this.modifiedDateTimestamp = modifiedDateTimestamp;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedDateTimestamp(Timestamp createdDateTimestamp) {
		this.createdDateTimestamp = createdDateTimestamp;
	}

	public void setModifiedDateTimestamp(Timestamp modifiedDateTimestamp) {
		this.modifiedDateTimestamp = modifiedDateTimestamp;
	}

	public String getCreateByString() {
		return createByString;
	}

	public void setCreateByString(String createByString) {
		this.createByString = createByString;
	}

	public String getModifiedByString() {
		return modifiedByString;
	}

	public void setModifiedByString(String modifiedByString) {
		this.modifiedByString = modifiedByString;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public String getAlertString() {
		return alertString;
	}

	public void setAlertString(String alertString) {
		this.alertString = alertString;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

}
