package furama_resorts.common.sort;

import furama_resorts.models.Customer;

import java.util.Comparator;

public class CustomerSortDof implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        int result=o1.getNameOfCustomer().compareTo(o2.getNameOfCustomer());
        if(result==0)
            return o1.getBirthdayToDate().compareTo(o2.getBirthdayToDate());
        return result;
    }
}
