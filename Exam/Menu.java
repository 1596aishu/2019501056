/**************************************************************
 * 
 * Note: Please don't update this Menu.java until unless there is 
 * an instruction from your mentor.
 * 
 * To compile this file :   javac Menu.java
 * To run this file     :   java -ea Menu
 * Dependencies         :   SocialNetworkInterface.java
 *                          User.java
 *                          SocialNetwork.java 
 * 
 **************************************************************/

/**
 * The Menu class is used for unit testing of SocialNetwork.
 * Please don't update this Menu.java
 * 
 * @author Siva Sankar
 */

import java.io.*;
import java.util.*;

public class Menu {
    /**
     * The main method used for unit testing of your social network.
     * @param args the command line arguments.
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Network.txt"));
        StringBuffer sb = new StringBuffer();
        while(scan.hasNext()) {
            sb.append(scan.nextLine() + ";");
        }
        String s = sb.toString();
        s = s.substring(0, sb.length()-1);
        int count = 0;

        ////////////////////////////////////////////////////////
        ///                    Part - 1                      ///
        ////////////////////////////////////////////////////////


        //  Testcase 1:
        SocialNetwork network = new SocialNetwork();
        network.createDataStructure(s);
        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]".equals(network.toString())) {
            System.out.println("Testcase 1 passed");
            count++;
        } else {
            System.out.println("Testcase 1 failed");
        }

        //  Testcase 2:
        User userA = network.getUser("Mercedes");
        User userB = network.getUser("John");
        if (userA != null && userB != null) {
            network.addConnection(userA, userB);
        }
        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant, John]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]".equals(network.toString())) {
            System.out.println("Testcase 2 passed");
            count++;
        } else {
            System.out.println("Testcase 2 failed");
        }


        //  Testcase 3:
        User[] users = network.getConnections(network.getUser("Olive"));
        if("[John,Ollie]".equals(getString(users))) {
            System.out.println("Testcase 3 passed");
            count++;
        } else {
            System.out.println("Testcase 3 failed");
        }


        //  Testcase 4:
        users = network.getCommonConnections(userA, userB);
        if("[Walter,Bryant]".equals(getString(users))) {
            System.out.println("Testcase 4 passed");
            count++;
        } else {
            System.out.println("Testcase 4 failed");
        }


        //  Testcase 5:
        network.addUser(new User("Randy", null));
        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant, John]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]\nRandy : ".equals(network.toString())) {
            System.out.println("Testcase 5 passed");
            count++;
        } else {
            System.out.println("Testcase 5 failed");
        }


        //  Testcase 6:
        network.addUser(new User("Randy", null));
        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant, John]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]\nRandy : ".equals(network.toString())) {
            System.out.println("Testcase 6 passed");
            count++;
        } else {
            System.out.println("Testcase 6 failed");
        }

        
        //  Testcase 7:
        userA = network.getUser("Randy");
        network.addConnection(userA, network.getUser("John"));
        network.addConnection(userA, network.getUser("Olive"));
        network.addConnection(userA, network.getUser("Ollie"));
        network.addConnection(userA, network.getUser("Debra"));

        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant, John]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]\nRandy : [John, Olive, Ollie, Debra]".equals(network.toString())) {
            System.out.println("Testcase 7 passed");
            count++;
        } else {
            System.out.println("Testcase 7 failed");
        }


        //  Testcase 8:
        network.addUser(new User("John", null));
        if("John : [Bryant, Debra, Walter]\nBryant : [Olive, Ollie, Freda, Mercedes]\nDebra : [Walter, Levi, Jennie, Robin]\nWalter : [John, Levi, Bryant]\nOlive : [John, Ollie]\nOllie : [Mercedes, Freda, Bryant]\nFreda : [Olive, John, Debra]\nMercedes : [Walter, Robin, Bryant, John]\nRobin : [Ollie]\nLevi : [Ollie, John, Walter]\nJennie : [Levi, John, Freda, Robin]\nRandy : [John, Olive, Ollie, Debra]".equals(network.toString())) {
            System.out.println("Testcase 8 passed");
            count++;
        } else {
            System.out.println("Testcase 8 failed");
        }


        //  Testcase 9:
        users = network.getConnections(network.getUser("John"));
        if("[Bryant,Debra,Walter]".equals(getString(users))) {
            System.out.println("Testcase 9 passed");
            count++;
        } else {
            System.out.println("Testcase 9 failed");
        }


        //  Testcase 10:
        users = network.getConnections(network.getUser("John"));
        if("[Bryant,Debra,Walter]".equals(getString(users))) {
            System.out.println("Testcase 10 passed");
            count++;
        } else {
            System.out.println("Testcase 10 failed");
        }


        ////////////////////////////////////////////////////////
        ///                    Part - 2                      ///
        ////////////////////////////////////////////////////////

        //  Testcase 11:
        network = new SocialNetwork();
        network.createDataStructure("");
        if("".equals(network.toString())) {
            System.out.println("Testcase 11 passed");
            count++;
        } else {
            System.out.println("Testcase 11 failed");
        }


        //  Testcase 12:
        network.getConnections(network.getUser("John"));
        if("".equals(network.toString())) {
            System.out.println("Testcase 12 passed");
            count++;
        } else {
            System.out.println("Testcase 12 failed");
        }


        //  Testcase 13
        users = network.getCommonConnections(
                network.getUser("Randy"), network.getUser("John"));
        if("[]".equals(getString(users))) {
            System.out.println("Testcase 13 passed");
            count++;
        } else {
            System.out.println("Testcase 13 failed");
        }


        //  Testcase 14
        network.addConnection(
                network.getUser("Randy"), network.getUser("John"));
        if("".equals(network.toString())) {
            System.out.println("Testcase 14 passed");
            count++;
        } else {
            System.out.println("Testcase 14 failed");
        }


        //  Testcase 15:
        network.addUser(new User("Randy", null));
        if("Randy : ".equals(network.toString())) {
            System.out.println("Testcase 15 passed");
            count++;
        } else {
            System.out.println("Testcase 15 failed");
        }

        
        //  Testcase 16:
        userA = network.getUser("Randy");
        network.addConnection(userA, network.getUser("John"));
        network.addConnection(userA, network.getUser("Olive"));
        network.addConnection(userA, network.getUser("Ollie"));
        network.addConnection(userA, network.getUser("Debra"));
        if("Randy : ".equals(network.toString())) {
            System.out.println("Testcase 16 passed");
            count++;
        } else {
            System.out.println("Testcase 16 failed");
        }


        //  Testcase 17:
        network.addUser(new User("John", null));
        if("Randy : \nJohn : ".equals(network.toString())) {
            System.out.println("Testcase 17 passed");
            count++;
        } else {
            System.out.println("Testcase 17 failed");
        }


        //  Testcase 18:
        userA = network.getUser("Randy");
        network.addConnection(userA, network.getUser("John"));
        if("Randy : [John]\nJohn : ".equals(network.toString())) {
            System.out.println("Testcase 18 passed");
            count++;
        } else {
            System.out.println("Testcase 18 failed");
        }


        //  Testcase 19:
        users = network.getConnections(network.getUser("John"));
        if("[]".equals(getString(users))) {
            System.out.println("Testcase 19 passed");
            count++;
        } else {
            System.out.println("Testcase 19 failed");
        }


        //  Testcase 20:
        users = network.getCommonConnections(
                network.getUser("Randy"), network.getUser("John"));
        if("[]".equals(getString(users))) {
            System.out.println("Testcase 20 passed");
            count++;
        } else {
            System.out.println("Testcase 20 failed");
        }


        //  Testcase 21:
        network.addUser(new User("Debra", null));
        userA = network.getUser("Debra");
        network.addConnection(userA, network.getUser("John"));
        if("Randy : [John]\nJohn : \nDebra : [John]".equals(network.toString())) {
            System.out.println("Testcase 21 passed");
            count++;
        } else {
            System.out.println("Testcase 21 failed");
        }


        //  Testcase 22:
        users = network.getCommonConnections(
                network.getUser("Randy"), network.getUser("John"));
        if("[]".equals(getString(users))) {
            System.out.println("Testcase 22 passed");
            count++;
        } else {
            System.out.println("Testcase 22 failed");
        }


        //  Testcase 23:
        users = network.getCommonConnections(
                network.getUser("Randy"), network.getUser("Debra"));
        if("[John]".equals(getString(users))) {
            System.out.println("Testcase 23 passed");
            count++;
        } else {
            System.out.println("Testcase 23 failed");
        }

        //  Testcase 24:
        scan = new Scanner(new File("SN.txt"));
        sb = new StringBuffer();
        while(scan.hasNext()) {
            sb.append(scan.nextLine() + ";");
        }
        s = sb.toString();
        s = s.substring(0, sb.length()-1);
        network = new SocialNetwork();
        network.createDataStructure(s);
        
        //  Testcase 24
        if ("John : [Bryant, Debra, Walter]\nBryant : \nDebra : \nWalter : \nMercedes : [Walter, Robin, Bryant]\nRobin : ".equals(network.toString())) {
            System.out.println("Testcase 24 passed");
            count++;
        } else {
            System.out.println("Testcase 24 failed");
        }

        //  Testcase 25
        users = network.getCommonConnections(
                network.getUser("Randy"), network.getUser("Debra"));
        if("[]".equals(getString(users))) {
            System.out.println("Testcase 25 passed");
            count++;
        } else {
            System.out.println("Testcase 25 failed");
        }

        if (count == 25) {
            System.out.println();
            System.out.println("***************************************");
            System.out.println("Congratulations!!! All Testcases passed");
            System.out.println("***************************************");
            System.out.println();
        }
    }

    /**
     * This method returns the String verions of all the usres
     * that contains only the userNames.
     * @param users to be used to return only the userNames.
     * @return the userNames of all the users.
     */
    public static String getString(User[] users) {
        if (users == null) {
            return "[]";
        }
        String str = "[";
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null) {
                str = str + users[i].getUserName() + ",";
            }
        }
        str = str.substring(0, str.length()-1) + "]";
        return str;
    }
}