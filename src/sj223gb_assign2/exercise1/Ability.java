package sj223gb_assign2.exercise1;

/**
* Class that sets  and validates rules for Abilities.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Ability {
    
    private String name;
    private Proficiency proficiency;
    
    public Ability(String name, Proficiency prof) {
        this.setName(name);
        this.setProficiency(prof);
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {

        // Validates the proficiency.
        if (validateProficiency(proficiency)) {
            this.proficiency = proficiency;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        // Validates length.
        if (validateName(name)) {
            this.name = name;
        }
    }

    /**
     * Checks that the proficiency inserted is allowed among the proficiency enums.
     * 
     * @param prof - The proficiency to validate.
     * @return - Boolean.
     */
    private boolean validateProficiency(Proficiency prof) {

        if (Proficiency.isValid(prof)) {
            return true;
        }
        throw new IllegalArgumentException("The proficiency: " + prof + " is not a valid proficiency.");
    }

    private boolean validateName(String name) {

        // Verifies that the length of a name is not below or greater than maximum and minimum.
        if (name.length() >= Boundaries.MIN_SPELLABILITY && name.length() <= Boundaries.MAX_SPELLABILITY) {
            return true;       
        }
        throw new IllegalArgumentException("The profienency name: " + name + " is out of bounds.");
    }
}
