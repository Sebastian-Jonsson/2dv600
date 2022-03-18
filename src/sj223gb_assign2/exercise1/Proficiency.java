package sj223gb_assign2.exercise1;

/**
* Enum that sets proficiences and a few rules for validity.
*
* @version 1.1 22 September 2021
* @author Sebastian Jonsson
*/
public enum Proficiency {
    Athletics,
    Survival,
    Acrobatics,
    Stealth;

    /**
     * Validates proficiencies to be an existing proficiency.
     * 
     * @param prof - Generic proficiency.
     * @return - Boolean.
     */
    public static boolean isValid(Proficiency prof) {
        
        for (Proficiency s : Proficiency.values()) {
    
            if (s.equals(prof)) {
                return true;
            }
        }
        return false;
    }
}
