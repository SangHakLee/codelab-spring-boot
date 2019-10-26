package kr.codelabs.member.service;

import kr.codelabs.member.entity.Member;
import kr.codelabs.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
//@RequiredArgsConstructor // 내가 주입하기 원하는 것만 선택 가능, 이거 쓰면 500 오류
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member Not found");
        }
        return member;
    }
}
