package sj223gb_assign2.exercise1;

/**
* Class that sets  and validates rules for Attributes.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Attributes {

    private int strength;
    private int agility;
    private int intelligence;
    private int wisdom;
    
    public Attributes(int str, int agi, int intel, int wis) {
        this.setStrength(str);
        this.setAgility(agi);
        this.setIntelligence(intel);
        this.setWisdom(wis);
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {

        if (minMaxAttribute(wisdom)) {
            this.wisdom = wisdom;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        
        if (minMaxAttribute(intelligence)) {
            this.intelligence = intelligence;
        }
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {

        if (minMaxAttribute(agility)) {
            this.agility = agility;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        
        if (minMaxAttribute(strength)) {
            this.strength = strength;
        }
    }

    /**
     * Checks that the attributes do not go below or above accepted values.
     * 
     * @param attr - The attribute to be checked.
     * @return - Boolean.
     */
    private boolean minMaxAttribute(int attr) {

        if (attr >= Boundaries.MIN_ATTRIBUTE && attr <= Boundaries.MAX_ATTRIBUTE) {
            return true;
        }
        throw new IllegalArgumentException("Attribute: " + attr + " is out of bounds.");
    }

}
