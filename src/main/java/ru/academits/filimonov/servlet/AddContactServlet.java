package ru.academits.filimonov.servlet;

import ru.academits.filimonov.PhoneBook;
import ru.academits.filimonov.model.Contact;
import ru.academits.filimonov.service.ContactService;
import ru.academits.filimonov.service.ContactValidation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContactServlet extends HttpServlet {

    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");

            Contact contact = new Contact();

            contact.setFirstName(req.getParameter("firstName"));
            contact.setLastName(req.getParameter("lastName"));
            contact.setPhone(req.getParameter("phone"));

            ContactValidation contactValidation = phoneBookService.addContact(contact);
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
