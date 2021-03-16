package sendingMessage.sendMessage;

import sendingMessage.entity.Person;

public class MessageGenerator {
    Person person;
    String text;


    public MessageGenerator (Person person){

        this.person = person;
            }

    public String messageGenerator(){
        String date = person.getDate();
        String name = person.getName();
        String type = person.getType();

        if (type.equals("скайп")) {
            type = "в Skype. Наш id: live*********. ";
        } else type = "в офисе. Наш адрес: ул. Счастливая, дом 1, каб. 8. ";


        text = String.format("Добрый день, %s! Компания MyCompany напоминает о том, что у вас назначено интервью %s Дата встречи: %s. Сообщите пожалуйста, планы не изменились, ждём вас?", name, type, date);
        System.out.println(text);
        //String encodedText = Base64.getUrlEncoder().encodeToString(text.getBytes());
        String encodedText = text.replace(" " ,"%20");
        System.out.println(encodedText);

        return encodedText;
    }
}
