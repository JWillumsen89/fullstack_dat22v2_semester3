/*package dat3.cars.service.members;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import dat3.cars.repository.MemberRepository;
import dat3.cars.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MemberServiceMockitoTest {

  @Mock
  MemberRepository memberRepository;

  MemberService memberService;

  @BeforeEach
  void setUp() {
    memberService = new MemberService(memberRepository);
  }

  @Test
  void getMembersAdmin() {
    //Need to create mock data for testing with mockito
    Member m1 = new Member("m1", "m1@a.dk", "test12", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    Member m2 = new Member("m2", "m2@a.dk", "test12", "aa", "hansen", "xx vej 34", "Lyngby", "2800");
    m1.setCreated(LocalDateTime.now());
    m2.setCreated(LocalDateTime.now());

    //Mockito use
    Mockito.when(memberRepository.findAll()).thenReturn(List.of(m1, m2));

    List<MemberResponse> members = memberService.getMembers(true);
    assertEquals(2, members.size());
    assertNotNull(members.get(0).getCreated());
  }

  @Test
  void getMembersNotAdmin() {
    //Need to create mock data for testing with mockito
    Member m1 = new Member("m1", "m1@a.dk", "test12", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    Member m2 = new Member("m2", "m2@a.dk", "test12", "aa", "hansen", "xx vej 34", "Lyngby", "2800");
    m1.setCreated(LocalDateTime.now());
    m2.setCreated(LocalDateTime.now());

    //Mockito use
    Mockito.when(memberRepository.findAll()).thenReturn(List.of(m1, m2));

    List<MemberResponse> members = memberService.getMembers(false);
    assertEquals(2, members.size());
    assertNull(members.get(0).getCreated());
  }


  @Test
  void addMember() {
    Member m1 = new Member("m1", "test12", "m1@a.dk", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    //If Id was generated by the server, for example as for car you would need to set the id here
    Mockito.when(memberRepository.save(any(Member.class))).thenReturn(m1);

    //Quick way to get a MemberRequest (remember eventually values come via a incoming JSON object)
    MemberRequest request = new MemberRequest(m1);

    MemberResponse response = memberService.addMember(request);
    assertEquals("m1@a.dk", response.getEmail());
  }


  @Test
  void getMembersByFirstName() {
    //Need to create mock data for testing with mockito
    Member m1 = new Member("m1", "m1@a.dk", "test12", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    m1.setCreated(LocalDateTime.now());


    //Mockito use
    List<Member> mockMembers = List.of(m1);
    Mockito.when(memberRepository.findMembersByFirstName("bb")).thenReturn(mockMembers);
    for (Member m : mockMembers) {
      System.out.println(m.getFirstName());
    }

    List<MemberResponse> members = memberService.getMembersByFirstName("bb", true);

    assertEquals(1, members.size());
    assertEquals("bb", members.get(0).getFirstName());
  }

  @Test
  void findMemberByUsername() {
    Member m1 = new Member("m1", "test12", "m1@a.dk", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    m1.setCreated(LocalDateTime.now());
    Mockito.when(memberRepository.findById("m1")).thenReturn(java.util.Optional.of(m1));

    MemberResponse response = memberService.getMemberByUsername("m1", false);
    assertEquals("m1@a.dk", response.getEmail());

  }

  @Test
  void setRankingValue() {
    Member m1 = new Member("m1", "m1@a.dk", "test12", "bb", "Olsen", "xx vej 34", "Lyngby", "2800");
    m1.setRanking(0);

    //This saves m1 to the repository
    Mockito.when(memberRepository.findById("m1")).thenReturn(Optional.of(m1));


    Mockito.when(memberRepository.save(any(Member.class))).thenReturn(m1);

    memberService.setRankingValue(m1.getUsername(), 5);

    assertEquals(5, m1.getRanking());
  }
}

 */