package palindrome.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PalindromeDataRepository extends CrudRepository<PalindromeData, Integer> {
    @Override
    Optional<PalindromeData> findById(Integer integer);
    @Override
    <S extends PalindromeData> S save(S s);
    @Override
    Iterable<PalindromeData> findAll();
}
