package sj223gb_assign2.exercise1;

import java.util.ArrayList;

/**
* Class that sets and validates rules for Rogue as well as specific functionality.
* Could have had a MeleeCombatant facade or interface shared with Warrior to limit amount code.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Rogue extends Character {

    // For getting to know the basics of an arraylist. Could have potentially used a Set to avoid duplication.
    private ArrayList<Ability> knownAbilities = new ArrayList<Ability>();

    public Rogue(String charName, NPCClass className, int lvl, Attributes priAttr) {
        super(charName, className, lvl, priAttr);
        
    }

    public void learnAbility(Ability ability) {

        // Checks for duplicate abilities.
        if (!knownAbilities.contains(ability)) {

            // Validates the ability proficiency.
            if (validateClassProficiency(ability)) {
                knownAbilities.add(ability);
            }
        }
        else {
            throw new IllegalArgumentException("The ability: " + ability + " is already known.");
        }
    }

    public ArrayList<Ability> getKnownAbilities() {
        return knownAbilities;
    }

    /**
     * Checks that the ability is a valid proficiency for Rogues.
     * 
     * @param ability - The ability being validated.
     * @return - Boolean.
     */
    private boolean validateClassProficiency(Ability ability) {

        if (ability.getProficiency() == Proficiency.Acrobatics || ability.getProficiency() == Proficiency.Stealth) {
            return true;            
        }
        throw new IllegalArgumentException("The ability: " + ability + " does not belong to the " + getClassName() + " abilities.");
    }
    
}
