package com.example.telephoneDir_INET2005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public List<TeleRecord> getAllItems() {
//        List<TeleRecord> teleRecords = new ArrayList<>();
//        userRepository.findAll().forEach(teleRecords::add);
//        return teleRecords;
//    }

    public List<TeleRecord> getAllItems() {
        return (List<TeleRecord>) userRepository.findAll();
    }

    public Optional<TeleRecord> getItem(Integer id) {
        return userRepository.findById(id);
    }

    public void addItem(TeleRecord teleRecord) {
        userRepository.save(teleRecord);
    }

    public Optional<TeleRecord> setItemById(Integer id, String phone, String name) {

        Optional<TeleRecord> data = getItem(id);
        TeleRecord teleRecord = data.get();

        if (data.isPresent()) {
            teleRecord.setPhone(phone);
            teleRecord.setName(name);

            userRepository.save(teleRecord);

            return data;
        }
        System.err.println("PUT did not work");
        return null;
    }

    public void deleteItem(Integer id) {
        userRepository.deleteById(id);
    }

    public List<TeleRecord> deleteAllItem() {
        userRepository.deleteAll();
        return null;
    }


}
