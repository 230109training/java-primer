package com.revature;

public class interfaces {

    /*
    Interfaces are contracts that declare what something will do
    For example, you have a smart home speaker and the speaker itself just plays music
    In order for it to play the music, there needs to be a set of commands that physically start
    the songs and stop the songs.
    An interface is the abstraction of these commands. This can be listed out as a contract that anyone
    could have access to, in order to understand the contract that the smart home speaker is using.

    With this contract, we can design other programs that use the interface methods.

     */

    /*
    Interfaces can have abstract, default, or static methods
        - abstract methods are followed by a semicolon and no {} as there is no implementation so no
        method body is needed
        - default methods have the default modifier
        - static methods have the static modifier
     */


}


interface OperateSpeaker {
    // Constants
    String SPEAKER_VERSION = "2.6";

    // Method Signatures
    // There is no body for the methods, and they are terminated with a ;
    int play(String songName);

    int pause();
}

class Speaker implements OperateSpeaker{

    @Override
    public int play(String songName) {
        System.out.println(songName + " is playing!");
        return 1;
    }

    @Override
    public int pause() {
        return 0;
    }
}
