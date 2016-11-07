package Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andry on 04/11/2016.
 */
public class Mediator {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Alex");
        User u1 = new SimpleUser(chat, "Jim");
        User u2 = new SimpleUser(chat, "John");
        User u3 = new SimpleUser(chat, "Trinity");

        u2.setEnable(false);

        chat.setAdmin(admin);

        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        u1.sendMessage("hello");
        admin.sendMessage("hi");
    }
}

abstract class User{
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) { isEnable = enable; }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void sendMessage(String message){
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    @Override
    public String toString() {
        return super.toString();
    }
}

class Admin extends User{
    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void getMessage(String message) {
        System.out.println("Admin " + getName() + " gets " + "'" + message + "'");
    }
}

class SimpleUser extends User{
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void getMessage(String message) {
        System.out.println("User " + getName() + " gets " + "'" + message + "'");
    }
}

interface Chat{
    void sendMessage(String message, User user);
}

class TextChat implements Chat{

    User admin;
    List<User> users = new ArrayList<User>();

    public void setAdmin(User admin) {
        if(admin != null && admin instanceof Admin)
        {
            this.admin = admin;
        }else {
            throw new RuntimeException("not enough access");
        }
    }

    public void addUser(User user)
    {
        if(admin == null)
            throw new RuntimeException("no admin in the chat");

        if(user instanceof SimpleUser)
        {
            users.add(user);
        }
        else {
            throw new RuntimeException("Admin cannot be in other chat");
        }
    }


    @Override
    public void sendMessage(String message, User user) {
        if(user instanceof Admin)
        {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if(user instanceof SimpleUser){
            for (User u : users) {
              u.getMessage(user.getName() + ": " + message);
            }
            if(admin.isEnable)
                admin.getMessage(user.getName() + ": " + message);
        }
    }
}