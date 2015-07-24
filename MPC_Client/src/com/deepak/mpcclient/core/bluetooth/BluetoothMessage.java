/*
This file is part of MPC_Client v0.1

MPC_Client is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

MPC_Client is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with MPC_Client.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.deepak.mpcclient.core.bluetooth;

import java.util.Vector;

/**
 *
 * @author deepak
 */

/*
 * this class impliments the bluetooth message
 * here since we donot have property change listners
 * we are implimenting a message stack where
 * all recieved messages are saved
 */
public class BluetoothMessage {

    // the message stack
    private Vector messageStack;
    // a single message object
    private Object lastMessage;

    // default class constructor
    public BluetoothMessage() {
        // create the message stack
        messageStack = new Vector();
    }

    /*
     * method to pop messages( retrive the message and then delete it from the stack)
     */
    public Object popMessage() {
        // if the message stack is not empty
        if (messageStack.size() > 0) {
            // get the first message
            // set it to the single message object
            lastMessage = messageStack.elementAt(0);
            // delete the message from the stack
            messageStack.removeElementAt(0);
            // return the retrived message
            return lastMessage;
        }
        // else if the message stack is empty then return null
        else {
            return null;
        }
    }

    /*
     * method to get the whole message stack
     */
    public Vector getMessage() {
        return messageStack;
    }

    /*
     * method to set a new message onto the message stack
     * similar to push operation
     */
    public void setMessage(String msg) {
        // push the message onto the message stack
        messageStack.addElement(msg);
    }
}
