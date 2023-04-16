package exercise06.Service.ServiceImpl;

import exercise06.Entity.Phone;
import exercise06.Repository.PhoneRepository;
import exercise06.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone createNewPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void updatePhoneById(int id, Phone phone) {
        phoneRepository.findById(id).orElseThrow(() -> {
            throw new Error("Not found phone has id: " + id);
        });
        phoneRepository.updateById(id, phone.getName(), phone.getStudent().getId());
    }
}
