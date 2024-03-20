/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nadesshan
 */
public interface Observer {
    void update(String message, String name);
    void sendCommand(String value);
    void sendStrengthValue(int value);
}
