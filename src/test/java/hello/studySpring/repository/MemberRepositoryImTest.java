package hello.studySpring.repository;

import hello.studySpring.domain.Member;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryImTest {
   MemberRepositoryIm repository = new MemberRepositoryIm();

   @AfterEach
   public void afterEach(){
      //afterEach => 메소트가 끝날때 마다 스토어 클리어
      repository.clearStore();
   }

   @Test
   public void save() {
      Member member = new Member();
      member.setName("spring");
      repository.save(member);
      Member result = repository.findById(member.getId()).get();
      //junit 제공
      //Assertions.assertEquals(member , result);

      //assertj.core.api 제공
      assertThat(member).isEqualTo(result);
      System.out.println("result = " + (result == member) + "    " + "result==" + result  + "member==" + member);

   }
   @Test
   public void findByName(){
      Member member1 = new Member();
      member1.setName("member1");
      repository.save(member1);

      Member member2 = new Member();
      member2.setName("member2");
      repository.save(member2);

      Member result = repository.findByName("member1").get();

      assertThat(result).isEqualTo(member1);
      System.out.println((result == member1));
   }

   @Test
   public void finAll(){
      Member member1 = new Member();
      member1.setName("member1");
      repository.save(member1);

      Member member2 = new Member();
      member2.setName("member2");
      repository.save(member2);

      List<Member> result = repository.findAll();

      assertThat(result.size()).isEqualTo(2);

   }
}
