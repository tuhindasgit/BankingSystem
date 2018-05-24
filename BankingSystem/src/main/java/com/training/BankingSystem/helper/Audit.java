package com.training.BankingSystem.helper;

import java.util.Date;
import java.util.UUID;
/**
 * 
 * @author trainee
 *
 * @param <T>
 */

public class Audit<T> {

	private UUID eventId=UUID.randomUUID();
	private String eventName;
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
	public void setEventId(final UUID eventId) {
		this.eventId = eventId;
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
	public void setEventName(final String eventName) {
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
	public void setEventType(final String eventType) {
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
	public void setEventDate(final Date eventDate) {
		this.eventDate = eventDate;
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
	public void setUserId(final String userId) {
		this.userId = userId;
	}
	/**
	 * @return the oldValue
	 */
	public T getOldValue() {
		return oldValue;
	}
	/**
	 * @param oldValue the oldValue to set
	 */
	public void setOldValue(final T oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * @return the newValue
	 */
	public T getNewValue() {
		return newValue;
	}
	/**
	 * @param newValue the newValue to set
	 */
	public void setNewValue(final T newValue) {
		this.newValue = newValue;
	}
	/**
	 * 
	 * @param eventId
	 * @param eventName
	 * @param eventType
	 * @param eventDate
	 * @param userId
	 * @param oldValue
	 * @param newValue
	 */
	public Audit(final UUID eventId, final String eventName, final String eventType, final Date eventDate, final String userId, final T oldValue,
			final T newValue) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.userId = userId;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	/**
	 * no parameter constructor
	 */
	public Audit() {
		super();
	}
	

}
