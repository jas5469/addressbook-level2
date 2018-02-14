package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import java.util.*;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorted the address book in lexicographical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        addressBook.sortAddressBook();
        List<ReadOnlyPerson> allPersons= addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListSorted(allPersons), allPersons);
    }



}
