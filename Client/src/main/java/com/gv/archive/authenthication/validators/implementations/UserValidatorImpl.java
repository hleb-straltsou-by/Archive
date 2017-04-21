package com.gv.archive.authenthication.validators.implementations;

import com.gv.archive.authenthication.validators.interfaces.UserValidator;
import com.gv.archive.communication.implementations.BasicRequest;
import com.gv.archive.communication.implementations.SocketCommunicationService;
import com.gv.archive.communication.interfaces.CommunicationService;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.converters.implementations.XStreamXMLUserConverter;
import com.gv.archive.converters.interfaces.XMLUserConverter;
import com.gv.archive.cryptography.implementations.CryptographerShift;
import com.gv.archive.cryptography.interfaces.Cryptographer;
import com.gv.archive.models.User;

public class UserValidatorImpl implements UserValidator{

    private CommunicationService service = new SocketCommunicationService();

    private XMLUserConverter converter = new XStreamXMLUserConverter();

    private Cryptographer cryptographer = new CryptographerShift();

    private final static String PARSER_TYPE = "DOM";

    @Override
    public User checkUser(String login, String password) {
        Request request = new BasicRequest(login + " " + cryptographer.encrypt(password), PARSER_TYPE);
        Response response = service.doLogin(request);
        User user = null;
        if(!response.getResponseBody().equals("failed")){
            user = converter.convertXMLStringToUserObject(response.getResponseBody());
        }
        return user;
    }
}
