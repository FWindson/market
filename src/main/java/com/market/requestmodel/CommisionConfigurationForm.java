package com.market.requestmodel;

import java.util.List;

import com.market.domain.CommisionConfiguration;

public class CommisionConfigurationForm {

	private String targetId;
	private short targetType;
	private List<CommisionConfigurationFormItem> commisionConfigurations;

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public short getTargetType() {
		return targetType;
	}

	public void setTargetType(short targetType) {
		this.targetType = targetType;
	}

	public List<CommisionConfigurationFormItem> getCommisionConfigurations() {
		return commisionConfigurations;
	}

	public void setCommisionConfigurations(List<CommisionConfigurationFormItem> commisionConfigurations) {
		this.commisionConfigurations = commisionConfigurations;
	}

}
