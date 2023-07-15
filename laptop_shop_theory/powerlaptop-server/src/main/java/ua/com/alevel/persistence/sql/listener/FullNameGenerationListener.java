package ua.com.alevel.persistence.sql.listener;

import jakarta.persistence.PostLoad;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.persistence.sql.entity.user.User;

public class FullNameGenerationListener { // Listener перехватчик (интерсептор), отработает перед тем как из БД вернется объект юзера
// делает Постлоад - Прописывает фулнейм, т.к. этот филд @Transient

    @PostLoad   // когда будем грузить юзера из базы будет отработывать FullNameGenerationListener
    public void generateFullName(User user) {
        if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
            user.setFullName(user.getFirstName() + " " + user.getLastName());
        }
    }
}
