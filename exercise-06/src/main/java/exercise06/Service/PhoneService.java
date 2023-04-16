package exercise06.Service;

import exercise06.Entity.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhones();
    Phone createNewPhone(Phone phone);
    void updatePhoneById(int id, Phone phone);
}
