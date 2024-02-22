package addressBook;
import java.util.ArrayList;
import java.util.Scanner;


public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner takeContactDetails = new Scanner(System.in);

    public void addContact(){
        System.out.print("Enter the name of the contact: ");
        String name = takeContactDetails.nextLine();
        System.out.print("Enter the phone number of the contact: ");
        String phoneNumber = takeContactDetails.nextLine();
        System.out.print("Enter the email of the contact: ");
        String email = takeContactDetails.nextLine();
        Contact contact = new Contact(name, phoneNumber,email);
        contacts.add(contact);
        System.out.println("Contact added successfully");
    }

    public void viewContact(){
        if (contacts.isEmpty()) {

            System.out.println("The address book is empty");
        }else
        {
            for(Contact contact: contacts){
                System.out.println(contact);

            }
        }
    }

    public void editContact() {
        if (contacts.isEmpty()) {

            System.out.println("The address book is empty: there's nothing to edit");
        } else {
            System.out.print("Enter the name of the contact you want to edit: ");
            String searchName = takeContactDetails.nextLine();
            for (Contact contact : contacts) {
                if(contact.getName().equalsIgnoreCase(searchName)){
                    System.out.print("Enter a new phone number: ");
                    String newPhoneNumber = takeContactDetails.nextLine();
                    contact.setPhoneNumber(newPhoneNumber);
                    System.out.print("Enter a new email: ");
                    String newEmail = takeContactDetails.nextLine();
                    contact.setEmail(newEmail);
                }else{
                    System.out.println("This contact does not exist in the address book");
                }
            }
        }
    }

    public void deleteContact(){
        if (contacts.isEmpty()) {

            System.out.println("The address book is empty: there's nothing to delete");
        } else {
            System.out.print("Enter the name of the contact you want to edit: ");
            String searchName = takeContactDetails.nextLine();
            for (int i=0; i<contacts.size(); i++) {
                if(contacts.get(i).getName().equalsIgnoreCase(searchName)){
                    contacts.remove(i);
                    System.out.println("Contact successfully deleted.");
                    return;
                }else{
                    System.out.println("Contact not found!");
                }
            }
        }


    }

    public void displayMenu(){
        while(true){
            System.out.println("____Address book Menu____");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("What would you like to do: ");
            int userChoice = Integer.parseInt(takeContactDetails.nextLine());
            switch(userChoice){
                case 1 -> {
                    addContact();
                    break;
                }
                case 2 -> {
                    viewContact();
                    break;
                }
                case 3 -> {
                    editContact();
                    break;
                }
                case 4 ->{
                    deleteContact();
                    break;
                }
                case 5 ->{
                    System.out.println("Exiting the Address Book. Goodbye!");
                    takeContactDetails.close();
                    System.exit(0);
                }
                default ->  System.out.println("You have entered an invalid choice. Try again");

            }
        }
    }
    public static void main(String [] args){
        AddressBook addressBook = new AddressBook();
        addressBook.displayMenu();
    }
}
