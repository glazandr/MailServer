import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

// для построения связки получателя и текста письма будем используовать класс HashMap
public class MailService<T> extends HashMap implements Consumer<MailMessage> {
    @Override
    // переназначим метод accept из встроенного функционального интерфейса Consumer
    public void accept(MailMessage mailMessage) {
        List list = this.getMailBox().get(mailMessage.getTo());
        if (list == null) {
            list = new LinkedList<>();
            this.getMailBox().put(mailMessage.getTo(), list);
        }
        list.add(mailMessage.<T>getValue());
    }

    // реализуем интерфейс Map где по ключу (имя получателя) будет предоставляться значение(Текст письма, либо зарплата)
    Map<String, List<T>> MailBox;

    public Map<String, List<T>> getMailBox() {
        return this;
    }

    @Override
    public List get(Object key) {
        if (containsKey(key)) {
            return (List) super.get(key);
        } else {
            List list = new LinkedList<>();
            this.getMailBox().put((String) key, list);
            return list;
        }
    }
}