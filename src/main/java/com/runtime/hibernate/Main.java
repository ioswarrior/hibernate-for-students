package com.runtime.hibernate;

import com.runtime.hibernate.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("Hibernate tutorial started");

        // Сразу получаем готовый SessionFactory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        log.info("Transaction start");

        User user = new User(); // состояние NEW (transient)
        user.setEmail("newfromapp8@gmail.com");
        user.setUsername("newfromapp8");
        user.setPassword("2asdfsdfsdf");
        // id не заполняем, т.к он сгенерится автоматически в БД и присвоится в поле

        session.save(user); // фиксирует изменения в объекте (состояние manager (persistent) - управляемый объект - контейнером Hibernate
        session.getTransaction().commit(); // сохранить изменения (когда коммитим - транзакция завершается)

        System.out.println("user.getId() = " + user.getId());

        session.close(); // закрыть сессию
        HibernateUtil.close();
    }
}