package com.bhagya.research.business.event.dto;

import java.util.Collection;
import java.util.Date;

import com.bhagya.research.core.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import com.bhagya.research.entity.enums.DressCode;
import com.bhagya.research.entity.enums.EventCategory;
import com.bhagya.research.entity.enums.Facility;
import com.bhagya.research.entity.enums.PaymentMethod;
import com.bhagya.research.entity.enums.RiskLevel;

public class EventDTO {

	private String id;
	private String name;
	private String description;
	private Date start;
	private Date end;
	private EventCategory category;
	private String latitude;
	private String longitude;
	private String city;
	private String country;
	private DressCode dressCode;
	private ImageDTO thumbnail;
	private Collection<String> hashTags;
	private String prerequisits;
	private String registration;
	private String paymentInfo;
	private Collection<PaymentMethod> paymentMethod;
	private String foodAndDrinks;
	private int minAge;
	private String organizers;
	private Collection<Facility> facilities;
	private RiskLevel riskLevel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public DressCode getDressCode() {
		return dressCode;
	}

	public void setDressCode(DressCode dressCode) {
		this.dressCode = dressCode;
	}

	public ImageDTO getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(ImageDTO thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Collection<String> getHashTags() {
		return hashTags;
	}

	public void setHashTags(Collection<String> hashTags) {
		this.hashTags = hashTags;
	}

	public String getPrerequisits() {
		return prerequisits;
	}

	public void setPrerequisits(String prerequisits) {
		this.prerequisits = prerequisits;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public Collection<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Collection<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getFoodAndDrinks() {
		return foodAndDrinks;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public void setFoodAndDrinks(String foodAndDrinks) {
		this.foodAndDrinks = foodAndDrinks;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public Collection<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Collection<Facility> facilities) {
		this.facilities = facilities;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
