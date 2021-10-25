package ru.academits.filimonov.servlet;

import ru.academits.filimonov.PhoneBook;
import ru.academits.filimonov.converter.ContactConverter;
import ru.academits.filimonov.converter.ContactValidationConverter;
import ru.academits.filimonov.model.Contact;
import ru.academits.filimonov.service.ContactService;
import ru.academits.filimonov.service.ContactValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

public class AddContactServlet extends HttpServlet {

    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;
    private ContactValidationConverter contactValidationConverter = PhoneBook.contactValidationConverter;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Contact contact = new Contact();

            contact.setFirstName(req.getParameter("firstName"));
            contact.setLastName(req.getParameter("lastName"));
            contact.setPhone(req.getParameter("phone"));

            ContactValidation contactValidation = phoneBookService.addContact(contact);
            String contactValidationJson = contactValidationConverter.convertToJson(contactValidation);
            if (!contactValidation.isValid()) {
                resp.setStatus(500);
            }

            resp.sendRedirect("/phonebook/get/all");
        } catch (Exception e) {
            System.out.println("error in GetAllContactsServlet GET: ");
            e.printStackTrace();
        }
    }
}
