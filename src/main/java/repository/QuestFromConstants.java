package repository;

import model.Quest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestFromConstants implements QuestRepository{
    private final Map<Integer, Quest> quests_repository = new HashMap<>();

    @Override
    public void save(Quest quest) {
        quests_repository.put(quest.getId(), quest);
    }

    @Override
    public Quest findById(int id) {
        return quests_repository.get(id);
    }

    @Override
    public Collection<Quest> findAll() {
        return quests_repository.values();
    }
}
