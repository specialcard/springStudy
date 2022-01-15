package hello.studySpring.service;

import hello.studySpring.domain.Member;
import hello.studySpring.repository.MemberRepositoryIm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;

    MemberRepositoryIm memberRepository;

    //class method 실행전 실행  :: ex)useEffect()이랑 비슷
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemberRepositoryIm();
        memberService = new MemberService(memberRepository);
    }

    //class
    @AfterEach
    public  void  afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
//        assertThatThrownBy(IllegalStateException.class , () -> memberService.join(member2));
//        try {
//            memberService.join(member2);
//
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }
        //then
    }



    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}