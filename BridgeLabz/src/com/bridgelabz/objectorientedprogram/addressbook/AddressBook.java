package com.bridgelabz.objectorientedprogram.addressbook;

import java.io.IOException;

public interface AddressBook {
public void openAddressBook();
public void createAddressBook() throws IOException;
public void addPerson();
public void editPerson();
public void deletePerson();
public void sortByName();
public void sortByZip();
public void saveAddressBook();
public void saveAsAddressBook();
public boolean quitProgram();

}
