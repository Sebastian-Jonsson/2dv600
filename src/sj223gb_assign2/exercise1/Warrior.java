package sj223gb_assign2.exercise1;

import java.util.ArrayList;

/**
* Class that sets and validates rules for Warrior as well as specific functionality.
* Could have had a MeleeCombatant facade or interface shared with Rogue to limit amount code.
*
* @version 1.1 21 September 2021
* @author Sebastian Jonsson
*/
public class Warrior extends Character {

    // For getting to know the basics of an arraylist. Could have potentially used a Set to avoid duplication.
    private ArrayList<Ability> knownAbilities = new ArrayList<Ability>();

    public Warrior(String charName, NPCClass className, int lvl, Attributes priAttr) {
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
     * Checks that the ability is a valid proficiency for Warriors.
     * 
     * @param ability - The ability being validated.
     * @return - Boolean.
     */
    private boolean validateClassProficiency(Ability ability) {

        if (ability.getProficiency() == Proficiency.Athletics || ability.getProficiency() == Proficiency.Survival) {
            return true;            
        }
        throw new IllegalArgumentException("The ability: " + ability + " does not belong to the " + getClassName() + " abilities.");
    }
    
}
