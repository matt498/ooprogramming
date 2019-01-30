package DataEntry;

import java.util.UUID;

public class Mortadella {
	UUID id;
	double lenght;
	double diameter;
	double weight;
	String quality;
	
	public Mortadella(UUID id, double lenght, double diameter, double weigth, String quality) {
		this.id = id;
		this.lenght = lenght;
		this.diameter = diameter;
		this.weight = weigth;
		this.quality = quality;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getWeigth() {
		return weight;
	}

	public void setWeigth(double weigth) {
		this.weight = weigth;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "Mortadella [id=" + id + ", lenght=" + lenght + ", diameter=" + diameter + ", weigth=" + weight
				+ ", quality=" + quality + "]";
	}
}
