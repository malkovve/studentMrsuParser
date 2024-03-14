package comparator;

import parseInfo.Address;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressComparator {

    public AddressComparator() {
    }

    public Set<Address> AddressComparator(List<Address> list) {
        Set<Address> uniqueElements = new HashSet<>();
        Set<Address> duplicates = new HashSet<>();

        for (Address data : list) {
            if (!uniqueElements.add(data)) {
                duplicates.add(data);
            }
        }
        return duplicates;
    }
}
