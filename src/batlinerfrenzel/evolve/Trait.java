package batlinerfrenzel.evolve;

import java.util.Random;

public class Trait {
	
	private static Random rand = new Random();
	
	private double value;
	private double min;
	private double max;
	private String name;
	
	private double mutateStdDev;
	private double mutateMean;

	public Trait(String name, double value, double min, double max, double mutateStdDev, double mutateMean) {
		if (value < min || value > max) {
			throw new IllegalArgumentException("Initial value must be between min and max");
		}
		this.value = value;
		this.name = name;
		this.min = min;
		this.max = max;
		this.mutateMean = mutateMean;
		this.mutateStdDev = mutateStdDev;
	}
	
	public void mutate() {
		this.value = this.value + (this.mutateStdDev*rand.nextGaussian() + this.mutateMean);
		if (this.value < min) {
			this.value = min;
		} else if (this.value > max) {
			this.value = max;
		}
	}
	
	public Trait breed(Trait other) {
		if (!this.isCompatible(other)) {
			return null;
		}
		double newValue = (this.value + other.value) / 2;
		Trait newTrait = new Trait(this.name, newValue, this.min, this.max, this.mutateStdDev, this.mutateMean);
		newTrait.mutate();
		return newTrait;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (this.getClass() != obj.getClass()) {
	        return false;
	    }
	    final Trait other = (Trait) obj;
	    return this.getName().equals(other.getName()) && this.getMax() == other.getMax()
	    		&& this.getMin() == other.getMin() && this.getValue() == other.getValue()
	    		&& this.getMutateMean() == other.getMutateMean() && this.getMutateStdDev() == other.getMutateStdDev();
	}
	
	public boolean isCompatible(Trait other) {
		return this.getName().equals(other.getName()) && this.getMax() == other.getMax()
	    		&& this.getMin() == other.getMin() && this.getMutateMean() == other.getMutateMean()
	    		&& this.getMutateStdDev() == other.getMutateStdDev();
	}
	
	public double getValue() {
		return value;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public String getName() {
		return name;
	}

	public double getMutateStdDev() {
		return mutateStdDev;
	}

	public double getMutateMean() {
		return mutateMean;
	}
}
