package entities;

import entities.enums.OcurrenceStatus;
import entities.enums.OcurrenceTitle;

public class Ocurrence {

	private OcurrenceTitle title;
	private String description;
	private String streetAddress;
	private OcurrenceStatus status;
	
	public Ocurrence() {
	}

	public Ocurrence(OcurrenceTitle title, String description, String streetAddress, OcurrenceStatus status) {
		this.title = title;
		this.description = description;
		this.streetAddress = streetAddress;
		this.status = status;
	}

	public OcurrenceTitle getTitle() {
		return title;
	}

	public void setTitle(OcurrenceTitle title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAdress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public OcurrenceStatus getStatus() {
		return status;
	}

	public void setStatus(OcurrenceStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("\n").append("Ocurrence: ").append(title).append("\n");
	    sb.append("Description: ").append(description).append("\n");
	    sb.append("Rua: ").append(streetAddress).append("\n");
	    sb.append("Status: ").append(status).append("\n");
	    
	    return sb.toString();
	}
	
	
}
