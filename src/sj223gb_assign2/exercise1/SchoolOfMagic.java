package sj223gb_assign2.exercise1;

/**
* Enum that sets school of magics and a few rules for validity.
*
* @version 1.1 22 September 2021
* @author Sebastian Jonsson
*/
public enum SchoolOfMagic {
    Restoration,
    Divination,
    Evocation,
    Alteration;

    /**
     * Validates school to be an existing school of magic.
     * 
     * @param className - Generic class.
     * @return - Boolean.
     */
    public static boolean isValid(SchoolOfMagic school) {
        
        for (SchoolOfMagic s : SchoolOfMagic.values()) {
    
            if (s.equals(school)) {
                return true;
            }
        }
        return false;
    }
}
