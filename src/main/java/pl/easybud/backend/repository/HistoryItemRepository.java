package pl.easybud.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.easybud.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
