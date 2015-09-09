package batlinerfrenzel.evolve;

import java.util.ArrayList;

public class Genome {
	
	private ArrayList<Trait> traits;

	public Genome(ArrayList<Trait> traits) {
		this.traits = traits;
	}
	
	public Trait getTraitByName(String name) {
		for (Trait trait : traits) {
			if (trait.getName().equals(name)) {
				return trait;
			}
		}
		return null;
	}
	
	public Genome breed(Genome other) {
		if (!this.isCompatible(other)) {
			return null;
		}
		ArrayList<Trait> newTraits = new ArrayList<>();
		for (Trait trait1 : this.traits) {
			newTraits.add(trait1.breed(other.getTraitByName(trait1.getName())));
		}
		return new Genome(newTraits);
	}
	
	public boolean isCompatible(Genome other) {		
		for (Trait trait1 : this.traits) {
			Trait trait2 = other.getTraitByName(trait1.getName());
			if (trait2 == null || !trait1.isCompatible(trait2)) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Trait> getTraits() {
		return traits;
	}
}
