package com.bhagya.research.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.bhagya.research.entity.enums.DressCode;
import com.bhagya.research.entity.enums.EventCategory;
import com.bhagya.research.entity.enums.Facility;
import com.bhagya.research.entity.enums.PaymentMethod;
import com.bhagya.research.entity.enums.RiskLevel;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "start", nullable = false)
	private Date start;

	@Column(name = "end", nullable = false)
	private Date end;

	@Column(name = "category", nullable = false)
	private EventCategory category;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "dress_code", nullable = false)
	private DressCode dressCode;

	@Column(name = "risk_level", nullable = false)
	private RiskLevel riskLevel;

	@Column(name = "thumbnail")
	private String thumbnail;

	@ElementCollection
	@Column(name = "hash_tags")
	private Collection<String> hashTags;

	@Column(name = "prerequisits")
	private String prerequisits;

	@Column(name = "registration")
	private String registration;

	@Column(name = "payment")
	private String paymentInfo;

	@ElementCollection
	@JoinTable(joinColumns = {@JoinColumn(name = "id")})
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method", nullable = false)
	private Collection<PaymentMethod> paymentMethod;

	@Column(name = "food_and_drinks")
	private String foodAndDrinks;

	@Column(name = "minimumAge")
	private int minAge;

	@Column(name = "organizers")
	private String organizers;

	@ElementCollection
	@JoinTable(joinColumns = {@JoinColumn(name = "id")})
	@Enumerated(EnumType.STRING)
	@Column(name = "facilities", nullable = false)
	private Collection<Facility> facilities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public String getFoodAndDrinks() {
		return foodAndDrinks;
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

	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
	}

	public DressCode getDressCode() {
		return dressCode;
	}

	public void setDressCode(DressCode dressCode) {
		this.dressCode = dressCode;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Collection<String> getHashTags() {
		return hashTags;
	}

	public void setHashTags(Collection<String> hashTags) {
		this.hashTags = hashTags;
	}

	public Collection<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Collection<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Collection<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Collection<Facility> facilities) {
		this.facilities = facilities;
	}

}
