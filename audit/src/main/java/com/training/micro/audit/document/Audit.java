package com.training.micro.audit.document;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tuhindas
 *
 * @param <T>
 */
@Document
public class Audit<T> {
	
	

	@Id
	private UUID eventId=UUID.randomUUID();
	private String eventName;
	@NotNull
	private String eventType;
	private Date eventDate;
	private String userId;
	private T oldValue;
	private T newValue;

	/**
	 * @return the eventId
	 */
	public UUID getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(UUID eventId) {
		this.eventId =eventId ;
	}
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = new Date();
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the oldValue
	 */
	public Object getOldValue() {
		return oldValue;
	}
	/**
	 * @param oldValue the oldValue to set
	 */
	public void setOldValue(T oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * @return the newValue
	 */
	public Object getNewValue() {
		return newValue;
	}
	
	
	
	
	/**
	 * @param newValue the newValue to set
	 */
	public void setNewValue(T newValue) {
		this.newValue = newValue;
	}
	public Audit( String eventName, String eventType, Date eventDate, String userId,
			T oldValue, T newValue) {
		
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDate = new Date();
		this.userId = userId;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	public Audit() {
		super();
	}

}
