/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Fork;

/**
 *
 * @author Sander
 */
public class ForkValidator {

    private boolean isValid = false;
    private Fork fork = null;

    public ForkValidator(String id, String length, String tines, String material, String description) {
        isValid = validate(id, length, tines, material, description);
    }
    
    public ForkValidator(String length, String tines, String material, String description) {
        isValid = validate(length, tines, material, description);
    }

    public boolean isValid() {
        return isValid;
    }

    public Fork getFork() {
        return fork;
    }
    
    public boolean validate(String id, String length, String tines, String material, String description){
        String intMatch = "[0-9]+";
        String strMatch = "[a-zA-Z0-9!.?]+";
        if (!length.matches(intMatch) || !tines.matches(intMatch)) {
            fork = null;
            return false;
        } else if (!material.matches(strMatch) || !description.matches(description)) {
            fork = null;
            return false;
        } else {
            fork = new Fork(id, Integer.parseInt(length), Integer.parseInt(tines), material, description);
            return true;
        }
    }
    
    public boolean validate(String length, String tines, String material, String description){
        String intMatch = "[0-9]+";
        String strMatch = "[a-zA-Z0-9!.?]+";
        if (!length.matches(intMatch) || !tines.matches(intMatch)) {
            fork = null;
            return false;
        } else if (!material.matches(strMatch) || !description.matches(description)) {
            fork = null;
            return false;
        } else {
            fork = new Fork(Integer.parseInt(length), Integer.parseInt(tines), material, description);
            return true;
        }
    }
}
