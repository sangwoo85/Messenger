package com.wooya.chatserver.db.mongodb.domain.user.repo;

import com.wooya.chatserver.db.mongodb.domain.user.model.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends MongoRepository<Position,String> {
}
