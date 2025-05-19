package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)   // JUnit4의 @RunWith 대체
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false) // 테스트케이스에선 원래 디비작업 후 롤백처리를 하는데 false 넣으면 롤백을 막음
    public void testMember() throws Exception{
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then 검증
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember==member : " + (findMember==member));

        entityManager.flush();
        entityManager.clear();
    }
}