package sj223gb_assign2.exercise1;

/**
* Class that sets  and validates rules for Spells.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Spell {
    
    private String name;
    private SchoolOfMagic school;

    public Spell(String name, SchoolOfMagic school) {
        this.setName(name);
        this.setSchool(school);
    }

    public SchoolOfMagic getSchool() {
        return school;
    }

    public void setSchool(SchoolOfMagic school) {

        // Validates the school.
        if (validateSchool(school)) {
            this.school = school;
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
     * Checks that the school of magic inserted is allowed among the schoolOfMagic enums
     * 
     * @param school - The school of magic to validate.
     * @return - Boolean.
     */
    private boolean validateSchool(SchoolOfMagic school) {

        if (SchoolOfMagic.isValid(school)) {
            return true;
        }
        throw new IllegalArgumentException("The school: " + school + " is not a valid school.");
    }

    private boolean validateName(String name) {

        // Verifies that the length of a name is not below or greater than maximum and minimum.
        if (name.length() >= Boundaries.MIN_SPELLABILITY && name.length() <= Boundaries.MAX_SPELLABILITY) {
            return true;       
        }
        throw new IllegalArgumentException("The spell name: " + name + " is out of bounds.");
    }

}
