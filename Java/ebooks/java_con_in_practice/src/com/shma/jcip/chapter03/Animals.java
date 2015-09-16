package com.shma.jcip.chapter03;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class Animals {

	private Ark ark = new Ark();
	
	public int loadTheArk(Collection<Animal> candidates) {
		Set<Animal> animals;
		int numPairs = 0;
		Animal candidate = null;
		
		animals = new TreeSet<Animals.Animal>(new SpeciesGenderComparator());
		animals.addAll(candidates);
		
		for(Animal animal : animals) {
			if(candidate == null || !candidate.isPotentialMate(animal)) {
				candidate = animal;
			} else {
				ark.load(new AnimalPair(candidate, animal));
				++numPairs;
				candidate = null;
			}
		}
		
		return numPairs;
	}
	
	class Animal {
		private Species species;
		private Gender gender;
		
		public boolean isPotentialMate(Animal other) {
			return species == other.species && gender != other.gender;
		}
	}
	
	enum Species {
        AARDVARK, BENGAL_TIGER, CARIBOU, DINGO, ELEPHANT, FROG, GNU, HYENA,
        IGUANA, JAGUAR, KIWI, LEOPARD, MASTADON, NEWT, OCTOPUS,
        PIRANHA, QUETZAL, RHINOCEROS, SALAMANDER, THREE_TOED_SLOTH,
        UNICORN, VIPER, WEREWOLF, XANTHUS_HUMMINBIRD, YAK, ZEBRA
    }

    enum Gender {
        MALE, FEMALE
    }
    
    class AnimalPair {
    	private final Animal one, two;
    	
    	public AnimalPair(Animal one, Animal two) {
    		this.one = one;
    		this.two = two;
    	}
    }

    class SpeciesGenderComparator implements Comparator<Animal> {

		@Override
		public int compare(Animal one, Animal two) {

			int speciesCompare = one.species.compareTo(two.species);
			
			return (speciesCompare!=0) ? speciesCompare : one.gender.compareTo(two.gender);
		}
    	
    }
    
    class Ark {
    	private final Set<AnimalPair> loadedAnimals = new HashSet<Animals.AnimalPair>();
    	
    	public void load(AnimalPair pair) {
    		loadedAnimals.add(pair);
    	}
    }
}
