package ru.academits.filimonov;

import ru.academits.filimonov.converter.ContactConverter;
import ru.academits.filimonov.converter.ContactValidationConverter;
import ru.academits.filimonov.dao.ContactDao;
import ru.academits.filimonov.service.ContactService;

public class PhoneBook {
    public static ContactDao contactDao = new ContactDao();

    public static ContactService phoneBookService = new ContactService();

    public static ContactConverter contactConverter = new ContactConverter();

    public static ContactValidationConverter contactValidationConverter = new ContactValidationConverter();
}
