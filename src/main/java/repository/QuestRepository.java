package repository;

import model.Quest;

import java.util.Collection;

public interface QuestRepository {
    void save(Quest quest);
    Quest findById(int id);
    Collection<Quest> findAll();
}
