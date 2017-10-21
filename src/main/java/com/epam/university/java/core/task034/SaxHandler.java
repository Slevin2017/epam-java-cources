package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Sax handler base.
 */
public abstract class SaxHandler extends DefaultHandler {
    private Collection<Person> persons;
    private Person person = null;
    boolean firstName = false;
    boolean lastName = false;
    boolean personPhone = false;

    public Collection<Person> getEmpList() {
        return persons;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            String id = attributes.getValue("id");
            person = new PersonImpl();
            person.setId(Integer.parseInt(id));
            if (persons == null) {
                persons = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("first-name")) {
            firstName = true;
        } else if (qName.equalsIgnoreCase("last-name")) {
            lastName = true;
        } else if (qName.equalsIgnoreCase("person-phone")) {
            personPhone = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            persons.add(person);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (firstName) {
            person.setFirstName(new String(ch,start,length));
            firstName = false;
        } else if (lastName) {
            person.setLastName(new String(ch,start,length));
            lastName = false;
        } else if (personPhone) {

        }
    }
}
