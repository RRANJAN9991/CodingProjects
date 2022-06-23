/**
* @author Rahul Ranjan 
*    e-mail: rahul.ranjan@stonybrook.edu
*    Stony Brook ID:111448179
*    Recitation : 01 (Tuesday 9:30 - 11:45)
*/

/**
* A package containing all homework programs for CSE 214.
*/

package programs;

/**
* java.util.* was imported in order for this program to ask the user for input.
* java.io was imported in order for this class to implement Serializable and insert all the 
* data manipulated by the user into seperate files.
*/

import java.util.*;
import java.io.*;

/**
* This class allows the user to manipulate folders and the emails inside these folders.
* It also saves any data manipulated by the user.
* @author ranja
*/

public class MailboxDriver implements Serializable {

    /**
    * saveMailbox(Folder inbox, Folder trash, ArrayList<Folder> folders) is a method that saves all three parameters 
    * by creating three seperate files and saving each of them into their own file.
    * @param inbox
    * A Folder object that represents the inbox folder of this mailbox.
    * @param trash
    * A Folder object that represents the trash folder of this mailbox.
    * @param folders 
    * An ArrayList<Folder> that contains and represents all the folders created by the user.
    * PostCondition : All three parameters gets inserted into seperate files.
    */
    
    public static void saveMailbox(Folder inbox, Folder trash, ArrayList<Folder> folders) {
        try {
            FileOutputStream file = new FileOutputStream("inbox.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
            FileOutputStream file2 = new FileOutputStream("trash.obj");
            ObjectOutputStream fout2 = new ObjectOutputStream(file2);
            FileOutputStream file3 = new FileOutputStream("folders.obj");
            ObjectOutputStream fout3 = new ObjectOutputStream(file3);
            fout.writeObject(inbox); 
            fout2.writeObject(trash);
            fout3.writeObject(folders);
            file.close();
            file2.close();
            file3.close();
            fout.close();
            fout2.close();
            fout3.close();
        } 
        catch (IOException exp){
            System.out.println(exp.toString());
        }
    }
    
    /**
    * retriveInbox() is a method that gets the saved Folder inbox object from previous runs.
    * @return
    * A Folder object that represents the inbox folder of this mailbox.
    * @throws Exception 
    * Indicates that the program could not find a file where a Folder inbox object was saved.
    */
    
    public static Folder retrieveInbox() throws Exception{
        Folder inbox = new Folder();
        try {
            FileInputStream file = new FileInputStream("inbox.obj");
            ObjectInputStream fin  = new ObjectInputStream(file);
            inbox = (Folder) fin.readObject(); 
            System.out.println("Successfully loaded content of the inbox folder. ");
            file.close();
            fin.close();
        } 
        catch(IOException exp){
            System.out.println(exp.getMessage() + " Using a new inbox. ");
        }
        return inbox;
    }
    
    /**
    * retriveTrash() is a method that gets the saved Folder trash object from previous runs.
    * @return
    * A Folder object that represents the trash folder of this mailbox.
    * @throws Exception 
    * Indicates that the program could not find a file where a Folder trash object was saved.
    */
    
    public static Folder retrieveTrash() throws Exception{
        Folder trash = new Folder();
        try {
            FileInputStream file = new FileInputStream("trash.obj");
            ObjectInputStream fin  = new ObjectInputStream(file);
            trash = (Folder) fin.readObject(); 
            System.out.println("Successfully loaded content of the trash folder. ");
            file.close();
            fin.close();
        } 
        catch(IOException exp){
            System.out.println(exp.getMessage() + " Using a new trash folder. ");
        }
        return trash;
    }
    
    /**
    * retriveFolders() is a method that gets the saved ArrayList<Folder> folders from previous runs.
    * @return
    * An ArrayList<Folder> that contains and represents all the folders created by the user.
    * @throws Exception 
    * Indicates that the program could not find a file where an ArrayList<Folder> folders was saved.
    */
    
    public static ArrayList<Folder> retrieveFolders() throws Exception{
        ArrayList<Folder> folders = new ArrayList<Folder>();
        try {
            FileInputStream file = new FileInputStream("folders.obj");
            ObjectInputStream fin  = new ObjectInputStream(file);
            folders = (ArrayList<Folder>) fin.readObject(); 
            System.out.println("Successfully loaded content of all custom folders. ");
            file.close();
            fin.close();
        } 
        catch(IOException exp){
            System.out.println(exp.getMessage() + " No custom folders exist. ");
        }
        return folders;
    }
    
    public static void main(String [] arguments) {
        Mailbox.mailbox = new Mailbox();
        try {
            Folder inbox = new Folder();
            inbox = retrieveInbox();
            Mailbox.mailbox.setInbox(inbox);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            Folder trash = new Folder();
            trash = retrieveTrash();
            Mailbox.mailbox.setTrash(trash);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        try {
            ArrayList<Folder> folders = new ArrayList<Folder>();
            folders = retrieveFolders();
            Mailbox.mailbox.setFolders(folders);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
        Scanner input = new Scanner(System.in);
        String selection = "";
        while (!selection.equals("Q")) {
            System.out.println();
            System.out.println();
            System.out.println("Mailbox : ");
            System.out.println("Inbox");
            System.out.println("Trash");
            for (int i = 0; i < Mailbox.mailbox.getFolders().size(); i++) {
                System.out.println(Mailbox.mailbox.getFolders().get(i).getFolderName());
            }
            System.out.println();
            System.out.println();
            System.out.println("A – Add folder");

            System.out.println("R – Remove folder");

            System.out.println("C – Compose email");

            System.out.println("F – Open folder");

            System.out.println("I – Open Inbox");

            System.out.println("T – Open Trash");
            System.out.println("E - Empty Trash");

            System.out.println("Q – Quit");
            System.out.println();
            System.out.println("Select an option: ");
            selection = input.next();
            if (selection.equals("A")) {
                Folder newFolder = new Folder();
                System.out.println("Enter the name of the folder: ");
                String folderName = input.nextLine();
                folderName = input.nextLine();
                newFolder.setFolderName(folderName);
                Mailbox.mailbox.addFolder(newFolder);
            }
            else if (selection.equals("R")) {
                System.out.println("Enter the name of the folder: ");
                String folderName = input.nextLine();
                folderName = input.nextLine();
                Mailbox.mailbox.deleteFolder(folderName);
            }
            else if (selection.equals("C")) {
                Mailbox.mailbox.composeEmail();
            }
            else if (selection.equals("F")) {
                System.out.println("Enter the name of the folder: ");
                String folderName = input.nextLine();
                folderName = input.nextLine();
                Folder getFolder = new Folder();
                getFolder = Mailbox.mailbox.getFolder(folderName);
                String selection2 = "";
                while (!selection2.equals("R")) {
                    for (int i = 0; i < getFolder.getEmails().size(); i++) {
                    System.out.println("Position : " + i + "        Time : " + getFolder.getEmails().get(i).getTimeStamp().getTime() + "    "
                    + "            Subject : " + getFolder.getEmails().get(i).getSubject());
                    }
                    System.out.println("M – Move email");
                    System.out.println("D - Delete email");
                    System.out.println("V – View email contents");
                    System.out.println("SA - Sort by subject line in ascending order");
                    System.out.println("SD – Sort by subject line in descending order");
                    System.out.println("DA – Sort by date in ascending order");
                    System.out.println("DD – Sort by date in descending order");
                    System.out.println("R – Return to mailbox");
                    System.out.println("Select an option: ");
                    selection2 = input.next();
                    if (selection2.equals("M")) {
                        System.out.println("Enter the index of the email to move: ");
                        int index = input.nextInt();
                        Email removedEmail = new Email();
                        try {
                            removedEmail = getFolder.removeEmail(index);
                        }
                        catch (Exception exp) {
                            System.out.println(exp.getMessage());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Mailbox : ");
                        System.out.println("Inbox");
                        System.out.println("Trash");
                        for (int i = 0; i < Mailbox.mailbox.getFolders().size(); i++) {
                            System.out.println(Mailbox.mailbox.getFolders().get(i).getFolderName());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Enter the name of the folder where this email will be moved to: ");
                        String folderName2 = input.nextLine();
                        folderName2 = input.nextLine();
                        Folder moveFolder = new Folder();
                        moveFolder.setFolderName(folderName2);
                        Mailbox.mailbox.moveEmail(removedEmail, moveFolder);
                    }
                    else if (selection2.equals("D")) {
                        System.out.println("Enter the index of the email to delete: ");
                        int index = input.nextInt();
                        Email removedEmail = new Email();
                        try {
                            removedEmail = getFolder.removeEmail(index);
                        }
                        catch (Exception exp) {
                            System.out.println(exp.getMessage());
                        }
                        Mailbox.mailbox.deleteEmail(removedEmail);
                    }
                    else if (selection2.equals("V")) {
                        System.out.println("Enter the index of the email to view: ");
                        int index = input.nextInt();
                        System.out.println("To: " + getFolder.getEmails().get(index).getTo()); 
                        System.out.println("Cc: " + getFolder.getEmails().get(index).getCc());
                        System.out.println("Bcc" + getFolder.getEmails().get(index).getBcc());
                        System.out.println("Subject: " + getFolder.getEmails().get(index).getSubject());
                        System.out.println("Body: " + getFolder.getEmails().get(index).getBody());
                    }
                    else if (selection2.equals("SD")) {
                        getFolder.sortBySubjectDescending();
                    }
                    else if (selection2.equals("DA")) {
                        getFolder.sortByDateAscending();
                    }
                    else if (selection2.equals("DD")) {
                        getFolder.sortByDateDescending();
                    }
                    else if (selection2.equals("SA")) {
                        getFolder.sortBySubjectAscending();
                    }
                }
                System.out.println("Heading to Main Menu. ");
            }
            else if (selection.equals("I")) {
                String selection2 = "";
                while (!selection2.equals("R")) {
                    for (int i = 0; i < Mailbox.mailbox.inbox.getEmails().size(); i++) {
                    System.out.println("Position : " + i + "        Time : " + Mailbox.mailbox.inbox.getEmails().get(i).getTimeStamp().getTime() + "    "
                    + "            Subject : " + Mailbox.mailbox.inbox.getEmails().get(i).getSubject());
                    }
                    System.out.println("M – Move email");
                    System.out.println("D - Delete email");
                    System.out.println("V – View email contents");
                    System.out.println("SA - Sort by subject line in ascending order");
                    System.out.println("SD – Sort by subject line in descending order");
                    System.out.println("DA – Sort by date in ascending order");
                    System.out.println("DD – Sort by date in descending order");
                    System.out.println("R – Return to mailbox");
                    System.out.println("Select an option: ");
                    selection2 = input.next();
                    if (selection2.equals("M")) {
                        System.out.println("Enter the index of the email to move: ");
                        int index = input.nextInt();
                        Email removedEmail = new Email();
                        try {
                            removedEmail = Mailbox.mailbox.inbox.removeEmail(index);
                        }
                        catch (Exception exp) {
                            System.out.println(exp.getMessage());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Mailbox : ");
                        System.out.println("Inbox");
                        System.out.println("Trash");
                        for (int i = 0; i < Mailbox.mailbox.getFolders().size(); i++) {
                            System.out.println(Mailbox.mailbox.getFolders().get(i).getFolderName());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Enter the name of the folder where this email will be moved to: ");
                        String folderName2 = input.nextLine();
                        folderName2 = input.nextLine();
                        Folder moveFolder = new Folder();
                        moveFolder.setFolderName(folderName2);
                        Mailbox.mailbox.moveEmail(removedEmail, moveFolder);
                    }
                    else if (selection2.equals("D")) {
                        System.out.println("Enter the index of the email to delete: ");
                        int index = input.nextInt();
                        Email removedEmail = new Email();
                        try {
                            removedEmail = Mailbox.mailbox.inbox.removeEmail(index);
                        }
                        catch (Exception exp) {
                            System.out.println(exp.getMessage());
                        }
                        Mailbox.mailbox.deleteEmail(removedEmail);
                    }
                    else if (selection2.equals("V")) {
                        System.out.println("Enter the index of the email to view: ");
                        int index = input.nextInt();
                        System.out.println("To : " + Mailbox.mailbox.inbox.getEmails().get(index).getTo());
                        System.out.println("Cc: " + Mailbox.mailbox.inbox.getEmails().get(index).getCc());
                        System.out.println("Bcc" + Mailbox.mailbox.inbox.getEmails().get(index).getBcc());
                        System.out.println("Subject: " + Mailbox.mailbox.inbox.getEmails().get(index).getSubject());
                        System.out.println("Body: " + Mailbox.mailbox.inbox.getEmails().get(index).getBody());
                    }
                    else if (selection2.equals("SD")) {
                        Mailbox.mailbox.inbox.sortBySubjectDescending();
                    }
                    else if (selection2.equals("DA")) {
                        Mailbox.mailbox.inbox.sortByDateAscending();
                    }
                    else if (selection2.equals("DD")) {
                        Mailbox.mailbox.inbox.sortByDateDescending();
                    }
                    else if (selection2.equals("SA")) {
                        Mailbox.mailbox.inbox.sortBySubjectAscending();
                    }
                }
                System.out.println("Heading to Main Menu. ");
            }
            else if (selection.equals("T")) {
                String selection2 = "";
                while (!selection2.equals("R")) {
                    for (int i = 0; i < Mailbox.mailbox.trash.getEmails().size(); i++) {
                    System.out.println("Position : " + i + "        Time : " + Mailbox.mailbox.trash.getEmails().get(i).getTimeStamp().getTime() + "    "
                    + "            Subject : " + Mailbox.mailbox.trash.getEmails().get(i).getSubject());
                    }
                    System.out.println("M – Move email");
                    System.out.println("D - Delete email");
                    System.out.println("V – View email contents");
                    System.out.println("SA - Sort by subject line in ascending order");
                    System.out.println("SD – Sort by subject line in descending order");
                    System.out.println("DA – Sort by date in ascending order");
                    System.out.println("DD – Sort by date in descending order");
                    System.out.println("R – Return to mailbox");
                    System.out.println("Select an option: ");
                    selection2 = input.next();
                    if (selection2.equals("M")) {
                        System.out.println("Enter the index of the email to move: ");
                        int index = input.nextInt();
                        Email removedEmail = new Email();
                        try {
                            removedEmail = Mailbox.mailbox.trash.removeEmail(index);
                        }
                        catch (Exception exp) {
                            System.out.println(exp.getMessage());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Mailbox : ");
                        System.out.println("Inbox");
                        System.out.println("Trash");
                        for (int i = 0; i < Mailbox.mailbox.getFolders().size(); i++) {
                            System.out.println(Mailbox.mailbox.getFolders().get(i).getFolderName());
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Enter the name of the folder where this email will be moved to: ");
                        String folderName2 = input.nextLine();
                        folderName2 = input.nextLine();
                        Folder moveFolder = new Folder();
                        moveFolder.setFolderName(folderName2);
                        Mailbox.mailbox.moveEmail(removedEmail, moveFolder);
                    }
                    else if (selection2.equals("D")) {
                        System.out.println("Cannot delete single emails from trash folder. ");
                    }
                    else if (selection2.equals("V")) {
                        System.out.println("Enter the index of the email to view: ");
                        int index = input.nextInt();
                        System.out.println("To : " + Mailbox.mailbox.trash.getEmails().get(index).getTo());
                        System.out.println("Cc : " + Mailbox.mailbox.trash.getEmails().get(index).getCc());
                        System.out.println("Bcc : " + Mailbox.mailbox.trash.getEmails().get(index).getBcc());
                        System.out.println("Subject : " + Mailbox.mailbox.trash.getEmails().get(index).getSubject());
                        System.out.println("Body : " + Mailbox.mailbox.trash.getEmails().get(index).getBody());
                    }
                    else if (selection2.equals("SD")) {
                        Mailbox.mailbox.trash.sortBySubjectDescending();
                    }
                    else if (selection2.equals("DA")) {
                        Mailbox.mailbox.trash.sortByDateAscending();
                    }
                    else if (selection2.equals("DD")) {
                        Mailbox.mailbox.trash.sortByDateDescending();
                    }
                    else if (selection2.equals("SA")) {
                        Mailbox.mailbox.trash.sortBySubjectAscending();
                    }
                }
                System.out.println("Heading to Main Menu. ");
            }
            else if (selection.equals("E")) {
                Mailbox.mailbox.clearTrash();
            }
        }
        saveMailbox(Mailbox.mailbox.getInbox(), Mailbox.mailbox.getTrash(), Mailbox.mailbox.getFolders());
        System.out.println("HashedLibrary is saved into file library.obj. ");
        System.out.println("Terminating the program gracefully... ");
        
        }
}

