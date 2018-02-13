package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorted the address book in lexicographical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListSorted(allPersons), allPersons);
    }

    /**
     * Sort the list in lexicographical order using names
     *
     *
     * @return list of supported persons
     */
    private List<ReadOnlyPerson> sortPersonLists (List<ReadOnlyPerson> unsortedList){
        List<ReadOnlyPerson> sortedListOfPersons = new ArrayList<ReadOnlyPerson>(unsortedList);
        Collections.sort(sortedListOfPersons, new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2) {
                return (person1.getName().toString()).compareTo(person2.getName().toString());
            }
        });
        return sortedListOfPersons;
    }

}
