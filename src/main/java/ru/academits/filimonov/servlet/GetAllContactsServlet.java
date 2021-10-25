package ru.academits.filimonov.servlet;

import ru.academits.filimonov.PhoneBook;
import ru.academits.filimonov.converter.ContactConverter;
import ru.academits.filimonov.model.Contact;
import ru.academits.filimonov.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllContactsServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Contact> contactList = phoneBookService.getAllContacts();

            req.setAttribute("contacts", contactList);

            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("error in GetAllContactsServlet GET: ");
            e.printStackTrace();
        }
    }
}
