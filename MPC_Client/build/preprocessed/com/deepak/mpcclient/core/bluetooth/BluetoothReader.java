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

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author deepak
 */

/*
 * this class provides a bluetooth reader implimentation
 * to read continiously from the bluetooth stream
 * and populate the bluetooth message
 */
public class BluetoothReader implements Runnable {

    // the input stream object
    private DataInputStream dataInputStream = null;
    // bluetooth message refernce object
    private BluetoothMessage bluetoothMessage = null;
    // stop flag to control the reading process
    private boolean stop = false;

    /*
     * privatising the default constructor inorder to prevent usage
     */
    private BluetoothReader() {
    }

    /*
     * class constructor with input stream and bluetooth message as parameter
     */
    public BluetoothReader(DataInputStream dis, BluetoothMessage btmsg) {
        // set input stream
        dataInputStream = dis;
        // set bluetooth message refernce
        bluetoothMessage = btmsg;
    }

    /*
     * method to start reading message from the stream
     */
    public void startReading() {
        // set stop flag to false to indicate running
        stop = false;
        // create a thread object with the current class as the runnable parameter
        // and start it using the start method
        new Thread(this).start();
    }

    /*
     * method to stop the reading process
     */
    public void stopReading() {
        // set the stop flag to true
        stop = true;
    }

    /*
     * the run method implimentation of the runnable interface
     */
    public void run() {
        try {
            // while the inputstream is present and stop flag is false
            while (dataInputStream != null && !stop) {
                // read data from the stream and set it to the bluetooth message object
                bluetoothMessage.setMessage(dataInputStream.readUTF());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
