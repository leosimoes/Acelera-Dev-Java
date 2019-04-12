package challenge;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories(basePackages = "challenge")
@Repository
public interface RecipeCommentRepository extends MongoRepository<RecipeComment, String> {

}
