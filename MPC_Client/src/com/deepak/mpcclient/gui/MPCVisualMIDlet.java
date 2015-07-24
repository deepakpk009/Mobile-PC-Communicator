/*-----------------------------------
MPC Clinet v0.1
-------------------------------------
Mobile PC Communicator (client Module)
-------------------------------------
Developed By : deepak pk
Email : deepakpk009@yahoo.in
-------------------------------------
This Project is Licensed under LGPL
-------------------------------------

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.deepak.mpcclient.gui;

import com.deepak.mpcclient.core.bluetooth.BluetoothCommunicator;
import com.deepak.mpcclient.core.bluetooth.BluetoothDeviceDB;
import com.deepak.mpcclient.core.bluetooth.BluetoothMessage;
import com.deepak.mpcclient.core.bluetooth.BluetoothReader;
import com.deepak.mpcclient.core.bluetooth.BluetoothUI;
import java.io.IOException;
import java.util.Vector;
import javax.bluetooth.UUID;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStoreException;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author deepak
 */

/*
 * this midlet class provides the UI part for the mobile client
 * since this class uses the bluetooth communicator for conection
 * it impliments the bluetoothUI interface
 */
public class MPCVisualMIDlet extends MIDlet implements CommandListener, BluetoothUI {
    // the bluetooth communicator object

    private BluetoothCommunicator bluetoothCommunicator = null;
    // the bluetooth message object
    private BluetoothMessage bluetoothMessage = null;
    // the bluetooth reader object
    private BluetoothReader bluetoothReader = null;
    // the server service universal unique ID - used for searching for the server
    private UUID uuid = new UUID("27012f0c68af4fbf8dbe6bbaf7aa432a", false);
    private boolean midletPaused = false;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private SplashScreen splashScreen;
    private TextBox inputTextBox;
    private List serverList;
    private TextBox recievedMessageTextBox;
    private Command okCommand;
    private Command exitCommand;
    private Command backCommand;
    private Command recievedMessage;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MPCVisualMIDlet constructor.
     */
    public MPCVisualMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        //----------------------------------------------------------------------
        // initialise the bluetooth communicator object
        // providing the current class refernce as the constructor argument
        bluetoothCommunicator = new BluetoothCommunicator(this);
        //----------------------------------------------------------------------
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == inputTextBox) {//GEN-BEGIN:|7-commandAction|1|33-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|33-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|2|33-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|31-preAction
                // when the user presses the ok command
                // send the data present in the text box using the bluetooth communicator
                // and then clear the text box
                try {
                    bluetoothCommunicator.SendData(inputTextBox.getString());
                    inputTextBox.delete(0, inputTextBox.size());
                } catch (Exception ex) {
                }
//GEN-LINE:|7-commandAction|4|31-postAction
                // write post-action user code here
            } else if (command == recievedMessage) {//GEN-LINE:|7-commandAction|5|45-preAction
                // write pre-action user code here
                switchDisplayable(null, getRecievedMessageTextBox());//GEN-LINE:|7-commandAction|6|45-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|47-preAction
        } else if (displayable == recievedMessageTextBox) {
            if (command == backCommand) {//GEN-END:|7-commandAction|7|47-preAction
                // write pre-action user code here
                switchDisplayable(null, getInputTextBox());//GEN-LINE:|7-commandAction|8|47-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|36-preAction
        } else if (displayable == serverList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|9|36-preAction
                // write pre-action user code here
                serverListAction();//GEN-LINE:|7-commandAction|10|36-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|21-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|11|21-preAction
                // write pre-action user code here
                switchDisplayable(null, getServerList());//GEN-LINE:|7-commandAction|12|21-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|7-postCommandAction
        }//GEN-END:|7-commandAction|13|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|14|
    //</editor-fold>//GEN-END:|7-commandAction|14|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|20-getter|1|20-postInit
            splashScreen.setTitle("splashScreen");
            splashScreen.setCommandListener(this);
            splashScreen.setFullScreenMode(true);
            splashScreen.setText("Mobile PC Communicator");//GEN-END:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|20-getter|2|
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: inputTextBox ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of inputTextBox component.
     * @return the initialized component instance
     */
    public TextBox getInputTextBox() {
        if (inputTextBox == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            inputTextBox = new TextBox("Input Text Box", null, 100, TextField.ANY);//GEN-BEGIN:|28-getter|1|28-postInit
            inputTextBox.addCommand(getOkCommand());
            inputTextBox.addCommand(getExitCommand());
            inputTextBox.addCommand(getRecievedMessage());
            inputTextBox.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return inputTextBox;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: serverList ">//GEN-BEGIN:|35-getter|0|35-preInit
    /**
     * Returns an initiliazed instance of serverList component.
     * @return the initialized component instance
     */
    public List getServerList() {
        if (serverList == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
            serverList = new List("Server List", Choice.IMPLICIT);//GEN-BEGIN:|35-getter|1|35-postInit
            serverList.append("Search and Connect", null);
            serverList.append("Last Used", null);
            serverList.setCommandListener(this);
            serverList.setSelectedFlags(new boolean[] { false, false });//GEN-END:|35-getter|1|35-postInit
            // write post-init user code here
        }//GEN-BEGIN:|35-getter|2|
        return serverList;
    }
    //</editor-fold>//GEN-END:|35-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: serverListAction ">//GEN-BEGIN:|35-action|0|35-preAction
    /**
     * Performs an action assigned to the selected list element in the serverList component.
     */
    public void serverListAction() {//GEN-END:|35-action|0|35-preAction
        // enter pre-action user code here
        String __selectedString = getServerList().getString(getServerList().getSelectedIndex());//GEN-BEGIN:|35-action|1|38-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Search and Connect")) {//GEN-END:|35-action|1|38-preAction
                // if the user selects the search and connect option
                // use the bluetooth communicator to connect to the server
                // with service uuid as specified
                try {
                    bluetoothCommunicator.connetToServerWithServiceID(uuid);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                /*
switchDisplayable (null, getInputTextBox ());//GEN-LINE:|35-action|2|38-postAction
                 */
                // write post-action user code here
            } else if (__selectedString.equals("Last Used")) {//GEN-LINE:|35-action|3|39-preAction
                // if the user selects the last used server for connection
                try {
                    // get the last used server url from the bluetooth device database
                    String url = new BluetoothDeviceDB().getStoredDeviceURL();
                    // if url is present
                    if (url != null) {
                        // connecto the the server with the url
                        bluetoothCommunicator.connetToServerWithURL(url);
                    } else {
                        // else if no url is present then display alert informing no last servers found
                        // and return to the server selection list
                        switchDisplayable(new Alert("No Last Used Server Found!!!"), getServerList());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // write pre-action user code here
                /*
switchDisplayable (null, getInputTextBox ());//GEN-LINE:|35-action|4|39-postAction
                 */
                // write post-action user code here
            }//GEN-BEGIN:|35-action|5|35-postAction
        }//GEN-END:|35-action|5|35-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|35-action|6|
    //</editor-fold>//GEN-END:|35-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: recievedMessageTextBox ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of recievedMessageTextBox component.
     * @return the initialized component instance
     */
    public TextBox getRecievedMessageTextBox() {
        if (recievedMessageTextBox == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            recievedMessageTextBox = new TextBox("Recieved Message Text Box", null, 100, TextField.ANY);//GEN-BEGIN:|43-getter|1|43-postInit
            recievedMessageTextBox.addCommand(getBackCommand());
            recievedMessageTextBox.setCommandListener(this);//GEN-END:|43-getter|1|43-postInit
            // if the bluetooth message is present
            if (bluetoothMessage != null) {
                // get all recieved messages
                Vector messages = bluetoothMessage.getMessage();
                // add all message content to the recieved message text box
                for (int i = 0; i < messages.size(); i++) {
                    recievedMessageTextBox.insert((String) messages.elementAt(i), recievedMessageTextBox.getCaretPosition());
                }
            }
        }//GEN-BEGIN:|43-getter|2|
        return recievedMessageTextBox;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: recievedMessage ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of recievedMessage component.
     * @return the initialized component instance
     */
    public Command getRecievedMessage() {
        if (recievedMessage == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            recievedMessage = new Command("Recieved Messages", Command.ITEM, 0);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return recievedMessage;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
        // save the current url to the bluetooth database
        try {
            new BluetoothDeviceDB().saveDeviceURL(bluetoothCommunicator.getServerURL());
            // if blutooth reader is present then stop it
            if (bluetoothReader != null) {
                bluetoothReader.stopReading();
            }
            // if bluetooth communicator is present then dissconnect it
            if (bluetoothCommunicator != null && bluetoothCommunicator.isConnected()) {
                bluetoothCommunicator.disconnect();
            }
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * the connection established method implimentation of the bluetoothUI interface
     */
    public void connectionEstablished() {
        // create a bluetooth message
        bluetoothMessage = new BluetoothMessage();
        // create a bluetooth reader using the bluetooth input stream and message as arguments
        bluetoothReader = new BluetoothReader(bluetoothCommunicator.getDataInputStream(), bluetoothMessage);
        // start reading the messages
        bluetoothReader.startReading();
        // goto the input text box screen
        switchDisplayable(null, getInputTextBox());
    }
}
