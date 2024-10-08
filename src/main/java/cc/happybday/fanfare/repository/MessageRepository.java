package cc.happybday.fanfare.repository;

import cc.happybday.fanfare.domain.Member;
import cc.happybday.fanfare.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findById(Long id);

    void deleteById(Long id);

    Message save(Message message);

    @Query("SELECT MAX(m.id) FROM Message m WHERE m.member.id = :memberId AND m.id < :messageId")
    Optional<Long> findBeforeMessageId(@Param("memberId") Long memberId, @Param("messageId") Long messageId);

    @Query("SELECT MIN(m.id) FROM Message m WHERE m.member.id = :memberId AND m.id > :messageId")
    Optional<Long> findNextMessageId(@Param("memberId") Long memberId, @Param("messageId") Long messageId);

    Optional<Long> countAllByMember_Id(Long memberId);

    @Query("SELECT COUNT(m) + 1 " +
            "FROM Message m " +
            "WHERE m.member.id = :memberId AND m.id < :messageId")
    Optional<Long> findMessagePosition(@Param("memberId") Long memberId, @Param("messageId") Long messageId);

    Page<Message> findAllByMember_IdOrderByCreatedAtAsc(Long memberId, Pageable pageable);

    void deleteAllByMember(Member member);


}
