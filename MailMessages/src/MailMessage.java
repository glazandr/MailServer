import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MailMessage {
    public String From; // Отправитель
    public String To;   // Получатель
    public String Content; // Текст письма

    // Создадим констуктор письма
    public MailMessage(String From, String To, String Content) {
        this.From = From;
        this.To = To;
        this.Content = Content;
    }

    // Добавим геттеры и сеттеры для возможности создавать письма из класса Main
    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {

        this.Content = Content;
    }

    public <T> T getValue() {
        return (T) this.getContent();
    }
}


