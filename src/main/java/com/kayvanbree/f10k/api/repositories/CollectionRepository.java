package com.kayvanbree.f10k.api.repositories;

import com.kayvanbree.f10k.api.models.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, String> {}
