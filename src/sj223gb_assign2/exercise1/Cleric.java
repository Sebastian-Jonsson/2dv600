package sj223gb_assign2.exercise1;

import java.util.ArrayList;

/**
* Class that sets and validates rules for Cleric as well as specific functionality.
* Could have had a Spellcaster facade or interface shared with Mage to limit amount code.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Cleric extends Character {

    // For getting to know the basics of an arraylist. Could have potentially used a Set to avoid duplication.
    private ArrayList<Spell> spellBook = new ArrayList<Spell>();

    public Cleric(String charName, NPCClass className, int lvl, Attributes attr) {
        super(charName, className, lvl, attr);
        
    }
    
    public void learnSpell(Spell spell) {

        // Checks for duplicate spells.
        if (!spellBook.contains(spell)) {

            // Validates the spell school.
            if (validateClassSchools(spell)) {
                spellBook.add(spell);
            }
        }
        else {
            throw new IllegalArgumentException("The spell: " + spell + " is already known.");
        }
    }

    public ArrayList<Spell> getKnownSpells() {
        return spellBook;
    }

    /**
     * Checks that the spell is a valid school of magic for Clerics.
     * 
     * @param spell - The spell being validated.
     * @return - Boolean.
     */
    private boolean validateClassSchools(Spell spell) {

        if (spell.getSchool() == SchoolOfMagic.Divination || spell.getSchool() == SchoolOfMagic.Restoration) {
            return true;            
        }
        throw new IllegalArgumentException("The spell: " + spell + " does not belong to the " + getClassName() + " schools.");
    }
}
